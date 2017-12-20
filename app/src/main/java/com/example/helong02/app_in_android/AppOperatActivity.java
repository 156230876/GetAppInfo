package com.example.helong02.app_in_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helong02.sihou.R;
import com.example.helong02.util.KillApp;

/**
 * Created by helong02 on 2017/12/20.
 */

public class AppOperatActivity extends Activity  {
    private  Intent intent = null;
    String pkg;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_operat);
        intent = getIntent();
        pkg = intent.getStringExtra("pkg")
        Button unstall = (Button)findViewById(R.id.unstall);
        unstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((intent.getIntExtra("flag",1) & ApplicationInfo.FLAG_SYSTEM) != ApplicationInfo.FLAG_SYSTEM) {
                    Uri uri = Uri.fromParts("package", pkg, null);
                    Intent unstall_intent = new Intent(Intent.ACTION_DELETE, uri);
                    startActivity(unstall_intent);
                }
            }
        });
        Button pkg_button = (Button)findViewById(R.id.pkg_button);
        pkg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.pkg);
                textView.setText(pkg);
            }
        });
        Button kill = (Button)findViewById(R.id.kill);
        kill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KillApp.kill(pkg);
            }
        });
    }

    public static void actionStart (Context context, String pkg, String label, int flag){
        Intent intent = new Intent(context, AppOperatActivity.class);
        intent.putExtra("pkg",pkg);
        intent.putExtra("label",label);
        intent.putExtra("flag",flag);
        context.startActivity(intent);

    }


}
