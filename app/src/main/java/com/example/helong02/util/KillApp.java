package com.example.helong02.util;

import android.util.Log;

import java.io.OutputStream;
import java.lang.Process;

import java.io.IOException;

/**
 * Created by helong02 on 2017/12/20.
 */

public class KillApp {
    private static String TAG = this.getClass().getSimpleName();
    private static Process process;
    public static void kill(String pkg){
        initProcess();
        killProcess(pkg);
        close();

    }
    private static void initProcess(){
        if(process==null){
            try{
                process = Runtime.getRuntime().exec("su");
                Log.d(TAG,"process.getErrorStream()" + process.getErrorStream());

            }catch (IOException e){
                e.printStackTrace();
                Log.d(TAG, "initProcess: fail");

            }
        }
    }
    private static void killProcess(String pkg){
        OutputStream out = process.getOutputStream();
        String cmd = "am force-stop " + pkg + " \n";
        try {
            out.write(cmd.getBytes());
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
            Log.d(TAG, "killProcess:  fail");

        }
    }
    private static void close(){
        if (process!=null){
            try{
                process.getOutputStream().close();
                process = null;
            }catch (IOException e){
                e.printStackTrace();
                Log.d(TAG, "close: the outputStream fail");
            }
        }
    }
}
