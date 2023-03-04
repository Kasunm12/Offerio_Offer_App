package com.hasthiya.offerapplication.adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hasthiya.offerapplication.PizzaActivity;
import com.hasthiya.offerapplication.R;
import com.hasthiya.offerapplication.dto.Promotions.GetAllPromotions;

import java.util.ArrayList;

public class OfferAdaptor extends RecyclerView.Adapter<OfferAdaptor.OfferViewHolder> {

    Context mContext;
    ArrayList<GetAllPromotions.Data> mData;
    OfferAdaptor.onItemClickListener onItemClickListener;
    int size;
    public OfferAdaptor(Context mContext, ArrayList<GetAllPromotions.Data> mData, onItemClickListener onItemClickListener) {

        this.mContext = mContext;
        this.mData =  mData;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public OfferAdaptor.OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.home_list_item,parent,false);
        return new OfferAdaptor.OfferViewHolder(layout,onItemClickListener);
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

        holder.img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PizzaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String offerId = mData.get(position).getId();
                intent.putExtra("offerId", offerId);
                mContext.startActivity(intent);
            }
        });
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
        onItemClickListener onItemClickListener;
        public OfferViewHolder(@NonNull View itemView, OfferAdaptor.onItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            img_profile = itemView.findViewById(R.id.img_profile);
            tv_promotion = itemView.findViewById(R.id.tv_promotion);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClickOffer(getAdapterPosition());
            }
    }

    public interface onItemClickListener {
        void onItemClickOffer(int position);
    }
}
