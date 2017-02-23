package com.example.wzes.education;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import util.Message;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by WZES on 2017/2/12.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Message> myMsgList;

    public MsgAdapter(List<Message> myMsgList) {
        this.myMsgList = myMsgList;

    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(
               R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Message message = myMsgList.get(position);
        if(LoginActivity.userName.equals(message.getUser())){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(message.getContent());
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightUser.setText(message.getUser());
            holder.rightDate.setText(message.getDate());
        }else{
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.leftMsg.setText(message.getContent());
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftUser.setText(message.getUser());
            holder.leftDate.setText(message.getDate());
        }

    }

    @Override
    public int getItemCount() {
        return myMsgList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout leftLayout, rightLayout;
        TextView leftMsg, rightMsg, leftUser, rightUser,
                leftDate, rightDate;

        public ViewHolder(View itemView) {

            super(itemView);
            leftLayout = (RelativeLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (RelativeLayout) itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);
            leftUser = (TextView) itemView.findViewById(R.id.msgLeftUser);
            rightUser = (TextView) itemView.findViewById(R.id.msgRightUser);
            leftDate = (TextView) itemView.findViewById(R.id.leftDate);
            rightDate = (TextView) itemView.findViewById(R.id.rightDate);
        }
    }
}
