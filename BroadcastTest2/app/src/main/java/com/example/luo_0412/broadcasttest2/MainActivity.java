package com.example.luo_0412.broadcasttest2;

//import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class MainActivity extends Activity {

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri
                        .parse("content://com.example.luo_0412.learnmore.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 55.55);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri
                        .parse("content://com.example.luo_0412.learnmore.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null,
                        null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor
                                .getColumnIndex("name"));
                        String author = cursor.getString(cursor
                                .getColumnIndex("author"));
                        int pages = cursor.getInt(cursor
                                .getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor
                                .getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    }
                    cursor.close();
                }
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri
                        .parse("content://com.example.luo_0412.learnmore.provider/book/" + newId);
                ContentValues values = new ContentValues();
                values.put("name", "A Storm of Swords");
                values.put("pages", 1216);
                values.put("price", 24.05);
                getContentResolver().update(uri, values, null, null);
            }
        });
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri
                        .parse("content://com.example.luo_0412.learnmore.provider/book/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}


//public class ProviderTestActivity extends Activity {
//
//    private String newId;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_test);
//        Button addData = (Button) findViewById(R.id.add_data);
//        addData.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri
//                        .parse("content://com.example.luo_0412.learnmore.provider/book");
//                ContentValues values = new ContentValues();
//                values.put("name", "A Clash of Kings");
//                values.put("author", "George Martin");
//                values.put("pages", 1040);
//                values.put("price", 55.55);
//                Uri newUri = getContentResolver().insert(uri, values);
//                newId = newUri.getPathSegments().get(1);
//            }
//        });
//        Button queryData = (Button) findViewById(R.id.query_data);
//        queryData.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri
//                        .parse("content://com.example.luo_0412.learnmore.provider/book");
//                Cursor cursor = getContentResolver().query(uri, null, null,
//                        null, null);
//                if (cursor != null) {
//                    while (cursor.moveToNext()) {
//                        String name = cursor.getString(cursor
//                                .getColumnIndex("name"));
//                        String author = cursor.getString(cursor
//                                .getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor
//                                .getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor
//                                .getColumnIndex("price"));
//                        Log.d("MainActivity", "book name is " + name);
//                        Log.d("MainActivity", "book author is " + author);
//                        Log.d("MainActivity", "book pages is " + pages);
//                        Log.d("MainActivity", "book price is " + price);
//                    }
//                    cursor.close();
//                }
//            }
//        });
//        Button updateData = (Button) findViewById(R.id.update_data);
//        updateData.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri
//                        .parse("content://com.example.luo_0412.learnmore.provider/book/" + newId);
//                ContentValues values = new ContentValues();
//                values.put("name", "A Storm of Swords");
//                values.put("pages", 1216);
//                values.put("price", 24.05);
//                getContentResolver().update(uri, values, null, null);
//            }
//        });
//        Button deleteData = (Button) findViewById(R.id.delete_data);
//        deleteData.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri
//                        .parse("content://com.example.luo_0412.learnmore.provider/book/" + newId);
//                getContentResolver().delete(uri, null, null);
//            }
//        });
//    }
//
//}