package com.example.sudindev.crypto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class Main2Activity extends AppCompatActivity {

    String jsonURL="https://api.coinmarketcap.com/v1/ticker/";
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);
        new JSONDownloader(Main2Activity.this, jsonURL, lv).execute();
    }

}