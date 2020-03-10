package com.example.jazz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MyHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;


    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInbytes;




    public static final String DB_NAME = "University";
    public static final int Version = 7;
    public static final String DB_TABLE = "Student";

    public static final String KEY_ID = "ID";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_PHONE = "PHONE";
    public static final String KEY_EMAIL = "EMAIL";
    public static final String KEY_IMAGE = "IMAGE";

    public MyHelper(@Nullable Context context) {
        super(context, DB_NAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + DB_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, " + KEY_IMAGE + " BLOB, " +KEY_PHONE + " TEXT, " + KEY_EMAIL + " TEXT " + ")";
        db.execSQL(create);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);

    }

    public long insert(String name, String phone, String email, ModelClass modelClass) {
        db = this.getWritableDatabase();



        Bitmap imageToStore=modelClass.getImage();
        byteArrayOutputStream=new ByteArrayOutputStream();
        imageToStore.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageInbytes=byteArrayOutputStream.toByteArray();


        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_PHONE, phone);
        cv.put(KEY_EMAIL, email);
        cv.put(KEY_IMAGE,imageInbytes);
        return db.insert(DB_TABLE, null, cv);
    }




}
