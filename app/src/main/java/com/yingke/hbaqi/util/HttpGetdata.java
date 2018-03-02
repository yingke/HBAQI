package com.yingke.hbaqi.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yingke.hbaqi.bean.CityData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2/26.
 */

public class HttpGetdata {

    public  static void  getdata(final Handler mHandler){

        new Thread(){
            @Override
            public void run() {
                super.run();
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                StringBuilder resultData = new StringBuilder("");
                try {

                    URL url = new URL(C.XMLURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    Log.i("code",connection.getResponseCode()+"");
                    InputStream in = connection.getInputStream();

                    // pull2xml(in);
                    //下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }

                    Message msg=mHandler.obtainMessage();
                    msg.what=C.GETXMLCODE;
                    msg.obj = response.toString();
                    mHandler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }

}
