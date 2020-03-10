package com.example.jazz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyler extends RecyclerView.Adapter<recyler.viewholder> {


    ArrayList<ModelClass> arrayList;
    Context c;

    public recyler(ArrayList<ModelClass> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,null);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

       /* holder.id.setText(arrayList.get(position).getId());
        holder.name.setText(arrayList.get(position).getName());
        holder.phone.setText(arrayList.get(position).getPhone());
        holder.email.setText(arrayList.get(position).getEmail());*/


        ModelClass modelClass=arrayList.get(position);
        holder.id.setText(modelClass.getId());
        holder.name.setText(modelClass.getName());
        holder.phone.setText(modelClass.getPhone());
        holder.email.setText(modelClass.getEmail());
        holder.imageview.setImageBitmap(modelClass.getImage());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView id,name,phone,email;
        ImageView imageview;;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.ids);
            name=(TextView)itemView.findViewById(R.id.Names);
            phone=(TextView)itemView.findViewById(R.id.Phones);
            email=(TextView)itemView.findViewById(R.id.Emails);
            imageview=(ImageView) itemView.findViewById(R.id.imageviews);

        }
    }
}
