package com.example.wzes.education;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton isFinishBtn, homeworkBtn,
                        discussBtn, courseBtn, softwareBtn;
    private TextView usernameTxt, idTxt;
    private SharedPreferences sharedPreferences;
    private String username, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connector.getDatabase();

        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        usernameTxt = (TextView) findViewById(R.id.userName);
        idTxt = (TextView) findViewById(R.id.id);
        sharedPreferences = this.getSharedPreferences(
                "user", MODE_PRIVATE);
        username = sharedPreferences.getString("Username", "XXXXX");
        id = "ID:" + sharedPreferences.getString("Id", "000000");
        usernameTxt.setText(username);
        idTxt.setText(id);

        isFinishBtn = (ImageButton) findViewById(R.id.isFinish);
        homeworkBtn = (ImageButton) findViewById(R.id.homework);
        discussBtn = (ImageButton) findViewById(R.id.discuss);
        courseBtn = (ImageButton) findViewById(R.id.course);
        softwareBtn = (ImageButton) findViewById(R.id.software);
        isFinishBtn.setOnClickListener(this);
        homeworkBtn.setOnClickListener(this);
        discussBtn.setOnClickListener(this);
        courseBtn.setOnClickListener(this);
        softwareBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.isFinish:
                startActivity(new Intent(this, isFinishActivity.class));
                break;
            case R.id.homework:
                startActivity(new Intent(this, TodayHomewokActivity.class));
                break;
            case R.id.discuss:
                startActivity(new Intent(this, DiscussActivity.class));
                break;
            case R.id.course:
                startActivity(new Intent(this, CourseActivity.class));
                break;
            case R.id.software:
                startActivity(new Intent(this, newSoftwareActivity.class));
                break;
        }
    }
}
