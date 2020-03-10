package com.example.jazz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText name,phone,email;
    Button add,view,delete,update;
    MyHelper helper;
    ImageView addimage;
    String Name,Phone,Email;

    public static final int PICK_IMAGE=100;
    private Uri ImageFilePath;
    private Bitmap imageToStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);

        addimage=(ImageView)findViewById(R.id.addimage);

        add=(Button)findViewById(R.id.Addbtn);
        view=(Button)findViewById(R.id.viewbtn);
        delete=(Button)findViewById(R.id.deletebtn);
        update=(Button)findViewById(R.id.Updatebtn);


        /*add.setOnClickListener(this);
        view.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);*/

        helper=new MyHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=name.getText().toString();
                Phone=phone.getText().toString();
                Email=email.getText().toString();
                if(name.equals(" ") && phone.equals(" ")){

                    Toast.makeText(getApplicationContext(), "Please Fill the column", Toast.LENGTH_LONG).show();
                }
                else{

                    helper.insert(Name,Phone,Email,new ModelClass(imageToStore));
                    name.setText("");
                    phone.setText("");
                    email.setText("");
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,showing.class);
                startActivity(it);
            }
        });


    }

    public void chooseImage(View objectView){

        try{

            Intent it=new Intent();
            it.setType("image/*");
            it.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(it,PICK_IMAGE);
        }
        catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {

        ImageFilePath=data.getData();
        imageToStore= MediaStore.Images.Media.getBitmap(getContentResolver(),ImageFilePath);
        addimage.setImageBitmap(imageToStore);

        }
        }

        catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }



    /*public void onClick(View v){


        switch(v.getId()){

         case R.id.Addbtn:
            Name=name.getText().toString();
            Phone=phone.getText().toString();
            Email=email.getText().toString();
            if(name.equals("") && phone.equals("")){

                Toast.makeText(this, "Please Fill the column", Toast.LENGTH_LONG).show();
            }
            else{

                helper.insert(Name,Phone,Email);
                name.setText("");
                phone.setText("");
                email.setText("");
            }
            break;

         case R.id.viewbtn:
             Intent it=new Intent(this,showing.class);
             startActivity(it);

             break;


     }

 }*/


}
