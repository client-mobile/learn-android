package cn.luojs.uiwidgetsapp.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cal_num0_btn;
    private Button cal_num1_btn;
    private Button cal_num2_btn;
    private Button cal_num3_btn;
    private Button cal_num4_btn;
    private Button cal_num5_btn;
    private Button cal_num6_btn;
    private Button cal_num7_btn;
    private Button cal_num8_btn;
    private Button cal_num9_btn;
    private Button cal_point_btn;
    private Button cal_add_btn;
    private Button cal_sub_btn;
    private Button cal_mul_btn;
    private Button cal_div_btn;
    private Button cal_ce_btn;
    private Button cal_bs_btn;
    private Button cal_equal_btn;

    private TextView cal_input;

    double num1 = 0, num2 = 0;
    double result = 0;
    int op = 0;  // 判断操作数，
    boolean isClickEqu = false; // 是否按了"="按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_calculator);

        cal_input = (EditText) findViewById(R.id.cal_input);

        cal_num0_btn = (Button) findViewById(R.id.cal_num0_btn);
        cal_num1_btn = (Button) findViewById(R.id.cal_num1_btn);
        cal_num2_btn = (Button) findViewById(R.id.cal_num2_btn);
        cal_num3_btn = (Button) findViewById(R.id.cal_num3_btn);
        cal_num4_btn = (Button) findViewById(R.id.cal_num4_btn);
        cal_num5_btn = (Button) findViewById(R.id.cal_num5_btn);
        cal_num6_btn = (Button) findViewById(R.id.cal_num6_btn);
        cal_num7_btn = (Button) findViewById(R.id.cal_num7_btn);
        cal_num8_btn = (Button) findViewById(R.id.cal_num8_btn);
        cal_num9_btn = (Button) findViewById(R.id.cal_num9_btn);
        cal_point_btn = (Button) findViewById(R.id.cal_point_btn);
        cal_add_btn = (Button) findViewById(R.id.cal_add_btn);
        cal_sub_btn = (Button) findViewById(R.id.cal_sub_btn);
        cal_mul_btn = (Button) findViewById(R.id.cal_mul_btn);
        cal_div_btn = (Button) findViewById(R.id.cal_div_btn);
        cal_ce_btn = (Button) findViewById(R.id.cal_ce_btn);
        cal_bs_btn = (Button) findViewById(R.id.cal_bs_btn);
        cal_equal_btn = (Button) findViewById(R.id.cal_equal_btn);
        cal_num0_btn.setOnClickListener(this);
        cal_num1_btn.setOnClickListener(this);
        cal_num2_btn.setOnClickListener(this);
        cal_num3_btn.setOnClickListener(this);
        cal_num4_btn.setOnClickListener(this);
        cal_num5_btn.setOnClickListener(this);
        cal_num6_btn.setOnClickListener(this);
        cal_num7_btn.setOnClickListener(this);
        cal_num8_btn.setOnClickListener(this);
        cal_num9_btn.setOnClickListener(this);
        cal_point_btn.setOnClickListener(this);
        cal_add_btn.setOnClickListener(this);
        cal_sub_btn.setOnClickListener(this);
        cal_mul_btn.setOnClickListener(this);
        cal_div_btn.setOnClickListener(this);
        cal_ce_btn.setOnClickListener(this);
        cal_bs_btn.setOnClickListener(this);
        cal_equal_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cal_num0_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString=cal_input.getText().toString();
                myString+="0";
                cal_input.setText(myString);
                break;
            case R.id.cal_num1_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString1=cal_input.getText().toString();
                myString1+="1";
                cal_input.setText(myString1);
                break;
            case R.id.cal_num2_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString2=cal_input.getText().toString();
                myString2+="2";
                cal_input.setText(myString2);
                break;
            case R.id.cal_num3_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString3=cal_input.getText().toString();
                myString3+="3";
                cal_input.setText(myString3);
                break;
            case R.id.cal_num4_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString4=cal_input.getText().toString();
                myString4+="4";
                cal_input.setText(myString4);
                break;
            case R.id.cal_num5_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString5=cal_input.getText().toString();
                myString5+="5";
                cal_input.setText(myString5);
                break;
            case R.id.cal_num6_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString6=cal_input.getText().toString();
                myString6+="6";
                cal_input.setText(myString6);
                break;
            case R.id.cal_num7_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString7=cal_input.getText().toString();
                myString7+="7";
                cal_input.setText(myString7);
                break;
            case R.id.cal_num8_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString8=cal_input.getText().toString();
                myString8+="8";
                cal_input.setText(myString8);
                break;
            case R.id.cal_num9_btn:
                if(isClickEqu)
                {
                    cal_input.setText(null);
                    isClickEqu=false;
                }
                String myString9=cal_input.getText().toString();
                myString9+="9";
                cal_input.setText(myString9);
                break;
            case R.id.cal_point_btn:
                break;
            case R.id.cal_add_btn:
                String myStringAdd=cal_input.getText().toString();
                if(myStringAdd.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(myStringAdd);
                cal_input.setText(null);
                Toast.makeText(CalculatorActivity.this, "加上",
                        Toast.LENGTH_SHORT).show();
                op=1;
                isClickEqu=false;
                break;
            case R.id.cal_sub_btn:
                String myStringSub=cal_input.getText().toString();
                if(myStringSub.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(myStringSub);
                cal_input.setText(null);
                Toast.makeText(CalculatorActivity.this, "减去",
                        Toast.LENGTH_SHORT).show();
                op=2;
                isClickEqu=false;
                break;
            case R.id.cal_mul_btn:
                String myStringMul=cal_input.getText().toString();
                if(myStringMul.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(myStringMul);
                cal_input.setText(null);
                Toast.makeText(CalculatorActivity.this, "乘以",
                        Toast.LENGTH_SHORT).show();
                op=3;
                isClickEqu=false;
                break;
            case R.id.cal_div_btn:
                String myStringDiv=cal_input.getText().toString();
                if(myStringDiv.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(myStringDiv);
                cal_input.setText(null);
                Toast.makeText(CalculatorActivity.this, "除以",
                        Toast.LENGTH_SHORT).show();
                op=4;
                isClickEqu=false;
                break;
            case R.id.cal_ce_btn:
                cal_input.setText(null);
                break;
            case R.id.cal_bs_btn:
                String myStr = cal_input.getText().toString();
                try {
                    cal_input.setText(myStr.substring(0, myStr.length()-1));
                } catch (Exception e) {
                    cal_input.setText("");
                }
                break;
            case R.id.cal_equal_btn:
                String myStringEqu=cal_input.getText().toString();
                if(myStringEqu.equals(null))
                {
                    return;
                }
                num2=Double.valueOf(myStringEqu);
                cal_input.setText(null);
                switch (op) {
                    case 0:
                        result = num2;
                        break;
                    case 1:
                        result = num1 + num2;
                        break;
                    case 2:
                        result = num1 - num2;
                        break;
                    case 3:
                        result = num1 * num2;
                        break;
                    case 4:
                        result = num1 / num2;
                        break;
                }
                cal_input.setText(String.valueOf(result));
                isClickEqu=true;
                break;
            default:
                break;
        }
    }
}
