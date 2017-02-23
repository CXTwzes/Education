package com.example.wzes.education;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import util.Homework;

public class isFinishActivity extends AppCompatActivity {
    private RecyclerView myRecyclerView = null;
    private homeworkAdapter myHomeworkAdapter = null;
    private List<Homework> myList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_finish);

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeworkToolBar);
        Button back = (Button) findViewById(R.id.homeworkBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        myRecyclerView = (RecyclerView) findViewById(R.id.homeworkRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        initData();

        myHomeworkAdapter = new homeworkAdapter(myList);
        myRecyclerView.setAdapter(myHomeworkAdapter);
    }

    private void initData() {
        DataSupport.deleteAll(Homework.class);

        Homework homework1 = new Homework("12月8号", false, "语文背诵两篇课文", "2");
        homework1.save();
        myList.add(homework1);

        Homework homework2 = new Homework("12月7号", true, "英语背诵两篇课文", "2");
        homework2.save();
        myList.add(homework2);


        Homework homework3 = new Homework("12月6号", true, "英语背诵两篇课文", "0");
        myList.add(homework3);
        homework3.save();

        Homework homework4 = new Homework("12月5号", false, "英语背诵两篇课文", "1");
        myList.add(homework4);
        homework4.save();

        Homework homework5 = new Homework("12月4号", true, "英语背诵两篇课文", "0");
        myList.add(homework5);
        homework5.save();

        Homework homework8 = new Homework("12月3号", false, "英语背诵两篇课文", "1");
        homework8.save();
        myList.add(homework8);
    }
}
