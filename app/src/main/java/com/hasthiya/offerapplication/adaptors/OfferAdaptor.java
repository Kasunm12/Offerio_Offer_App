package com.hasthiya.offerapplication.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hasthiya.offerapplication.R;
import com.hasthiya.offerapplication.dto.Promotions.GetAllPromotions;

import java.util.ArrayList;

public class OfferAdaptor extends RecyclerView.Adapter<OfferAdaptor.OfferViewHolder> {

    Context mContext;
    ArrayList<GetAllPromotions.Data> mData;
    int size;
    public OfferAdaptor(Context mContext, ArrayList<GetAllPromotions.Data> mData) {

        this.mContext = mContext;
        this.mData =  mData;
    }

    @NonNull
    @Override
    public OfferAdaptor.OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.home_list_item,parent,false);
        return new OfferAdaptor.OfferViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdaptor.OfferViewHolder holder, int position) {
        holder.tv_promotion.setText(mData.get(position).getOffer());
        System.out.println("***********************************"+ mData.get(position).getOffer());
        if (mData.get(position).getImage() != null) {
            Glide.with(mContext)
                    .load(mData.get(position).getImage())
                    .into(holder.img_profile);
        }

    }

    @Override
    public int getItemCount() {
        try{
            size  = mData.size();
        } catch (Exception e){
            Toast.makeText(mContext.getApplicationContext(), "No any objects for this sub category", Toast.LENGTH_SHORT).show();
        }
        return size;
    }


    public class OfferViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img_profile;
        TextView tv_promotion;
        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);

            img_profile = itemView.findViewById(R.id.img_profile);
            tv_promotion = itemView.findViewById(R.id.tv_promotion);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
