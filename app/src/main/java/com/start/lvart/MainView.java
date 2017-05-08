package com.start.lvart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainView extends AppCompatActivity {
    Button Bmap, Blist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        Bmap = (Button) findViewById(R.id.buttonMap);
        Blist = (Button) findViewById(R.id.buttonList);
        Bmap.setOnClickListener(Map);
        Blist.setOnClickListener(List);
    }
    private View.OnClickListener Map = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainView.this,VirtualActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener List = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainView.this,list.class);
            startActivity(intent);
        }
    };
}
