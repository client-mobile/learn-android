###  工具：Android Studio

###  笔记：
+  .9图片(制定拉伸的区域)
```
绘制在L的区域：用于拉伸的纵向区域。
绘制在T的区域：用于拉伸的横向区域。
绘制在R的区域：用于显示前景的纵向范围。
绘制在B的区域：用于显示前景的横向范围。
```
+  前景色和背景色
```
Photoshop中的背景色,就是相当一张图片的底色,前景色就相当于在底色上作画的颜色.
如在photoshop中把背景色设为黑色,前景色高为白色.
我们去写一个字,那么效果就是,这个字呈白色显示,而其他的地方就是黑色的背景了
```
+  [工程相关解析](http://www.runoob.com/w3cnote/android-tutorial-project-src-analysis.html)
  +  MainActivity.java
  ```
  package jay.com.example.firstapp;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;

  public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
    }
  }
  ```
  +  布局文件：activity_main
  ```
  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />

  </RelativeLayout>
  ```
  +  Android配置文件：AndroidManifest.xml 
  ```
  <?xml version="1.0" encoding="utf-8"?>
  <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="jay.com.example.firstapp" >

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

  </manifest>
  ```
+  Android程序签名打包
+  [反编译APK, 获取代码资源](http://www.runoob.com/w3cnote/android-tutorial-decompile-apk-get-code-resources.html)
  +  使用apktool反编译APK获得图片与XML资源
  +  使用dex2jar将classes.dex转换成jar文件
  +  使用jd-gui查看jar包中的Java代码
+  View和ViewGroup
  +  View：所有可视化控件的父类,提供组件描绘和时间处理方法 
  +  ViewGroup： View类的子类，可以拥有子控件,可以看作是容器
+  六大布局
  +   LinearLayout(线性布局): weight权重属性, android:divider绘制下划线
  +   RelativeLayout(相对布局，推荐,margin,padding)：尽量使用RelativeLayout + LinearLayout的weight属性搭配使用 
  +   TableLayout(表格布局) 
  +   FrameLayout(帧布局)
  +   AbsoluteLayout(绝对布局)
  +   GridLayout(网格布局)  
+  
