package com.example.wzes.education;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import util.Homework;

/**
 * Created by WZES on 2017/2/12.
 */

public class homeworkAdapter extends RecyclerView.Adapter<homeworkAdapter.ViewHolder> {
    private Context myContext;
    private List<Homework> myHomeworkList;
    @Override
    public homeworkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(myContext == null){
            myContext = parent.getContext();
        }
        View view = LayoutInflater.from(myContext).inflate(R.layout.homework_item,
                parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.homeworkCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(myContext, HomeworkInfoActivity.class);
                intent.putExtra("Date",myHomeworkList.get(position).getDate());
                myContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(homeworkAdapter.ViewHolder holder, int position) {
        Homework homework = myHomeworkList.get(position);
        if(homework.isFinish()){
            holder.homeworkImage.setImageResource(R.drawable.shape_yellow);
            holder.homeworkNumber.setVisibility(View.GONE);
        }else{
            holder.homeworkImage.setImageResource(R.drawable.shape_white);
            holder.homeworkNumber.setText(homework.getNumber());
        }
        holder.homeworkDate.setText(homework.getDate());

    }

    @Override
    public int getItemCount() {
        return myHomeworkList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView homeworkImage;
        TextView homeworkDate;
        TextView homeworkNumber;
        TextView homeworkCheck;


        public ViewHolder(View itemView) {
            super(itemView);
            homeworkImage = (ImageView) itemView.findViewById(R.id.finish);
            homeworkDate = (TextView) itemView.findViewById(R.id.date);
            homeworkNumber = (TextView) itemView.findViewById(R.id.number);
            homeworkCheck = (TextView) itemView.findViewById(R.id.check);
        }
    }

    public homeworkAdapter(List<Homework> homeworkList){
        myHomeworkList = homeworkList;
    }
}
