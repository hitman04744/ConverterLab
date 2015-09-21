package com.example.bohdan.converterlab.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bohdan.converterlab.R;
import com.example.bohdan.converterlab.organisationsModel.currencies.EUR;
import com.example.bohdan.converterlab.organisationsModel.currencies.RUB;
import com.example.bohdan.converterlab.organisationsModel.currencies.USD;

import java.util.ArrayList;

/**
 * Created by Bohdan on 21.09.2015.
 */
public class CustomListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater lInflater;
    ArrayList<Object> objects;
    RUB rub;
    USD usd;
    EUR eur;
    TextView ask;
    TextView bid;

    public CustomListViewAdapter(Context mContext, ArrayList<Object> objects) {
        this.mContext = mContext;
        this.objects = objects;
        lInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.currency_item, parent, false);
        }
        ask = (TextView) view.findViewById(R.id.ask_DA);
        bid = (TextView) view.findViewById(R.id.bid_DA);

     if(objects.get(position)instanceof RUB) {
         rub = (RUB) objects.get(position);
         ((TextView) view.findViewById(R.id.currency_name_DA)).setText(rub.getName());
         if( Double.parseDouble(ask.getText().toString()) <= Double.parseDouble(rub.getAsk())){
             ask.setTextColor(Color.GREEN);
         }else{
             ask.setTextColor(Color.RED);
         }
         ask.setText(rub.getAsk());
         if( Double.parseDouble(bid.getText().toString()) <= Double.parseDouble(rub.getBid())){
             bid.setTextColor(Color.GREEN);
         }else{
            bid.setTextColor(Color.RED);
         }
         bid.setText(rub.getBid());
     }else{
         if(objects.get(position) instanceof USD){
             usd = (USD) objects.get(position);
             ((TextView) view.findViewById(R.id.currency_name_DA)).setText(this.usd.getName());
             if( Double.parseDouble(ask.getText().toString()) <= Double.parseDouble(usd.getAsk())){
                 ask.setTextColor(Color.GREEN);
             }else{
                 ask.setTextColor(Color.RED);
             }
             ask.setText(this.usd.getAsk());
             if( Double.parseDouble(bid.getText().toString()) <= Double.parseDouble(usd.getBid())){
                 ask.setTextColor(Color.GREEN);
             }else{
                 ask.setTextColor(Color.RED);
             }
             bid.setText(this.usd.getBid());

         }else{
             eur = (EUR) objects.get(position);
             ((TextView) view.findViewById(R.id.currency_name_DA)).setText(eur.getName());
             if( Double.parseDouble(ask.getText().toString()) <= Double.parseDouble(eur.getAsk())){
                 ask.setTextColor(Color.GREEN);
             }else{
                 ask.setTextColor(Color.RED);
             }
             ask.setText(eur.getAsk());
             if( Double.parseDouble(bid.getText().toString()) <= Double.parseDouble(eur.getBid())){
                 ask.setTextColor(Color.GREEN);
             }else{
                 ask.setTextColor(Color.RED);
             }
             bid.setText(eur.getBid());
         }
     }


         return view;
    }
}
