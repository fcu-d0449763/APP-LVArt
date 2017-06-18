package com.start.lvart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Activity extends AppCompatActivity {
    private DatabaseArrayAdapter adapter = null;
    private int choose;
    private Button Bback;
    private ListView listview;
    private static final int LIST_PETS = 1;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_PETS: {
                    List<Database> pets = (List<Database>)msg.obj;
                    refreshPetList(pets);
                    break;
                }
            }
        }
    };
    private void refreshPetList(List<Database> pets) {
        adapter.clear();
        adapter.addAll(pets);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);
        Bback = (Button) findViewById(R.id.buttonBackList);
        listview = (ListView) findViewById(R.id.act);
        Intent intent = getIntent();
        int num = intent.getIntExtra("KEY_NUMBER", 0);
        choose = num;
       /* String[] str = {">>活動名稱\n"
                        , ">>所在縣市\n"
                        , ">>活動型態\n"
                        , ">>活動類別\n"
                        , ">>活動展演者\n"
                        , ">>活動時間\n"
                        , ">>活動場地\n"
                        , ">>場地地址\n"
                        , ">>聯絡電話\n"
                        , ">>票價\n"
                        , ">>售票系統\n"
                        , ">>參與單位\n"
                        , ">>活動網址\n"
                        , ">>簡介\n" };
        ListView listview = (ListView) findViewById(R.id.act);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter2);*/
        adapter = new DatabaseArrayAdapter(Activity.this, new ArrayList<Database>());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onClickListView);
        Bback.setOnClickListener(back);
        getFiredasedata();
    }
    private void getFiredasedata(){
        FirebaseDatabase firebaseDatabase  = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("/"+choose);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new FirebaseThread(dataSnapshot).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("error",databaseError.getMessage());
            }
        });
    }
    private Button.OnClickListener back = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Activity.this,list.class);
            startActivity(intent);
            finish();
        }
    };
    class FirebaseThread extends Thread {
        private DataSnapshot dataSnapshot;
        public FirebaseThread(DataSnapshot dataSnapshot) {
            this.dataSnapshot = dataSnapshot;
        }
        @Override
        public void run() {
            List<Database> databases = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                DataSnapshot dstitle = ds.child("title");
                DataSnapshot dsshowUnit = ds.child("showUnit");
                DataSnapshot dstime = ds.child("showInfo").child("time");
                DataSnapshot dsendtime = ds.child("showInfo").child("endTime");
                String title = dstitle.getValue().toString();
                String unit = dsshowUnit.getValue().toString();
                Database db = new Database();
                db.setTitle(title);
                databases.add(db);
                Log.v("name",title + unit);
            }
            Message msg = new Message();
            msg.what = LIST_PETS;
            msg.obj = databases;
            handler.sendMessage(msg);
        }
    }
    class DatabaseArrayAdapter extends ArrayAdapter<Database> {
        Context context;

        public DatabaseArrayAdapter(Context context, List<Database> items) {
            super(context, 0, items);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(context);
            LinearLayout itemlayout = null;
            if (convertView == null) {
                itemlayout = (LinearLayout) inflater.inflate(R.layout.list_item, null);
            } else {
                itemlayout = (LinearLayout) convertView;
            }
            Database item = (Database) getItem(position);
            TextView tvtitle = (TextView) itemlayout.findViewById(R.id.tv_title);
            tvtitle.setText(item.getTitle());
            return itemlayout;
        }
    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Activity.this,"點選第 "+(position +1) +" 個", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(Activity.this,ActivitydetailActivity.class);
            intent.putExtra("KEY_NUMBER_DETAIL", position);
            intent.putExtra("KEY_NUMBER",choose);
            startActivity(intent);
            finish();
        }
    };
}