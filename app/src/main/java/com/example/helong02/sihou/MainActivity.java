package com.example.helong02.sihou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helong02.app_in_android.ActivityAppList;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button all_app = (Button) findViewById(R.id.FILTER_ALL_APP);
        all_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityAppList.class);
                intent.putExtra("filter",ActivityAppList.FILTER_ALL_APP);
                startActivity(intent);

            }
        });

        Button sys_app = (Button) findViewById(R.id.FILTER_SYSTEM_APP);
        sys_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityAppList.class);
                intent.putExtra("filter",ActivityAppList.FILTER_SYSTEM_APP);
                startActivity(intent);
            }
        });
        Button third_app = (Button) findViewById(R.id.FILTER_THIRD_APP);
        third_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityAppList.class);
                intent.putExtra("filter",ActivityAppList.FILTER_THIRD_APP);
                startActivity(intent);
            }
        });
        Button sdk_app = (Button) findViewById(R.id.FILTER_SDCARD_APP);
        sdk_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityAppList.class);
                intent.putExtra("filter",ActivityAppList.FILTER_SDCARD_APP);
                startActivity(intent);
            }
        });
    }
}
