package com.yuncool.yun_android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/16.
 */
public class ShareLinksAdapter extends RecyclerView.Adapter<ShareLinksAdapter.ViewHolder> {

    private List<ShopModel> modelList = new ArrayList<>();

    public ShareLinksAdapter(List<ShopModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share_links, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //TODO
        //holder.iv_shop_pic
        holder.tv_shop_name.setText(modelList.get(position).shopName);
        holder.tv_area.setText(modelList.get(position).area);

        holder.btn_share_link.setOnClickListener(new View.OnClickListener() {
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
        public TextView tv_shop_name;
        public Button btn_share_link;
        public TextView tv_area;

        public ViewHolder(View itemView) {
            super(itemView);

            this.iv_shop_pic = (ImageView) itemView.findViewById(R.id.iv_shop_pic);
            this.tv_shop_name = (TextView) itemView.findViewById(R.id.tv_shop_name);
            this.btn_share_link = (Button) itemView.findViewById(R.id.btn_share_link);
            this.tv_area = (TextView) itemView.findViewById(R.id.tv_area);
        }
    }
}
