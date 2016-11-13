package cn.luojs.uiwidgetsapp.menu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import cn.luojs.uiwidgetsapp.R;
import cn.luojs.uiwidgetsapp.frag.DLLeftFragment;
import cn.luojs.uiwidgetsapp.frag.DLRightFragment;

public class DrawerLayout2Activity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private FrameLayout fly_content;
    private View topbar;
    private Button btn_right;
    private DLRightFragment fg_right_menu;
    private DLLeftFragment fg_left_menu;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_drawerlayout2);
        fManager = getSupportFragmentManager();
        fg_right_menu = (DLRightFragment) fManager.findFragmentById(R.id.fg_right_menu);
        fg_left_menu = (DLLeftFragment) fManager.findFragmentById(R.id.fg_left_menu);
        initViews();
    }

    private void initViews() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fly_content = (FrameLayout) findViewById(R.id.fly_content);
        topbar = findViewById(R.id.topbar);
        btn_right = (Button) topbar.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(this);

        //设置右面的侧滑菜单只能通过编程来打开
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                GravityCompat.END);

        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {
                drawer_layout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        fg_right_menu.setDrawerLayout(drawer_layout);
        fg_left_menu.setDrawerLayout(drawer_layout);
    }

    @Override
    public void onClick(View v) {
        drawer_layout.openDrawer(GravityCompat.END);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                GravityCompat.END);    //解除锁定
    }
}