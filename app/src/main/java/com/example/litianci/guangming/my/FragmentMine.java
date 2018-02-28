package com.example.litianci.guangming.my;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.LoginActivity;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.bean.WenJianBean;
import com.example.litianci.guangming.home.LeaveActivity;
import com.example.litianci.guangming.home.YongZhangActivity;
import com.example.litianci.guangming.utils.AlertUtil;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.ImageUtil;
import com.example.litianci.guangming.utils.SharedPreferencesUtils;
import com.example.litianci.guangming.views.DeleteF;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

/**
 * @创建人：李井宇
 * @创建时间：2017.11.01
 * @用途：我的fragment
 */

public class FragmentMine extends Fragment implements View.OnClickListener {
    @Bind(R.id.iv_tx)
    ImageView ivTx;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.ll_dangan)
    RelativeLayout llDangan;
    @Bind(R.id.ll_caogao)
    RelativeLayout llCaogao;
    @Bind(R.id.ll_qingjia)
    RelativeLayout llQingjia;
    @Bind(R.id.ll_yongzhang)
    RelativeLayout llYongzhang;
    @Bind(R.id.ll_mima)
    RelativeLayout llMima;
    @Bind(R.id.ll_touxiang)
    RelativeLayout llTouxiang;
    @Bind(R.id.ll_jiance)
    RelativeLayout llJiance;
    @Bind(R.id.ll_gengxin)
    RelativeLayout llGengxin;
    @Bind(R.id.ll_exit)
    RelativeLayout llExit;
    private AlertUtil au;
    private String pathImage;
    private RequestParams params;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, view);
        ImageLoader.getInstance().displayImage(User.IconPath, ivTx);
        tvName.setText(User.name);
        tvDept.setText(User.depname);
        setOnClick();
        return view;
    }

    public void setOnClick() {
        llDangan.setOnClickListener(this);
        llCaogao.setOnClickListener(this);
        llCaogao.setVisibility(View.GONE);
        llQingjia.setOnClickListener(this);
        llYongzhang.setOnClickListener(this);
        llMima.setOnClickListener(this);
        llTouxiang.setOnClickListener(this);
        llJiance.setOnClickListener(this);
        llJiance.setVisibility(View.GONE);
        llGengxin.setOnClickListener(this);
        llGengxin.setVisibility(View.GONE);
        llExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_dangan: {
                Intent intent = new Intent(getActivity(), MyFileActivity.class);
                startActivity(intent);
            }
            break;
//            case R.id.ll_caogao: {
//                Intent intent = new Intent(getActivity(), DraftsActivity.class);
//                startActivity(intent);
//            }
//            break;
            case R.id.ll_qingjia: {
                Intent intent = new Intent(getActivity(), MyLeaveActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.ll_yongzhang: {
                Intent intent = new Intent(getActivity(), MyYongZhangActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.ll_mima: {
                Intent intent = new Intent(getActivity(), EditPwdActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.ll_touxiang: {
                Intent intent = new Intent(getActivity(), UploadHeadActivity.class);
                startActivityForResult(intent, 2);
            }
            break;
            case R.id.ll_jiance: {
                Intent intent = new Intent(getActivity(), LeaveActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.ll_gengxin: {
                Intent intent = new Intent(getActivity(), LeaveActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.ll_exit: {


                if (User.isLogin) {
                    DeleteF d = new DeleteF() {
                        @Override
                        public void determineButton() {
                            SharedPreferencesUtils.saveString(getActivity(),
                                    Globals.USER_PHONE, "");
                            SharedPreferencesUtils.saveString(getActivity(),
                                    Globals.USER_PASSWORD, "");

                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            getActivity().finish();
                            intent.putExtra("type", "注销");
                            startActivity(intent);
                            User.setLoginInfo("", "", "", "", "", "");
                        }
                    }.deleteDialog(getActivity(), "你确定要退出当前账号？", "", "");
                }


            }
            break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {

            case 2:
                Log.i("tupiance", "图片上传");
                if (data != null) {
                    // 取得返回的Uri,基本上选择照片的时候返回的是以Uri形式，但是在拍照中有得机子呢Uri是空的，所以要特别注意
                    Uri mImageCaptureUri = data.getData();
//                    Log.i("s123s", AppUtil.getRealFilePath(this, mImageCaptureUri));


                    // 返回的Uri不为空时，那么图片信息数据都会在Uri中获得。如果为空，那么我们就进行下面的方式获取
//                    if (mImageCaptureUri != null) {
//                        pathImage = getRealFilePath(getActivity(), mImageCaptureUri);
//                        Log.i("zhang", "上传图片的路径是：++++++++++"+pathImage);
////                        suri.add(getRealFilePath(this, mImageCaptureUri));
//                        Log.i("tupiance", "获取到相册的图片");
//                    } else {
                    if (data.getStringExtra("ok") != null) {
                        Log.i("tupiance", "获得拍照的图片");
                        String uri = data.getStringExtra("ok");
                        Uri imageUri = Uri.parse(uri);
                        pathImage = getRealFilePath(getActivity(), imageUri);
//                                suri.add(getRealFilePath(this, imageUri));
                    }
//                    }

                }
                break;
        }

    }

    private void imageTj() {
        au = new AlertUtil(getActivity());
        AsyncHttpClient client = new AsyncHttpClient();
        params = new RequestParams();
        Log.i("sid", User.sid);
        String req = "{\"Ac\":\"TPSC\",\"Para\":{\"SId\":\""
                + User.sid + "\",\"T\":\"1\"}}";
        params.put("id", req);
        //设置文件


        try {
            File imgFile = new File(Environment.getExternalStorageDirectory().toString() + "/zhtztp.jpg");
//            FileOutputStream fos = new FileOutputStream(imgFile);
//            ImageUtil.getSmallBitmap(pathImage).compress(Bitmap.CompressFormat.JPEG, 100, fos);
//            fos.flush();
//            fos.close();
            params.put("MyImg.png", imgFile, "image/jpeg");
        } catch (IOException e) {
            e.printStackTrace();
        }


        client.post(getActivity(), Globals.WS_URI_POTO, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String s = new String(bytes);
                WenJianBean s1 = GsonUtils.json2bean(s.toString(),
                        WenJianBean.class);
                if (s1 == null || !(s1.getStu() == 1)) {
                    Toast.makeText(getActivity(), Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();
                } else {
                    String ss = "sssss";
                    Log.i("swww1", "成功---" + s.toString());
                    User.IconPath = s1.getRst().getPo();
                }


                au.closeDialog();
//                finish();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.i("swww2", throwable.getMessage());
                Log.i("swww3", throwable.toString());
                Toast.makeText(getActivity(), "服务器异常", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //将uri转换成String形式
    public static String getRealFilePath(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    @Override
    public void onResume() {
        AppUtil.initLogin(getActivity());
        super.onResume();
        if (!TextUtils.isEmpty(pathImage)) {
            Bitmap addbmp = ImageUtil.getSmallBitmap(pathImage);
            ivTx.setImageBitmap(addbmp);
            imageTj();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
