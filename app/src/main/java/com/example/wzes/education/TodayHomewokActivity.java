package com.example.wzes.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TodayHomewokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_homewok);
        Toolbar toolbar = (Toolbar) findViewById(R.id.todayHomeworkToolBar);
        Button back = (Button) findViewById(R.id.todayHomeworkBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
}
