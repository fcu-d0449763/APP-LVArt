package com.start.lvart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class list extends AppCompatActivity {

    //ListView 要顯示的內容　改到全域變數
    public String[] str = {"音樂"
                            ,"戲劇"
                            ,"舞蹈"
                            ,"親子活動"
                            ,"演唱會"
                            ,"展覽"
                            ,"講座"
                            ,"電影"
                            ,"綜藝"
                            ,"競賽"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listview = (ListView) findViewById(android.R.id.list);

        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onClickListView);       //指定事件 Method
    }

    /***
     * 點擊ListView事件Method
     */
    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            Toast.makeText(list.this,"點選第 "+(position +1) +" 個 \n內容："+str[position], Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(list.this,Activity.class);
            intent.putExtra("KEY_NUMBER", position);
            startActivity(intent);
            finish();
        }
    };

}
