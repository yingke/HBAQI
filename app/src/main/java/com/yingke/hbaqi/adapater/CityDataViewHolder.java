package com.yingke.hbaqi.adapater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yingke.hbaqi.R;

/**
 * Created by Dell on 2/26.
 */

class CityDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private MyItemClickListener mListener;
    public TextView tv_store,tv_city,tv_aqi,tv_maxpoll ,tv_time,tv_leve;
    public CityDataViewHolder(View itemView) {
        super(itemView);

    }

    public CityDataViewHolder(View itemView, MyItemClickListener mListener) {
        super(itemView);
        this.mListener = mListener;
        tv_store = (TextView) itemView.findViewById(R.id.store);
        tv_city = (TextView) itemView.findViewById(R.id.cityname);
        tv_aqi = (TextView) itemView.findViewById(R.id.aqi);
        tv_maxpoll = (TextView) itemView.findViewById(R.id.maxpoll);
        tv_time = (TextView) itemView.findViewById(R.id.time);
        tv_leve = (TextView) itemView.findViewById(R.id.level);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mListener != null){
            mListener.onItemClick(v, getPosition());
        }
    }
}
