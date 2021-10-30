package com.examplenishad.NewsApp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<modelclass> modelclassArrayList;

    public Adapter(Context context, ArrayList<modelclass> modelclassArrayList) {
        this.context = context;
        this.modelclassArrayList = modelclassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,webview.class);
                intent.putExtra("url",modelclassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mtime.setText("Published At" + modelclassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText("Published By" + modelclassArrayList.get(position).getAuthor());
        holder.mheading.setText(""+modelclassArrayList.get(position).getTitle());
        holder.mcontent.setText(""+modelclassArrayList.get(position).getDescription());
        Glide.with(context).load(modelclassArrayList.get(position).getUrlToImage()).into(holder.imageView);


    }



    @Override
    public int getItemCount() {
        return modelclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
