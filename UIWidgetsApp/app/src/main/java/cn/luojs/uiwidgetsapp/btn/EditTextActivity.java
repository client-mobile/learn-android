package cn.luojs.uiwidgetsapp.btn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class EditTextActivity extends AppCompatActivity {
    private Button edit_ctl_btn;
    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_edittext);
        edit_text = (EditText) findViewById(R.id.demo_edittext);
        edit_ctl_btn = (Button) findViewById(R.id.edit_ctl_btn);
        edit_ctl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_val = edit_text.getText().toString();
                Toast.makeText(EditTextActivity.this, edit_val, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
