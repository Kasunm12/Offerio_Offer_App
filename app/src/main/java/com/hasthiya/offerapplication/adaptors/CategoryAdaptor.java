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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hasthiya.offerapplication.PizzaActivity;
import com.hasthiya.offerapplication.R;
import com.hasthiya.offerapplication.SubCategoryActivity;
import com.hasthiya.offerapplication.dto.Shop.GetAllCategory;

import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.CategoryViewHolder> {

    Context mContext;
    ArrayList<GetAllCategory.Data> mData;
    CategoryAdaptor.onItemClickListener onItemClickListener;
    int size;

    public CategoryAdaptor(Context mContext, ArrayList<GetAllCategory.Data> mData, CategoryAdaptor.onItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CategoryAdaptor.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.activity_category_item,parent,false);
        return new CategoryAdaptor.CategoryViewHolder(layout,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptor.CategoryViewHolder holder, int position) {
        holder.categoryName.setText(mData.get(position).getCatName());
        if (mData.get(position).getImage() != null) {
            Glide.with(mContext)
                    .load(mData.get(position).getImage())
                    .into(holder.categoryImage);
        }
        holder.cn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SubCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String categoryName = mData.get(position).getCatName();
                intent.putExtra("category_name", categoryName);
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout cn_1;
        public CategoryViewHolder(@NonNull View itemView, CategoryAdaptor.onItemClickListener onItemClickListener) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.menu1);
            categoryImage = itemView.findViewById(R.id.menu_img_1);
            cn_1 = itemView.findViewById(R.id.cn_1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClickCategory(getAdapterPosition());
        }
    }

    public interface onItemClickListener {
        void onItemClickCategory(int position);
    }
}
