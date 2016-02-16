package com.yuncool.yun_android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.MicroLibListItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/16.
 */
public class MicroLibListAdapter extends RecyclerView.Adapter<MicroLibListAdapter.ViewHolder> {

    List<MicroLibListItemModel> modelList = new ArrayList<>();

    public MicroLibListAdapter(List<MicroLibListItemModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_micro_lib_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_date.setText(modelList.get(position).date);
        holder.tv_month.setText(modelList.get(position).month);
        holder.tv_title.setText(modelList.get(position).title);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_date, tv_month, tv_title;

        public ViewHolder(View itemView) {

            super(itemView);
            this.tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            this.tv_month = (TextView) itemView.findViewById(R.id.tv_month);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
