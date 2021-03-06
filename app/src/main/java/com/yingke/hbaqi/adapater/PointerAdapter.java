package com.yingke.hbaqi.adapater;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yingke.hbaqi.R;
import com.yingke.hbaqi.bean.Pointer;

import java.util.ArrayList;

/**
 * Created by Dell on 2/26.
 */

public class PointerAdapter extends  RecyclerView.Adapter<CityDataViewHolder>{
    private Context context;
    private ArrayList<Pointer> citys;
    private MyItemClickListener mListener;

    public PointerAdapter(Context context, ArrayList<Pointer> citys) {
        this.context = context;
        this.citys = citys;
    }

    @Override
    public CityDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new CityDataViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(CityDataViewHolder holder, int position) {
        Pointer cityData = citys.get(position);
        holder.tv_store.setText(position+1+"");
        holder.tv_city.setText(jiexi(cityData.getName()));
        holder.tv_aqi.setText("AQI:"+cityData.getAqi());
        holder.tv_maxpoll.setText("首要污染物:"+cityData.getMaxPoll());
        holder.tv_time.setText("更新时间:"+cityData.getDataTime().split(" ")[1]);
        holder.tv_leve.setText(cityData.getLevel());

        holder.tv_leve.setBackgroundColor(Color.parseColor(cityData.getColor()));


    }

    @Override
    public int getItemCount() {
        return citys.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.mListener = listener;
    }

    private String jiexi(String s){

        if(s.endsWith("(*)")){
              return  s.split("\\(")[0];
            }else {
                return s;
            }
        }


}
