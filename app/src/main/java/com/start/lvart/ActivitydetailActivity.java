package com.start.lvart;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivitydetailActivity extends AppCompatActivity {
    private int datakey;
    private int datacount = 0;
    private int dataLoc;
    private ListView listView;
    private DatabaseArrayAdapter adapter = null;
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
        setContentView(R.layout.activity_activitydetail);
        Intent intent = getIntent();
        datakey = intent.getIntExtra("KEY_NUMBER_DETAIL",0);
        dataLoc = intent.getIntExtra("KEY_NUMBER",0);

        listView = (ListView) findViewById(R.id.detail);
        adapter = new DatabaseArrayAdapter(this, new ArrayList<Database>());
        listView.setAdapter(adapter);

        getFiredasedata();
    }
    private void getFiredasedata(){
        FirebaseDatabase firebaseDatabase  = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("/"+dataLoc);

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

    class FirebaseThread extends Thread {
        private DataSnapshot dataSnapshot;
        public FirebaseThread(DataSnapshot dataSnapshot) {
            this.dataSnapshot = dataSnapshot;
        }
        @Override
        public void run() {
            List<Database> databases = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                if(datakey == datacount){
                    DataSnapshot dstitle = ds.child("title");
                    DataSnapshot dsshowUnit = ds.child("showUnit");
                    DataSnapshot dstime = ds.child("showInfo").child("time");
                    DataSnapshot dsendtime = ds.child("showInfo").child("endTime");
                    DataSnapshot dslocationName = ds.child("showInfo").child("locationName");
                    DataSnapshot dslocation = ds.child("showInfo").child("location");
                    DataSnapshot dsprice = ds.child("showInfo").child("price");
                    DataSnapshot dssourceWebName = ds.child("sourceWebName");
                    DataSnapshot dswebSales = ds.child("webSales");
                    DataSnapshot dssourceWebPromote = ds.child("sourceWebPromote");
                    DataSnapshot dsdescriptionFilterHtml = ds.child("descriptionFilterHtml");

                    Database db = new Database();

                    String title = ">>活動名稱:"+dstitle.getValue().toString();

                    if(dsshowUnit.getValue().toString() == null){
                        String unit = ">>表演者:";
                        db.setShowUnit(unit);
                    }else{
                        String unit = ">>表演者:"+dsshowUnit.getValue().toString();
                        db.setShowUnit(unit);
                    }
                    if(dstime.getValue() == null){
                        String time = ">>活動時間:";
                        db.setTime(time);
                    }else{
                        String time = ">>活動時間:"+dstime.getValue().toString();
                        db.setTime(time);
                    }
                    if(dsendtime.getValue() == null){
                        String endtime = ">>活動結束時間:";
                        db.setEndTime(endtime);
                    }else {
                        String endtime = ">>活動結束時間:"+dsendtime.getValue().toString();
                        db.setEndTime(endtime);
                    }
                    if(dslocationName.getValue() == null){
                        String locationName = ">>活動場地:";
                        db.setLocationName(locationName);
                    }else {
                        String locationName = ">>活動場地:"+dslocationName.getValue().toString();
                        db.setLocationName(locationName);
                    }
                    if(dslocation.getValue() == null){
                        String location = ">>場地地址:";
                        db.setLocation(location);
                    }else {
                        String location = ">>場地地址:"+dslocation.getValue().toString();
                        db.setLocation(location);
                    }
                    if(dsprice.getValue() == null){
                        String price = ">>票價:";
                        db.setPrice(price);
                    }else {
                        String price = ">>票價:"+dsprice.getValue().toString();
                        db.setPrice(price);
                    }
                    if(dssourceWebName.getValue() == null){
                        String sourceWebName = ">>售票系統:";
                        db.setSourceWebName(sourceWebName);
                    }else {
                        String sourceWebName = ">>售票系統:"+dssourceWebName.getValue().toString();
                        db.setSourceWebName(sourceWebName);
                    }
                    if(dswebSales.getValue() == null){
                        String webSales = ">>售票網址:";
                        db.setWebSales(webSales);
                    }else {
                        String webSales = ">>售票網址:"+dswebSales.getValue().toString();
                        db.setWebSales(webSales);
                    }
                    if(dssourceWebPromote.getValue() ==null){
                        String sourceWebPromote = ">>活動網址:";
                        db.setSourceWebPromote(sourceWebPromote);
                    }else{
                        String sourceWebPromote = ">>活動網址:"+dssourceWebPromote.getValue().toString();
                        db.setSourceWebPromote(sourceWebPromote);
                    }
                    if(dsdescriptionFilterHtml.getValue() == null){
                        String descriptionFilterHtml = ">>簡介:";
                        db.setDescriptionFilterHtml(descriptionFilterHtml);
                    }else {
                        String descriptionFilterHtml = ">>簡介:"+dsdescriptionFilterHtml.getValue().toString();
                        db.setDescriptionFilterHtml(descriptionFilterHtml);
                    }

                    db.setTitle(title);

                    databases.add(db);
                    Log.v("key", title);
                    datacount = 0;
                    break;
                }else {
                    datacount++;
                }
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
                itemlayout = (LinearLayout) inflater.inflate(R.layout.detail_item, null);
            } else {
                itemlayout = (LinearLayout) convertView;
            }
            Database item = (Database) getItem(position);
            TextView tvtitle = (TextView) itemlayout.findViewById(R.id.tv_title);
            tvtitle.setText(item.getTitle());
            TextView tvunit = (TextView) itemlayout.findViewById(R.id.tv_unit);
            tvunit.setText(item.getShowUnit());
            TextView tvtime = (TextView) itemlayout.findViewById(R.id.tv_time);
            tvtime.setText(item.getTime());
            TextView tvendtime = (TextView) itemlayout.findViewById(R.id.tv_endtime);
            tvendtime.setText(item.getEndTime());
            TextView tvlocationName = (TextView) itemlayout.findViewById(R.id.tv_locationName);
            tvlocationName.setText(item.getLocationName());
            TextView tvlocation = (TextView) itemlayout.findViewById(R.id.tv_location);
            tvlocation.setText(item.getLocation());
            TextView tvprice = (TextView) itemlayout.findViewById(R.id.tv_price);
            tvprice.setText(item.getPrice());
            TextView tvsourceWebName = (TextView) itemlayout.findViewById(R.id.tv_sourceWebName);
            tvsourceWebName.setText(item.getSourceWebName());
            TextView tvwebSales = (TextView) itemlayout.findViewById(R.id.tv_webSales);
            tvwebSales.setText(item.getWebSales());
            TextView tvsourceWebPromote = (TextView) itemlayout.findViewById(R.id.tv_sourceWebPromote);
            tvsourceWebPromote.setText(item.getSourceWebPromote());
            TextView tvdescriptionFilterHtml = (TextView) itemlayout.findViewById(R.id.tv_descriptionFilterHtml);
            tvdescriptionFilterHtml.setText(item.getDescriptionFilterHtml());
            return itemlayout;
        }
    }
}
