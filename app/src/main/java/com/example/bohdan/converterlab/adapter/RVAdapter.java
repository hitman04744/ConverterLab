package com.example.bohdan.converterlab.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bohdan.converterlab.organisationsModel.Organisations;
import com.example.bohdan.converterlab.R;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BankViewHolder>  {

    ArrayList<Organisations> mOrganisations;

    public RVAdapter( ArrayList<Organisations> banks){
       this.mOrganisations = banks;
    }

    @Override
    public BankViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_card, viewGroup, false);
        BankViewHolder bvh = new BankViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(BankViewHolder holder, int position) {
        holder.name.setText( mOrganisations.get(position).getTitle());
        holder.location.setText( mOrganisations.get(position).getRegionId());
        holder.cityLocation.setText( mOrganisations.get(position).getCityId());
        holder.telephone.setText( mOrganisations.get(position).getPhone());
        holder.bankAdress.setText( mOrganisations.get(position).getAddress());

    }

    @Override
    public int getItemCount() {

        return  mOrganisations.size();
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
