package com.example.litianci.guangming.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.litianci.guangming.utils.wwj.net.download.DownloadProgressListener;
import com.example.litianci.guangming.utils.wwj.net.download.FileDownloader;
import com.example.litianci.guangming.views.DeleteFactory;
import com.example.litianci.guangming.views.MasterLayout;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 下载附件使用的帮助类
 * 下载加载的动态实现
 */
public class XiaZaiUtil {
    /**
     * 控制判断下载成功更新
     */
    private static final int PROCESSING = 1;
    /**
     * 控制下载下载失败的标志
     */
    private static final int FAILURE = -1;
    /**
     * 动态加载数据的布局
     */
    private MasterLayout masterLayout;
    /**
     * 显示下载速度的控件
     */
    private TextView textView;
    /**
     * 异步加载数据的handler的消息通信机制
     */
    private Handler handler = new UIHandler();
    /**
     * 文件总大小
     */
    private float fileSize;
    /**
     * 下载的文件
     */
    private File file;
    /**
     * 打开使用的图片button
     */
    private ImageButton imagebutton;
    /**
     * 传递的上下文对象
     */
    private Context context;
    /**
     * 下载文件的地址
     */
    private String uri;

    /**文件名字*/
    private String fName;
    /**文件的唯一标识*/
    private String pk;
    /**上传按钮*/




    /**
     * 现在帮助类的构造方法
     */
    public XiaZaiUtil(ImageButton imagebutton, Context context, String uri, MasterLayout masterLayout, TextView textView , String name, String pk) {
        this.imagebutton = imagebutton;
        this.context = context;
        this.uri = uri;
        this.masterLayout = masterLayout;
        this.textView = textView;
        this.fName = name;
        this.pk = pk;
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            //申请WRITE_EXTERNAL_STORAGE权限
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, );
//        }
        KaiShi();

    }

    private MasterLayout SyMasterLayout(MasterLayout masterLayout) {
        return masterLayout;
    }

    int i =0;
    /**
     * handler消息传递机制更新进度（下载）
     */
    private final class UIHandler extends Handler implements View.OnClickListener {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PROCESSING: // 更新进度

                    //获得下载的进度
                    int size = msg.getData().getInt("size");

                    int i2=(size-i)/1024;
                    i=size;
                    textView.setText(i2+"kb/s");
                    //progressBar.setProgress(msg.getData().getInt("size"));
                    float num = (float) size
                            / fileSize;
                    int result = (int) (num * 100); // 计算进度

                    Log.i("zhang", "文件下载：" + size + "文件总大小" + fileSize);
                    masterLayout.cusview.setupprogress(result);
                    //resultView.setText(result + "%");
                    if (size == fileSize) {
                        try {
                            DeleteFactory d = new DeleteFactory() {
                                @Override
                                public void determineButton() {
                                    Intent intent = AppUtil.getFileIntent(file);
                                    context.startActivity(intent);
                                }
                            }.deleteDialog(context, "下载完成", "", "");

//                            SharedPreferencesUtils.saveString(context,
//                                    pk, "");
                        }catch (Exception e){
                            Log.i("zhang", "出错了");
                        }

//                        Toast.makeText(context, "下载完成",
//                                Toast.LENGTH_LONG).show();
                        masterLayout.setVisibility(View.GONE);
                        imagebutton.setVisibility(View.VISIBLE);
                        imagebutton.setOnClickListener(this);
                        textView.setVisibility(View.GONE);
                    }
                    break;
                case FAILURE: // 下载失败
                    Toast.makeText(context, "下载失败",
                            Toast.LENGTH_LONG).show();
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            //当点击打开 调用系统的程序打开文件
            Intent intent = AppUtil.getFileIntent(file);
            context.startActivity(intent);
        }
    }

    /**
     * 当标志改变的时候给用户提示 不同的下载的状态给于提示 当切换的时候改变标志
     *
     * @author ZJP
     * created at 2016/2/17 9:37
     */
    public void KaiShi() {
        //Onclick listener of the progress button
        masterLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                masterLayout.animation();
                //正在下载情况
                if (masterLayout.flg_frmwrk_mode == 1) {
//                    AppUtil.fileIsExists(Environment.getExternalStorageDirectory() + "/zhtzwj/" + filename)

                    Toast.makeText(context,
                            "开始下载", Toast.LENGTH_SHORT)
                            .show();
                    //开始下载文件
                    XiaZaik(uri);
                }
                //暂停下载情况
                if (masterLayout.flg_frmwrk_mode == 2) {
//					暂停下载
                    exit();
                    masterLayout.reset();
                    Toast.makeText(context,
                            "下载暂停", Toast.LENGTH_SHORT)
                            .show();

                }
                //下载完成情况
                if (masterLayout.flg_frmwrk_mode == 3) {
//
                    Toast.makeText(context,
                            "下载完成", Toast.LENGTH_SHORT)
                            .show();
//                    DeleteFactory d = new DeleteFactory() {
//                        @Override
//                        public void determineButton() {
//
//                        }
//                    }.deleteDialog(context, "下载完成", "", "");

                }
            }
        });
    }





    /**
     * 开始下载将文件下载的地址 和文件到本地的路径
     */
    private void XiaZaik(String uri) {
        String path = uri;
        //String path = "http://m.ql18.com.cn/hpf10/1.pdf";
        String filename = path.substring(path.lastIndexOf('/') + 1);
        Log.i("peng", "filename" + filename);

        try {
            // URL编码（这里是为了将中文进行URL编码）
            filename = URLEncoder.encode(filename, "UTF-8");
            Log.i("peng", "filename2" + filename);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        path = path.substring(0, path.lastIndexOf("/") + 1) + filename;

        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            // File savDir =
            // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            // 保存路径
            String savDir = Environment.getExternalStorageDirectory().toString()+"/zhtzwj";
            File savDirs = new File(savDir);
            //下载设置使用 文件的下载地址和文件的下载路径
            download(path, savDirs);
        } else {
            Toast.makeText(context,
                    "没有SD卡", Toast.LENGTH_LONG).show();
        }
    }

    private DownloadTask task;

    /**
     * 暂停下载使用
     */
    private void exit() {
        if (task != null)
            task.exit();
    }

    /**
     * 下载文件的使用  文件的下载地址和下载文件的路径
     */
    private void download(String path, File savDir) {
        task = new DownloadTask(path, savDir);
        //开始下载
        new Thread(task).start();
    }

    /**
     * UI控件画面的重绘(更新)是由主线程负责处理的，如果在子线程中更新UI控件的值，更新后的值不会重绘到屏幕上
     * 一定要在主线程里更新UI控件的值，这样才能在屏幕上显示出来，不能在子线程中更新UI控件的值
     */
    private final class DownloadTask implements Runnable {
        private String path;
        private File saveDir;
        private FileDownloader loader;

        public DownloadTask(String path, File saveDir) {
            this.path = path;
            this.saveDir = saveDir;
        }

        /**
         * 退出下载
         */
        public void exit() {
            if (loader != null)
                loader.exit();
        }

        /**
         * 获得当前下载的文件大小 发送消息更新进度
         */
        DownloadProgressListener downloadProgressListener = new DownloadProgressListener() {
            @Override
            public void onDownloadSize(int size) {
                Message msg = new Message();
                msg.what = PROCESSING;
                msg.getData().putInt("size", size);
                handler.sendMessage(msg);
            }
        };

        /**
         * 下载使用的线程
         */
        public void run() {
            try {

                //实例化一个文件下载器
                loader = new FileDownloader(context, path,
                        saveDir, 3,fName);

                // 设置进度条最大值
                // 获得文件长度
                fileSize = (float) loader.getFileSize();
                file = loader.getFile();
                Log.i("jian", "下载的路径:" + file.getPath());
                Log.i("jian", "下载的name:" + file.getName());
                loader.download(downloadProgressListener);

            } catch (Exception e) {
                e.printStackTrace();
                Log.i("zhang", "run: "+e.toString());
                handler.sendMessage(handler.obtainMessage(FAILURE)); // 发送一条空消息对象
            }
        }
    }


}
