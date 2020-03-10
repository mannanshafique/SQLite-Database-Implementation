package com.example.jazz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

 ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

     /*   list=(ListView) findViewById(R.id.list);
        MyHelper db=new MyHelper(this);
        db=new MyHelper(this);
        ArrayList<String> arrayList=db.getUsers();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.select_dialog_item,arrayList);
        list.setAdapter(adapter);
    */}
}
