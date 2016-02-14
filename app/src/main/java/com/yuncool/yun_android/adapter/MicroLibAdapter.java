package com.yuncool.yun_android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuncool.yun_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/14.
 */
public class MicroLibAdapter extends RecyclerView.Adapter<MicroLibAdapter.ViewHolder> {

    private List<String> modelList = new ArrayList<>();

    public MicroLibAdapter(List<String> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_micro_lib, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.tv_micro_lib_name = (TextView) view.findViewById(R.id.tv_micro_lib_name);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String name = modelList.get(position);
        if (name != null) {
            holder.tv_micro_lib_name.setText(name);
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_micro_lib_name;

        public ViewHolder(View tv_micro_lib_name) {
            super(tv_micro_lib_name);
        }
    }
}
