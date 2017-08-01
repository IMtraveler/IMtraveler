package com.example.user.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.os.StrictMode ;
import org.json.JSONArray;
import org.json.JSONObject;


public class MainPageActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        findViews();
        setListeners();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        Button button03 = (Button)findViewById(R.id.Button03);
        button03.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,MainActivity.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });
        Button button04 = (Button)findViewById(R.id.Button04);

        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,MusicActivity.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });

        Button btn_toMap = (Button)findViewById(R.id.btn_toMap);

        btn_toMap.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,MapsActivity.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });

        Button btn_toUpload = (Button)findViewById(R.id.btn_toUpload);

        btn_toUpload.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,UploadActivity.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });
    }

    private Button button_get_record;
    private void findViews() {
        button_get_record = (Button)findViewById(R.id.btn_mysql);
    }
    private void setListeners() {
        button_get_record.setOnClickListener(getDBRecord);
    }
    String result = "" ;
    private Button.OnClickListener getDBRecord = new
            Button.OnClickListener() {
                public void onClick(View v) {
                    try {
                        result = MySQLConnection.executeQuery();

                    } catch(Exception e) {
                        Log.e("log_tag", e.toString());
                    }

                    TextView showdb= (TextView) findViewById(R.id.tv_data);
                    showdb.setText(result);
                }
            };
}
