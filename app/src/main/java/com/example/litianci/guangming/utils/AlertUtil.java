package com.example.litianci.guangming.utils;

import android.app.AlertDialog;
import android.content.Context;

import com.example.litianci.guangming.R;


public class AlertUtil {

    private AlertDialog dialog;
    private Context context;
private int id=1;
    public AlertUtil(Context context) {
        this.context = context;
        alert();
    }
    public AlertUtil(Context context, int id) {
        this.context = context;
        this.id = id;
        alert();
    }

    public void alert() {
        dialog = new AlertDialog.Builder(context, R.style.dialog).create();
//        context.getAssets()
        try {
            if (context != null) {
                dialog.show();
                if (id ==1){
                    dialog.getWindow().setContentView(R.layout.loading);
                }else{
                    dialog.getWindow().setContentView(R.layout.loading1);
                }


            }
        } catch (Exception e) {
        }

    }

    public void closeDialog() {
        try {
            if (dialog != null && context != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {
        }


    }

}