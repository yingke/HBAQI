package com.yingke.hbaqi.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yingke.hbaqi.CityDetailActivity;
import com.yingke.hbaqi.R;
import com.yingke.hbaqi.adapater.DividerItemDecoration;
import com.yingke.hbaqi.adapater.MainAdapter;
import com.yingke.hbaqi.adapater.MyItemClickListener;
import com.yingke.hbaqi.bean.CityData;
import com.yingke.hbaqi.util.C;
import com.yingke.hbaqi.util.HttpGetdata;
import com.yingke.hbaqi.util.Parserxml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2/26.
 */

public class StoreFragment extends Fragment implements MyItemClickListener {
    ArrayList<CityData> cityData;
    RecyclerView mRecycler;
    MainAdapter adapter;


    @SuppressLint("HandlerLeak")
    public Handler mHandler=new Handler(){
        public void handleMessage(Message msg) {
            switch(msg.what){
                case C.GETXMLCODE :
                    String resualt = msg.obj.toString();
                   cityData = (ArrayList<CityData>) Parserxml.Toxml(resualt);
                   adapter = new MainAdapter(getContext(),cityData);
                    mRecycler.setAdapter(adapter);
                    mRecycler.addItemDecoration(new DividerItemDecoration(getContext(),
                            DividerItemDecoration.VERTICAL_LIST));
                    adapter.setOnItemClickListener(StoreFragment.this);



                    break;

                default :
                    break;
            }
        }
    };


    public StoreFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecycler = (RecyclerView)rootView.findViewById(R.id.store_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(linearLayoutManager);
        HttpGetdata.getdata(mHandler);








        return rootView;
    }

    @Override
    public void onItemClick(View view, int postion) {
        CityData cd = cityData.get(postion);
        Intent intent =new Intent(getContext(), CityDetailActivity.class);

        intent.putExtra("cd",cd);
        startActivity(intent);

    }
}
