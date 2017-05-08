package com.start.lvart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.b_login);
        login.setOnClickListener(Login);
    }
    private View.OnClickListener Login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent toMain = new Intent();
            toMain.setClass(MainActivity.this,MainView.class);
            startActivity(toMain);
            finish();
        };
    };
}
