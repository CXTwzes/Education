package com.example.wzes.education;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Homework;

public class HomeworkInfoActivity extends AppCompatActivity {

    private List<Homework> homeworks;
    private List<Map<String, String>> data = new ArrayList<Map<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_info);
        String date = getIntent().getStringExtra("Date");
        Toolbar toolbar = (Toolbar) findViewById(R.id.homeworkInfoToolBar);
        Button back = (Button)findViewById(R.id.homeworkInfoBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        homeworks = DataSupport.where("date = ?", date).find(Homework.class);
        for(Homework homework : homeworks){
            if(!homework.isFinish()){
                for(int i = 0 ; i < Integer.parseInt(homework.getNumber()); i++){
                    Map<String, String> map = new HashMap<>();
                    if(i != 0){
                        map.put("类别", "数学"+ ":" );
                        map.put("内容", "复习两本书");
                        data.add(map);
                    }else{
                        String content = homework.getContent();
                        String title = content.substring(0, 2);
                        map.put("类别", title+ ":" );
                        map.put("内容", content.substring(2));
                        data.add(map);
                    }

                }
            }else{
                Map<String, String> map = new HashMap<>();
                map.put("类别", "已完成");
                map.put("内容", " ");
                data.add(map);
            }

        }
        ListView listView = (ListView) findViewById(R.id.homeworkList);
        listView.setAdapter(new SimpleAdapter(this,data,android.R.layout.simple_list_item_2,
                new String[]{"类别","内容"},
                new int[]{android.R.id.text1,android.R.id.text2}
        ));
    }
}
