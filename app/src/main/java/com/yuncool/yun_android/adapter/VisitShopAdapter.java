package com.yuncool.yun_android.adapter;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/17.
 */
public class VisitShopAdapter extends RecyclerView.Adapter<VisitShopAdapter.ViewHolder> {

    List<ShopModel> modelList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public VisitShopAdapter(List<ShopModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visit_shop, parent, false);

        return new ViewHolder(view);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //TODO
//        holder.iv_shop_pic.setOutlineProvider(new RoundedCornerOutlineProvider());
//        holder.iv_shop_pic.setClipToOutline(true);

        holder.iv_shop_pic.setImageResource(modelList.get(position).shopImageResId);

        if (onItemClickListener != null) {
            holder.iv_shop_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(position);
                }
            });
            holder.btn_visit_shop.setOnClickListener(new View.OnClickListener() {
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_shop_pic;
        public Button btn_visit_shop;


        public ViewHolder(View itemView) {
            super(itemView);

            this.iv_shop_pic = (ImageView) itemView.findViewById(R.id.iv_shop_pic);
            this.btn_visit_shop = (Button) itemView.findViewById(R.id.btn_visit_shop);

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void onItemClick(int position);

    }
}
