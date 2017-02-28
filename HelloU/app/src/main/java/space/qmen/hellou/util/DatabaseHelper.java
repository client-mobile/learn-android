package space.qmen.hellou.util;

/**
 * Created by Luo_0412 on 2016/12/1.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table User ("
            + "user_no integer primary key autoincrement, "
            + "user_type integer default 1 not null, "
            + "user_name text not null, "
            + "user_pwd text  not null, "
            + "user_gender integer not null, "
            + "user_tel text, "
            + "user_address text)";

    public static final String INIT_ADMIN = "insert into User values " +
                    "('0', 2, 'admin', 'admin', 1, '17816869505', '6-523')";


    private Context mContext;

    public DatabaseHelper(Context context, String name,
                            CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(INIT_ADMIN);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        onCreate(db);
    }

}
