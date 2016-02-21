package com.yuncool.yun_android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.ShopModel;

import java.util.List;

/**
 * Created by Black on 2016/2/12.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private List<ShopModel> modelList;

    private OnItemClickListener onItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_shop;
        public TextView tv_shop;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_shop = (ImageView) itemView.findViewById(R.id.iv_shop);
            tv_shop = (TextView) itemView.findViewById(R.id.tv_shop);
        }


    }

    public ShopAdapter(List<ShopModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.iv_shop.setImageResource(modelList.get(position).shopImageResId);
        holder.tv_shop.setText(modelList.get(position).shopName);

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(position);
                }
            });

        }
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void onItemClick(int position);

    }
}
