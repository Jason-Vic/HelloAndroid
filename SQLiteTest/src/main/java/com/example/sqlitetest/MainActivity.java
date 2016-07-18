package com.example.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TABLENAME = "stutb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
//        sqLiteDatabase.execSQL("create table if not exists usertb (_id integer primary key " +
//                "autoincrement, name text not null, age integer not null, sex text not null)");
//        sqLiteDatabase.execSQL("insert into usertb(name,age,sex) values ('张三','22','男')");
//        sqLiteDatabase.execSQL("insert into usertb(name,age,sex) values ('李四','18','女')");
//        sqLiteDatabase.execSQL("insert into usertb(name,age,sex) values ('王五','19','男')");
//
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from usertb", null);
//        if(cursor != null){
//            while(cursor.moveToNext()){
//                Log.d("TAG", "id:"+cursor.getInt(cursor.getColumnIndex("_id")));
//                Log.d("TAG", "name:"+cursor.getString(cursor.getColumnIndex("name")));
//                Log.d("TAG", "age:"+cursor.getInt(cursor.getColumnIndex("age")));
//                Log.d("TAG", "sex:"+cursor.getInt(cursor.getColumnIndex("sex")));
//            }
//            cursor.close();
//        }
//        sqLiteDatabase.close();


//        SQLiteDatabase db = openOrCreateDatabase("stu.db", MODE_PRIVATE, null);
//        db.execSQL("create table if not exists stutb (_id integer primary key autoincrement,
// name" +
//                " text not null, age integer not null, sex text not null)");
//        ContentValues values = new ContentValues();
//        values.put("name", "张一");
//        values.put("age", 18);
//        values.put("sex", "男");
//        db.insert("stutb", null, values);
//        values.clear();
//        values.put("name", "张二");
//        values.put("age", 19);
//        values.put("sex", "男");
//        db.insert("stutb", null, values);
//        values.clear();
//        values.put("name", "张三");
//        values.put("age", 20);
//        values.put("sex", "男");
//        db.insert("stutb", null, values);
//        values.clear();
//        values.put("name", "张四");
//        values.put("age", 21);
//        values.put("sex", "男");
//        db.insert("stutb", null, values);
//        values.clear();
//        values.put("name", "张五");
//        values.put("age", 22);
//        values.put("sex", "男");
//        db.insert("stutb", null, values);
//        values.clear();
//        values.put("sex", "女");
//        db.update("stutb", values, "_id < ?", new String[]{"2"});
//        db.delete("stutb", "name like ?", new String[]{"%五%"});
//        Cursor cursor = db.query("studb", null, "age > ?", new String[]{"19"}, null, null,
// "name");
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                Log.d("TAG", "id:" + cursor.getInt(cursor.getColumnIndex("_id")));
//                Log.d("TAG", "name:" + cursor.getString(cursor.getColumnIndex("name")));
//                Log.d("TAG", "age:" + cursor.getInt(cursor.getColumnIndex("age")));
//                Log.d("TAG", "sex:" + cursor.getInt(cursor.getColumnIndex("sex")));
//            }
//            cursor.close();
//        }
//        db.close();
    }
}
