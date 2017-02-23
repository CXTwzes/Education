package com.example.wzes.education;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import util.Software;

public class newSoftwareActivity extends AppCompatActivity {

    private static int index = 0;
    private Software[] softwares = { new Software("金山词霸", R.drawable.jscb),
            new Software("猿题库", R.drawable.ytk),
            new Software("知乎", R.drawable.zh),
            new Software("Android Studio", R.drawable.as),
            new Software("学前必备600字", R.drawable.xqby),
            new Software("百度传课KK", R.drawable.bdck),
            new Software("有道词典", R.drawable.ydcd),
            new Software("Xmind", R.drawable.xmind)

    };
    private List<Software> softwareList = new ArrayList<>();
    private SoftwareAdapter softwareAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_software);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        Button back = (Button)findViewById(R.id.softwareBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshSoftwares();
            }
        });
        index = 0;
        softwareList.add(softwares[index++]);
        softwareList.add(softwares[index++]);
        initSoftware();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        softwareAdapter = new SoftwareAdapter(softwareList);
        recyclerView.setAdapter(softwareAdapter);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(200);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initSoftware();
                                softwareAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });

    }

    private void refreshSoftwares(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initSoftware();
                        softwareAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    private void initSoftware(){
        if(index < softwares.length){
            softwareList.add(softwares[index++]);
        }
    }
}
