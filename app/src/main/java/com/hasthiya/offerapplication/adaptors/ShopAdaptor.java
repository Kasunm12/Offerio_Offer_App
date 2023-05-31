package com.hasthiya.offerapplication.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasthiya.offerapplication.R;
import com.hasthiya.offerapplication.dto.Shop.GetAllShopsByCategoryNameDTO;

import java.util.ArrayList;

public class ShopAdaptor extends RecyclerView.Adapter<ShopAdaptor.ShopViewHolder> {

    ShopAdaptor.onItemClickListener onItemClickListener;
    Context mContext;
    ArrayList<GetAllShopsByCategoryNameDTO.Data> mData;
    int size;

    public ShopAdaptor( Context mContext, ArrayList<GetAllShopsByCategoryNameDTO.Data> mData, ShopAdaptor.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ShopAdaptor.ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.search_list_item,parent,false);
        return new ShopAdaptor.ShopViewHolder(layout,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdaptor.ShopViewHolder holder, int position) {

        holder.shopName.setText(mData.get(position).getName());

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

    public class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        onItemClickListener onItemClickListener;
        TextView shopName;

        public ShopViewHolder(@NonNull View itemView, ShopAdaptor.onItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            shopName = itemView.findViewById(R.id.tv_address_search_01);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClickShop(getAdapterPosition());
        }
    }

    public interface onItemClickListener {
        void onItemClickShop(int position);
    }
}
