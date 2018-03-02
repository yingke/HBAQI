package com.yingke.hbaqi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.yingke.hbaqi.util.C;



public class WelcomeActivity extends AppCompatActivity {

    @SuppressLint("HandlerLeak")
    public   Handler mHandler=new Handler(){
        public void handleMessage(Message msg) {
            switch(msg.what){
                case C.GETXMLCODE :
                    String resualt = msg.obj.toString();


                  //  Log.i("list", cityDataList.size()+cityDataList.toString());
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);

                    startActivity(intent);

                    break;

                default :
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);

        startActivity(intent);


    }

}
