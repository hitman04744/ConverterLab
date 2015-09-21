package com.example.bohdan.converterlab.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bohdan.converterlab.DetailActivity;
import com.example.bohdan.converterlab.R;
import com.example.bohdan.converterlab.organisationsModel.Organisations;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BankViewHolder>  {

    private  ArrayList<Organisations> mOrganisations;
    private Context mContext;
    private  int position;

    public RVAdapter(Context mContext, ArrayList<Organisations> banks){
       this.mOrganisations = banks;
        this.mContext = mContext;
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
        holder.telephone.setText(mOrganisations.get(position).getPhone());
        holder.bankAdress.setText(mOrganisations.get(position).getAddress());

    }




    @Override
    public int getItemCount() {

        return  mOrganisations.size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public static  class BankViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        private TextView name;
        private TextView location;
        private TextView cityLocation;
        private TextView telephone;
        private TextView bankAdress;
        private ImageButton mDetail;
        private ImageButton mPhone;
        private ImageButton mMap;
        private ImageButton mLink;

        public BankViewHolder(View itemView) {
            super(itemView) ;
            ArrayList<Organisations> mList = new ArrayList<>();
            cv = (CardView) itemView.findViewById(R.id.card_view);
            name =  (TextView) itemView.findViewById(R.id.info_text);
            location = (TextView) itemView.findViewById(R.id.info_text2);
            cityLocation = (TextView) itemView.findViewById(R.id.info_text3) ;
            telephone= (TextView) itemView.findViewById(R.id.info_text4);
            bankAdress = (TextView) itemView.findViewById(R.id.info_text5);
            mDetail = (ImageButton) itemView.findViewById(R.id.next);
            mPhone = (ImageButton) itemView.findViewById(R.id.phone);
            mMap = (ImageButton) itemView.findViewById(R.id.map);
            mLink = (ImageButton) itemView.findViewById(R.id.link);

            mDetail.setOnClickListener(this);
            mPhone.setOnClickListener(this);
            mMap.setOnClickListener(this);
            mLink.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.next):
                    Intent showDetails = new Intent(itemView.getContext(), DetailActivity.class);
                    showDetails.putExtra("name", name.getText().toString());

                    itemView.getContext().startActivity(showDetails);
                    break;
                case (R.id.phone):
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + telephone.getText()));
                    itemView.getContext().startActivity(callIntent);

                    break;
                case (R.id.link):
                    Intent linkIntent = new Intent(Intent.ACTION_VIEW);
                    linkIntent.setData(Uri.parse("http:www.google.com"));
                    itemView.getContext().startActivity(linkIntent);

                    break;
                case (R.id.map):

                    break;
            }



        }
    }
}
