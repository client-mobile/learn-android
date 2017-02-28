package cn.luojs.uiwidgetsapp.btn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/11/11.
 */


public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar circle_pgbar;
    private ProgressBar normal_pgbar;
    private Button circle_pgbar_btn;
    private Button normal_pgbar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_progressbar);

        circle_pgbar = (ProgressBar)findViewById(R.id.circle_pgbar);
        normal_pgbar = (ProgressBar)findViewById(R.id.normal_pgbar);
        circle_pgbar_btn = (Button)findViewById(R.id.circle_pgbar_btn);
        circle_pgbar_btn.setOnClickListener(this);
        normal_pgbar_btn = (Button)findViewById(R.id.normal_pgbar_btn);
        normal_pgbar_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circle_pgbar_btn:
                if (circle_pgbar.getVisibility() == View.GONE) {
                    circle_pgbar.setVisibility(View.VISIBLE);
                }
                else {
                    circle_pgbar.setVisibility(View.GONE);
                }
                break;
            case R.id.normal_pgbar_btn:
                int progress = normal_pgbar.getProgress();
                progress = progress + 10;
                normal_pgbar.setProgress(progress);
                break;
        }
    }


}
