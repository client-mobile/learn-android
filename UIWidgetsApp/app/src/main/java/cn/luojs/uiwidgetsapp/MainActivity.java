package cn.luojs.uiwidgetsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 用于保存ListView的每个子项
    private List<Widget> widgetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏标题栏
        setContentView(R.layout.activity_main);

        // 初始化,给widgetList添加子项
        initWidgets();

        // 用adapter来adapter
        WidgetAdapter adapter = new WidgetAdapter(MainActivity.this,
                R.layout.widget_item, widgetList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // 注册子项的监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Widget widget = widgetList.get(position); // 由pos来确定
                Intent it = new Intent(); // ??
                int index = (int)id; // long → int

                // 根据顺序下标来判断跳转
                switch(index) {
                    case 0:
                        it.setClass(MainActivity.this, TextViewActivity.class);
                        startActivity(it);
                        break;
                    case 1:
                        it.setClass(MainActivity.this, ImageViewActivity.class);
                        startActivity(it);
                        break;
                    case 2:
                        it.setClass(MainActivity.this, EditTextActivity.class);
                        startActivity(it);
                        break;
                    case 3:
                        it.setClass(MainActivity.this, ProgressBarActivity.class);
                        startActivity(it);
                        break;
                    case 4:
                        it.setClass(MainActivity.this, RatingBarActivity.class);
                        startActivity(it);
                        break;
                    case 5:
                        it.setClass(MainActivity.this, DialogActivity.class);
                        startActivity(it);
                        break;
                    case 6:
                        it.setClass(MainActivity.this, RadioButtonActivity.class);
                        startActivity(it);
                        break;
                    case 7:
                        it.setClass(MainActivity.this, CheckBoxActivity.class);
                        startActivity(it);
                        break;
                    case 8:
                        it.setClass(MainActivity.this, CalculatorActivity.class);
                        startActivity(it);
                        break;
                    case 9:
                        it.setClass(MainActivity.this, FrameLayoutActivity.class);
                        startActivity(it);
                        break;
                    case 10:
                        it.setClass(MainActivity.this, TableLayoutActivity.class);
                        startActivity(it);
                        break;
                    case 11:
                        it.setClass(MainActivity.this, RelativeLayoutActivity.class);
                        startActivity(it);
                        break;
                    case 12:
                        it.setClass(MainActivity.this, MyselfTitleActivity.class);
                        startActivity(it);
                        break;
                    case 13:
                        it.setClass(MainActivity.this, MessageActivity.class);
                        startActivity(it);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, widget.getName(),
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    /**
     * 初始化函数，给list添加子项
     */
    private void initWidgets() {
        Widget textViewDemo = new Widget("TextView(文本框 样式)", R.mipmap.apple_pic);
        widgetList.add(textViewDemo);
        Widget imgViewDemo = new Widget("ImageView(图片 src改变)", R.mipmap.banana_pic);
        widgetList.add(imgViewDemo);
        Widget editTextDemo = new Widget("EditText(编辑框 取值)", R.mipmap.orange_pic);
        widgetList.add(editTextDemo);
        Widget pgbarDemo = new Widget("ProgressBar(进度条 改变进度)", R.mipmap.watermelon_pic);
        widgetList.add(pgbarDemo);
        Widget ratingbarDemo = new Widget("RatingBar(评分 半颗星)", R.mipmap.pear_pic);
        widgetList.add(ratingbarDemo);
        Widget dialogDemo = new Widget("Dialog(对话框 非点不可)", R.mipmap.grape_pic);
        widgetList.add(dialogDemo);
        Widget radioBtn = new Widget("RadioButton(单选框 班级名单)", R.mipmap.pineapple_pic);
        widgetList.add(radioBtn);
        Widget checkbox = new Widget("CheckBox(复选框 兴趣爱好)", R.mipmap.strawberry_pic);
        widgetList.add(checkbox);
        Widget calculator = new Widget("LinearLayout(线性布局 嵌套)", R.mipmap.cherry_pic);
        widgetList.add(calculator);
        Widget frameLayout = new Widget("FrameLayout(帧布局 重叠)", R.mipmap.mango_pic);
        widgetList.add(frameLayout);
        Widget tableLayout = new Widget("TableLoyout(表格布局 登录)", R.mipmap.apple_pic);
        widgetList.add(tableLayout);
        Widget relativeLayout = new Widget("RelativeLayout(相对布局 梅花桩)", R.mipmap.banana_pic);
        widgetList.add(relativeLayout);
        Widget myselfTitle = new Widget("自定义标题栏", R.mipmap.orange_pic);
        widgetList.add(myselfTitle);
        Widget message = new Widget("精美聊天界面", R.mipmap.watermelon_pic);
        widgetList.add(message);
        Widget pear2 = new Widget("Pear", R.mipmap.pear_pic);
        widgetList.add(pear2);
    }

}