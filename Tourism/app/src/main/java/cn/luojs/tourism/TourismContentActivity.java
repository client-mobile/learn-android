package cn.luojs.tourism;

/**
 * Created by Luo_0412 on 2016/11/3.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class TourismContentActivity extends Activity {

    public static void actionStart(Context context, String tourismName,
                                   String tourismContent, int tourismImageId) {
        Intent intent = new Intent(context, TourismContentActivity.class);
        intent.putExtra("tourism_name", tourismName);
        intent.putExtra("tourism_content",  tourismContent);
        intent.putExtra("tourism_imageId",  tourismImageId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tourism_content);
        String tourismName = getIntent().getStringExtra("tourism_name"); // 获取标题
        String tourismContent = getIntent().getStringExtra("tourism_content"); // 获取内容
        int tourismImage = getIntent().getIntExtra("tourism_imageId", R.drawable.great_wall); // 获取内容

        TourismContentFragment tourismContentFragment =
                (TourismContentFragment) getFragmentManager().findFragmentById(R.id.tourism_content_fragment);
        tourismContentFragment.refresh(tourismName, tourismContent, tourismImage); // 刷新界面
    }

}

