package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class SayHelloActivity extends Activity implements OnClickListener {

    private Button say_hello_btn;
    private TextView say_hello_text;
    private EditText say_hello_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_say_hello);

        say_hello_btn = (Button) findViewById(R.id.say_hello_btn);
        say_hello_btn.setOnClickListener(this);

        say_hello_text = (TextView)findViewById(R.id.say_hello_text);
        say_hello_input = (EditText)findViewById(R.id.say_hello_input);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.say_hello_btn:
                String str = say_hello_input.getText().toString();
                say_hello_text.setText("Hello," + str);
                break;
            default:
                break;
        }
    }


}