package com.example.wzes.education;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Connection;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import util.Message;
import util.MessageNet;

public class DiscussActivity extends AppCompatActivity {

    private List<Message> messages = new ArrayList<>();
    private List<Message> test = new ArrayList<>();
    private Button send;
    private EditText inputText;
    private RecyclerView msgRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SharedPreferences sharedPreferences;
    private MsgAdapter msgAdapter;
    private String username;
    private Handler hand;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        username = sharedPreferences.getString("Username","null");
        final Toolbar toolbar = (Toolbar) findViewById(R.id.discussToolBar);
        final Button back = (Button) findViewById(R.id.discussBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.discussSwipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                findNet();
            }
        });
        messages = DataSupport.findAll(Message.class);
        //DataSupport.deleteAll(Message.class);
        Collections.reverse(messages);
        msgRecyclerView = (RecyclerView) findViewById(R.id.discussRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        msgAdapter = new MsgAdapter(messages);
        msgRecyclerView.setAdapter(msgAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = inputText.getText().toString();
                if (!TextUtils.isEmpty(content)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MessageNet messageNet = new MessageNet(username, content, Message.TYPE_RECEIVED);
                            messageNet.save(new SaveListener<String>() {
                                @Override
                                public void done(String objectId,BmobException e) {
                                    if(e==null){
                                        android.os.Message msg = hand.obtainMessage();
                                        msg.what = 2;
                                        hand.sendMessage(msg);
                                        Toast.makeText(DiscussActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(DiscussActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                    }).start();
                }
            }
        });
        hand = new Handler(){
            public void handleMessage(android.os.Message msg) {
                switch (msg.what){
                    case 1:
                        messages = DataSupport.findAll(Message.class);
                        Collections.reverse(messages);
                        msgAdapter = new MsgAdapter(messages);
                        msgRecyclerView.setAdapter(msgAdapter);
                        msgRecyclerView.scrollToPosition(0);
                        swipeRefreshLayout.setRefreshing(false);
                        break;
                    case 2:
                        Message message = new Message(username, content, Message.TYPE_SEND);
                        Date date = new Date();
                        long times = date.getTime();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(date);
                        message.setDate(dateString);
                        //message.save();
                        messages.add(0, message);
                        msgAdapter = new MsgAdapter(messages);
                        msgRecyclerView.setAdapter(msgAdapter);
                        msgRecyclerView.scrollToPosition(0);
                        inputText.setText("");
                        break;
                }
            }
        };
    }

    private void findNet() {
        BmobQuery<MessageNet> bmobQuery = new BmobQuery<>();
        bmobQuery.setLimit(1000);
        bmobQuery.findObjects(new FindListener<MessageNet>() {
            @Override
            public void done(List<MessageNet> list, BmobException e) {
                if (e == null) {
                    for(MessageNet messageNet : list){

                        Message msg = new Message(messageNet.getUser(), messageNet.getContent(), Message.TYPE_RECEIVED);
                        msg.setDate(messageNet.getCreatedAt());
                        test = DataSupport.where("user = ? and date = ?", messageNet.getUser(), messageNet.getCreatedAt()).find(Message.class);
                        if(test.size()!=0){
                            //已存在
                        }else {
                            msg.save();
                        }
                    }
                    android.os.Message msg = hand.obtainMessage();
                    msg.what = 1;
                    hand.sendMessage(msg);

                }
            }
        });
    }

}
