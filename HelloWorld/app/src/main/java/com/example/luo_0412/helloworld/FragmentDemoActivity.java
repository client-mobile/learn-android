package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class FragmentDemoActivity extends Activity implements OnClickListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
//                Toast.makeText(this, "If You", Toast.LENGTH_SHORT).show();
			AnotherRightFragment fragment = new AnotherRightFragment();
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.right_fragment, fragment);
			transaction.addToBackStack(null);
			transaction.commit();
                break;
            default:
                break;
        }
    }


}
