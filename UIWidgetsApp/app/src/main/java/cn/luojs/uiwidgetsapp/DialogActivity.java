package cn.luojs.uiwidgetsapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alert_dialog_btn;
    private Button progress_dialog_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_dialog);

        alert_dialog_btn = (Button)findViewById(R.id.alert_dialog_btn);
        alert_dialog_btn.setOnClickListener(this);
        progress_dialog_btn = (Button)findViewById(R.id.progress_dialog_btn);
        progress_dialog_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alert_dialog_btn:
                AlertDialog.Builder dialog = new AlertDialog.Builder
                        (DialogActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface. OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.progress_dialog_btn:
                ProgressDialog progressDialog = new ProgressDialog
                        (DialogActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
        }
    }
}