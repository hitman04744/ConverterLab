package com.example.bohdan.converterlab;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BankViewHolder>  {

    ArrayList<Banks> banks;

    public RVAdapter( ArrayList<Banks> banks){
       this.banks = banks;
    }

    @Override
    public BankViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_card, viewGroup, false);
        BankViewHolder bvh = new BankViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(BankViewHolder holder, int position) {
        holder.name.setText(banks.get(position).getName());
        holder.location.setText(banks.get(position).getLocation());
        holder.cityLocation.setText(banks.get(position).getCityLocation());
        holder.telephone.setText(banks.get(position).getTelephone());
        holder.bankAdress.setText(banks.get(position).getAdress());

    }

    @Override
    public int getItemCount() {

        return banks.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static  class BankViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        private TextView name;
        private TextView location;
        private TextView cityLocation;
        private TextView telephone;
        private TextView bankAdress;

        public BankViewHolder(View itemView) {
            super(itemView) ;
            cv = (CardView) itemView.findViewById(R.id.card_view);
            name =  (TextView) itemView.findViewById(R.id.info_text);
            location = (TextView) itemView.findViewById(R.id.info_text2);
            cityLocation = (TextView) itemView.findViewById(R.id.info_text3) ;
            telephone= (TextView) itemView.findViewById(R.id.info_text4);
            bankAdress = (TextView) itemView.findViewById(R.id.info_text5);
        }

    }
}
