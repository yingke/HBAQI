package com.yingke.hbaqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yingke.hbaqi.adapater.MyItemClickListener;
import com.yingke.hbaqi.adapater.PointerAdapter;
import com.yingke.hbaqi.bean.CityData;
import com.yingke.hbaqi.bean.Pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CityDetailActivity extends AppCompatActivity implements MyItemClickListener {

    private  TextView TV_Intro,tv_Tips,tv_pm25,tv_pm10,tv_so2,tv_co,tv_no2,tv_o3;
    private RecyclerView mRecycler;
    private CityData cityData;
    ArrayList<Pointer> pointersData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        Intent intent =getIntent();

        cityData = (CityData) intent.getSerializableExtra("cd");

        getSupportActionBar().setTitle(cityData.getName()+"    AQI:"+cityData.getAqi());
        initview();
    }

    private void initview() {
         TV_Intro =  findViewById(R.id.tv_city_Intro);
         tv_Tips = findViewById(R.id.tv_city_Tips);
         tv_pm25 = findViewById(R.id.tv_city_pm25);
         tv_pm10 = findViewById(R.id.tv_city_pm10);
         tv_so2 =  findViewById(R.id.tv_city_so2);
         tv_co = findViewById(R.id.tv_city_co);
         tv_no2 = findViewById(R.id.tv_city_NO2);
         tv_o3 =  findViewById(R.id.tv_city_o3);

        mRecycler = findViewById(R.id.pointer_rl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(linearLayoutManager);
        pointersData = (ArrayList<Pointer>) cityData.getPointerList();

        Collections.sort(pointersData, new Comparator<Pointer>() {
            @Override
            public int compare(Pointer o1, Pointer o2) {
                if(o1.getAqi()>o2.getAqi()){
                    return 1;
                }else if(o1.getAqi()==o2.getAqi()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        PointerAdapter adapter= new PointerAdapter(this,pointersData);
        mRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);


        TV_Intro.setText(cityData.getIntro());
        tv_Tips.setText(cityData.getTips());
        tv_pm25.setText("PM2.5 : "+string2int(cityData.getPm25()));
        tv_pm10.setText("PM10 : "+string2int(cityData.getPm10()));
        tv_so2.setText("SO2 : "+string2int(cityData.getSo2()));
        tv_co.setText("CO : "+string2int(cityData.getCo()));
        tv_no2.setText("NO2 : "+string2int(cityData.getNo2()));
        tv_o3.setText("O3 : "+string2int(cityData.getO3()));


    }

    public  int string2int(String s){
        int i = 0;
        if(s!=null && s.length()>0){
            double dd = Double.parseDouble(s);
            double ss  =dd*1000;
             i = (int)ss;
             return i;
        }else {
            return i;
        }
    }


    @Override
    public void onItemClick(View view, int postion) {



    }
}
