package com.yuncool.yun_android.adapter;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.view.RoundedCornerOutlineProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/17.
 */
public class VisitShopAdapter extends RecyclerView.Adapter<VisitShopAdapter.ViewHolder> {

    List<ShopModel> modelList = new ArrayList<>();

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
    public void onBindViewHolder(ViewHolder holder, int position) {

        //TODO
        holder.iv_shop_pic.setOutlineProvider(new RoundedCornerOutlineProvider());
        holder.iv_shop_pic.setClipToOutline(true);

        holder.btn_visit_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Toast.makeText(view.getContext(), "正在开发中", Toast.LENGTH_SHORT).show();
            }
        });

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
}
