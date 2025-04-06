package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBhandl extends SQLiteOpenHelper{
    public DBhandl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name,factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="create table myemp (sno INTEGER primary key, NAME text,  dept text)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade=String.valueOf("DROP TABLE IF EXISTS ");
        db.execSQL(upgrade, new String[]{"myemp"});
        onCreate(db);


    }
    public void addemp(com.example.myapplication.Employe emp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sno", emp.getSno());  // Fixing incorrect field
        cv.put("name", emp.getName());
        cv.put("dept", emp.getDept());  // Adding department field
        long k=db.insert("myemp",null,cv);
        Log.d("data inserted",Long.toString(k));
        db.close();
    }
    public void getemp(int sno){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query("myemp",new String[]{"sno","name","dept"},"sno=?",new String[]{String.valueOf(sno)},null,null,null);
        if(cur!=null && cur.moveToFirst()){
            Log.d("sno", cur.getString(0));  // Fixed indexing
            Log.d("name", cur.getString(1));
            Log.d("dept", cur.getString(2));
            cur.close();  // Closing cursor
        }
        else {
            Log.d("data","no data");
        }

    }
}
