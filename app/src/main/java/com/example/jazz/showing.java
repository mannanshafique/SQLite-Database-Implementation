package com.example.jazz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static com.example.jazz.MyHelper.DB_TABLE;
import static com.example.jazz.MyHelper.KEY_EMAIL;
import static com.example.jazz.MyHelper.KEY_ID;
import static com.example.jazz.MyHelper.KEY_IMAGE;
import static com.example.jazz.MyHelper.KEY_NAME;
import static com.example.jazz.MyHelper.KEY_PHONE;

public class showing extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList;
    recyler recyler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);

        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        arrayList=new ArrayList<>();


            MyHelper helper = new MyHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();

           String[] colums = new String[]{KEY_ID, KEY_NAME, KEY_IMAGE, KEY_PHONE, KEY_EMAIL};
           Cursor cursor = db.query(DB_TABLE, colums, null, null, null, null, null);

            while (cursor.moveToNext()) {

                byte[] imageBytes=cursor.getBlob(2);
                Bitmap objectBitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                arrayList.add(new ModelClass(cursor.getString(0),
                        cursor.getString(1),cursor.getString(3),
                        cursor.getString(4),objectBitmap));
            }

            recyler=new recyler(arrayList,this);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(recyler);





    }


    }







