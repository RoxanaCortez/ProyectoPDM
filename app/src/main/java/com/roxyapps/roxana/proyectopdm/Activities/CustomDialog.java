package com.roxyapps.roxana.proyectopdm.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.roxyapps.roxana.proyectopdm.R;

public class CustomDialog extends Dialog implements
        android.view.View.OnClickListener{
    public Activity clase;
    public Dialog d;
    public Button ButtonYes, ButtonNo;

    public CustomDialog(Activity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.clase = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        ButtonYes = (Button) findViewById(R.id.btn_yes);
        ButtonNo = (Button) findViewById(R.id.btn_no);
        ButtonYes.setOnClickListener(this);
        ButtonNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                clase.finish();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
