package com.hasthiya.offerapplication.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OfferAdaptor extends RecyclerView.Adapter<OfferAdaptor.OfferViewHolder> {

    Context mContext;

    @NonNull
    @Override
    public OfferAdaptor.OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdaptor.OfferViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class OfferViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
