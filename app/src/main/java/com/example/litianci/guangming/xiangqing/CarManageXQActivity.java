package com.example.litianci.guangming.xiangqing;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.CarManageResult;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.fourmob.datetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CarManageXQActivity extends FragmentActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_caozuo)
    TextView tvCaozuo;
    @Bind(R.id.et_checkcartime)
    EditText etCheckcartime;
    @Bind(R.id.et_shenpiren)
    EditText etShenpiren;
    @Bind(R.id.et_cartype)
    EditText etCartype;
    @Bind(R.id.et_baoxiantime)
    EditText etBaoxiantime;
    @Bind(R.id.et_carnum)
    EditText etCarnum;
    @Bind(R.id.et_isreturn)
    EditText etIsreturn;
    @Bind(R.id.et_remark)
    EditText etRemark;
    @Bind(R.id.et_fanwei)
    EditText etFanwei;
    @Bind(R.id.btn_send)
    Button btnSend;

    /**
     * 用户预定会议的时候选择日期
     */
    final Calendar calendar = Calendar.getInstance();
    final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance((DatePickerDialog.OnDateSetListener) this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), true);
    final DatePickerDialog datePickerDialog2 = new DatePickerDialog();

    public static final String DATEPICKER_TAG = "datepicker";
    @Bind(R.id.ll_shenpiren)
    LinearLayout llShenpiren;
    @Bind(R.id.ll_shenpirenline)
    LinearLayout llShenpirenline;
    @Bind(R.id.ll_ishuanche)
    LinearLayout llIshuanche;
    @Bind(R.id.ll_ishuancheline)
    LinearLayout llIshuancheline;
    @Bind(R.id.ll_fanwei)
    LinearLayout llFanwei;
    /**
     * 获得的月
     */
    private String acquisitionMoth;
    /**
     * 获得的日
     */
    private String acquisitionDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_car_manage_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        llFanwei.setVisibility(View.GONE);
        llIshuanche.setVisibility(View.GONE);
        llIshuancheline.setVisibility(View.GONE);
        llShenpiren.setVisibility(View.GONE);
        llShenpirenline.setVisibility(View.GONE);
        if (getIntent().getStringExtra("type").equals("详情")) {
            etIsreturn.setHint("");
            etShenpiren.setHint("");
            etRemark.setHint("");
            etCheckcartime.setHint("");
            etFanwei.setHint("");
            etBaoxiantime.setHint("");
            etCarnum.setHint("");
            etCartype.setHint("");
            getRequest();
        } else {
            tvTitle.setText("增加车辆");
            llFanwei.setVisibility(View.GONE);
            llIshuanche.setVisibility(View.GONE);
            llIshuancheline.setVisibility(View.GONE);
            llShenpiren.setVisibility(View.GONE);
            llShenpirenline.setVisibility(View.GONE);
            etCarnum.setFocusableInTouchMode(true);
            etCarnum.setFocusable(true);
            etCarnum.requestFocus();


            etFanwei.setFocusableInTouchMode(true);
            etFanwei.setFocusable(true);
            etFanwei.requestFocus();

            etRemark.setFocusableInTouchMode(true);
            etRemark.setFocusable(true);
            etRemark.requestFocus();

            etIsreturn.setFocusableInTouchMode(true);
            etIsreturn.setFocusable(true);
            etIsreturn.requestFocus();

            etBaoxiantime.setFocusableInTouchMode(true);
            etBaoxiantime.setFocusable(false);
            etBaoxiantime.requestFocus();
            etBaoxiantime.setOnClickListener(this);

            etCartype.setFocusableInTouchMode(true);
            etCartype.setFocusable(true);
            etCartype.requestFocus();

            etCheckcartime.setFocusableInTouchMode(true);
            etCheckcartime.setFocusable(false);
            etCheckcartime.requestFocus();
            etCheckcartime.setOnClickListener(this);

            etShenpiren.setFocusableInTouchMode(true);
            etShenpiren.setFocusable(true);
            etShenpiren.requestFocus();

            etIsreturn.setHint("是否归还");
            etShenpiren.setHint("填写审批人");
            etRemark.setHint("填写备注");
            etCheckcartime.setHint("点击选择时间");
            etFanwei.setHint("填写范围");
            etBaoxiantime.setHint("点击选择时间");
            etCarnum.setHint("填写车牌");
            etCartype.setHint("填写车类型");
            tvCaozuo.setText("保存");
        }
        tvCaozuo.setOnClickListener(this);
        btnSend.setOnClickListener(this);


    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"CarDetail\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(CarManageXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    etCheckcartime.setText(s3.getRst().getList().get(0).getYancheriqi());
                    etShenpiren.setText(s3.getRst().getList().get(0).getExaminer());
                    etCartype.setText(s3.getRst().getList().get(0).getMotorcycletype());
                    etBaoxiantime.setText(s3.getRst().getList().get(0).getBaoxiandaoqiriqi());
                    etIsreturn.setText(s3.getRst().getList().get(0).getIsreturn());
                    etCarnum.setText(s3.getRst().getList().get(0).getLicensenub());
                    etRemark.setText(s3.getRst().getList().get(0).getRemark());
                    etFanwei.setText(s3.getRst().getList().get(0).getFanwei());


                }
                return false;
            }
        }.volleyStringRequestPost(CarManageXQActivity.this, params, "app?", null);
    }

    public void bianji() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"CarEdit\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\",\"Licensenub\": \"" + etCartype.getText().toString().trim() + "\",\"Yancheriqi\": \"" + etCheckcartime.getText().toString().trim() + "\",\"Examiner\": \"" + etShenpiren.getText().toString().trim() + "\",\"Motorcycletype\": \"" + etCartype.getText().toString().trim() + "\",\"Baoxiandaoqiriqi\": \"" + etBaoxiantime.getText().toString().trim() + "\",\"Isreturn\": \"" + etBaoxiantime.getText().toString().trim() + "\",\"Remark\": \"" + etRemark.getText().toString().trim() + "\",\"Fanwei\": \"" + etFanwei.getText().toString().trim() + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(CarManageXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CarManageXQActivity.this, s3.getRst().getMsg(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                return false;
            }
        }.volleyStringRequestPost(CarManageXQActivity.this, params, "app?", null);
    }

    public void Addcar() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"CarAdd\",\"Para\": {\"Licensenub\": \"" + etCarnum.getText().toString().trim() + "\",\"Yancheriqi\": \"" + etCheckcartime.getText().toString().trim() + "\",\"Examiner\": \"" + etShenpiren.getText().toString().trim() + "\",\"Motorcycletype\": \"" + etCartype.getText().toString().trim() + "\",\"Baoxiandaoqiriqi\": \"" + etBaoxiantime.getText().toString().trim() + "\",\"Remark\": \"" + etRemark.getText().toString().trim() + "\",\"Fanwei\": \"" + etFanwei.getText().toString().trim() + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(CarManageXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CarManageXQActivity.this, s3.getRst().getMsg(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                return false;
            }
        }.volleyStringRequestPost(CarManageXQActivity.this, params, "app?", null);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_caozuo: {
                if (getIntent().getStringExtra("type").equals("详情")) {
                    etCarnum.setFocusableInTouchMode(true);
                    etCarnum.setFocusable(true);
                    etCarnum.requestFocus();

                    etFanwei.setFocusableInTouchMode(true);
                    etFanwei.setFocusable(true);
                    etFanwei.requestFocus();

                    etRemark.setFocusableInTouchMode(true);
                    etRemark.setFocusable(true);
                    etRemark.requestFocus();

                    etIsreturn.setFocusableInTouchMode(true);
                    etIsreturn.setFocusable(true);
                    etIsreturn.requestFocus();

                    etBaoxiantime.setFocusableInTouchMode(true);
                    etBaoxiantime.setFocusable(true);
                    etBaoxiantime.requestFocus();

                    etCartype.setFocusableInTouchMode(true);
                    etCartype.setFocusable(true);
                    etCartype.requestFocus();

                    etCheckcartime.setFocusableInTouchMode(true);
                    etCheckcartime.setFocusable(true);
                    etCheckcartime.requestFocus();

                    etShenpiren.setFocusableInTouchMode(true);
                    etShenpiren.setFocusable(true);
                    etShenpiren.requestFocus();

                    etIsreturn.setHint("是否归还");
                    etShenpiren.setHint("填写审批人");
                    etRemark.setHint("填写备注");
                    etCheckcartime.setHint("点击选择时间");
                    etFanwei.setHint("填写范围");
                    etBaoxiantime.setHint("点击选择时间");
                    etCarnum.setHint("填写车牌");
                    etCartype.setHint("填写车类型");

                    btnSend.setVisibility(View.VISIBLE);

                } else {

                    Addcar();
                }
            }
            break;
            case R.id.btn_send: {
                bianji();
            }
            break;
            case R.id.et_checkcartime: {
                datePickerDialog.setVibrate(true);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.setCloseOnSingleTapDay(true);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
            break;
            case R.id.et_baoxiantime: {
                datePickerDialog2.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                        if (month == 12) {
                            month = 1;
                        } else {
                            month++;
                        }
                        if (month < 10) {
                            acquisitionMoth = "0" + month;
                        } else {
                            acquisitionMoth = "" + month;
                        }
                        if (day < 10) {
                            acquisitionDay = "0" + day;
                        } else {
                            acquisitionDay = "" + day;
                        }
                        etBaoxiantime.setText(year + "-" + acquisitionMoth + "-" + acquisitionDay);
                    }
                });
                datePickerDialog2.setVibrate(true);
                datePickerDialog2.setYearRange(1985, 2028);
                datePickerDialog2.setCloseOnSingleTapDay(true);
                datePickerDialog2.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
            break;
            default:
                break;
        }
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        if (month == 12) {
            month = 1;
        } else {
            month++;
        }
        if (month < 10) {
            acquisitionMoth = "0" + month;
        } else {
            acquisitionMoth = "" + month;
        }
        if (day < 10) {
            acquisitionDay = "0" + day;
        } else {
            acquisitionDay = "" + day;
        }
        etCheckcartime.setText(year + "-" + acquisitionMoth + "-" + acquisitionDay);


    }


}
