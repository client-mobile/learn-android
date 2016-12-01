package space.qmen.hellou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Luo_0412 on 2016/12/1.
 */

public class EditStuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_stu);
    }
}
