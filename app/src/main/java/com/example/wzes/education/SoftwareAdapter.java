package com.example.wzes.education;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import util.Software;

/**
 * Created by WZES on 2017/1/28.
 */

public class SoftwareAdapter extends RecyclerView.Adapter<SoftwareAdapter.ViewHolder> {
    private Context myContext;
    private List<Software> mSoftwareList;

    public SoftwareAdapter(List<Software> softwareList){
        mSoftwareList = softwareList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.software_image);
            textView = (TextView) itemView.findViewById(R.id.software_name);
        }
    }

    @Override
    public SoftwareAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(myContext == null){
            myContext = parent.getContext();
        }
        View view = LayoutInflater.from(myContext).inflate(
                R.layout.software_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Software software = mSoftwareList.get(position);
                Intent intent = new Intent(myContext, SoftwareActivity.class);
                intent.putExtra(SoftwareActivity.SOFTWARE_NAME, software.getName());
                intent.putExtra(SoftwareActivity.SOFTWARE_IMAGE_ID, software.getImageId());
                myContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(SoftwareAdapter.ViewHolder holder, int position) {
        Software software = mSoftwareList.get(position);
        holder.textView.setText(software.getName());
        holder.imageView.setImageResource(software.getImageId());
        //Glide.with(myContext).load().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mSoftwareList.size();
    }
}
