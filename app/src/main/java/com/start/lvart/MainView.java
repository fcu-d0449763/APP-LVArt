package com.start.lvart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainView extends AppCompatActivity {
    Button map, list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        map = (Button) findViewById(R.id.buttonMap);
        list = (Button) findViewById(R.id.buttonList);
        map.setOnClickListener(Map);
        list.setOnClickListener(List);
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
            intent.setClass(MainView.this,VirtualActivity.class);
            startActivity(intent);
        }
    };
}
