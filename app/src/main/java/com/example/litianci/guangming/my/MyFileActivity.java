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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.MyFileResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.bean.WenJianBean;
import com.example.litianci.guangming.utils.AlertUtil;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.ImageUtil;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.views.CircularImage;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class MyFileActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_tx)
    CircularImage ivTx;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_zhiwu)
    TextView tvZhiwu;
    @Bind(R.id.tv_birth)
    TextView tvBirth;
    @Bind(R.id.tv_officephone)
    TextView tvOfficephone;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_zhuzaiphone)
    TextView tvZhuzaiphone;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.tv_sfznumber)
    TextView tvSfznumber;
    @Bind(R.id.tv_cjgzsj)
    TextView tvCjgzsj;
    @Bind(R.id.tv_synj)
    TextView tvSynj;
    @Bind(R.id.tv_Addr)
    TextView tvAddr;
    @Bind(R.id.iv_erweima)
    ImageView ivErweima;
    private List<MyFileResult.RstBean.ListBean> result;
    private AlertUtil au;
    private String pathImage;
    private RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_my_file);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        ivTx.setOnClickListener(this);
        ImageLoader.getInstance().displayImage(User.IconPath, ivTx);
        ImageLoader.getInstance().displayImage(User.IconPath, ivErweima);
        getRequest();
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"MyFile\",\"Para\": {\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                MyFileResult s3 = GsonUtils.json2bean(response, MyFileResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(MyFileActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    result = s3.getRst().getList();
                    tvAddr.setText(result.get(0).getAddr());
                    tvBirth.setText(result.get(0).getBirthday());
                    tvCjgzsj.setText(result.get(0).getCjgznx());
                    tvDept.setText(result.get(0).getDeptName());
                    tvEmail.setText(result.get(0).getEmail());
                    tvName.setText(User.name);
                    tvOfficephone.setText(result.get(0).getOfficePhone());
                    tvPhone.setText(result.get(0).getMobile());
                    tvSfznumber.setText(result.get(0).getIdentifyNum());
                    tvSynj.setText(result.get(0).getSynj());
                    tvZhiwu.setText(result.get(0).getRank());
                    tvZhuzaiphone.setText(result.get(0).getHomePhone());
                    ImageLoader.getInstance().displayImage(result.get(0).getQR(), ivErweima);

                }
                return false;
            }
        }.volleyStringRequestPost(MyFileActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tx: {
                Intent intent = new Intent(MyFileActivity.this, UploadHeadActivity.class);
                startActivityForResult(intent, 2);
            }
            break;
            case R.id.iv_back: {
                finish();
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
//                        pathImage = getRealFilePath(MyFileActivity.this, mImageCaptureUri);
//                        Log.i("zhang", "上传图片的路径是：++++++++++"+pathImage);
////                        suri.add(getRealFilePath(this, mImageCaptureUri));
//                        Log.i("tupiance", "获取到相册的图片");
//                    } else {
                    if (data.getStringExtra("ok") != null) {
                        Log.i("tupiance", "获得拍照的图片");
                        String uri = data.getStringExtra("ok");
                        Uri imageUri = Uri.parse(uri);
                        pathImage = getRealFilePath(MyFileActivity.this, imageUri);
//                                suri.add(getRealFilePath(this, imageUri));
                    }
//                    }

                }
                break;
        }

    }
    private void imageTj() {
        au = new AlertUtil(MyFileActivity.this);
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


        client.post(MyFileActivity.this, Globals.WS_URI_POTO, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String s = new String(bytes);
                WenJianBean s1 = GsonUtils.json2bean(s.toString(),
                        WenJianBean.class);
                if (s1 == null || !(s1.getStu() == 1)) {
                    Toast.makeText(MyFileActivity.this, Globals.SER_ERROR,
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
                Toast.makeText(MyFileActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
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
        AppUtil.initLogin(MyFileActivity.this);
        super.onResume();
        if (!TextUtils.isEmpty(pathImage)) {
            Bitmap addbmp = ImageUtil.getSmallBitmap(pathImage);
            ivTx.setImageBitmap(addbmp);
            imageTj();
        }
    }
}
