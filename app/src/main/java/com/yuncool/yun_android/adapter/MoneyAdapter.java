package com.yuncool.yun_android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.yuncool.yun_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/18.
 */
public class MoneyAdapter extends RecyclerView.Adapter<MoneyAdapter.ViewHolder> {

    private List<Integer> list = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public MoneyAdapter(List<Integer> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_money, parent, false);

        return new ViewHolder((ToggleButton) view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int moneyNumber = list.get(position);

        if (moneyNumber > 0) {

            holder.tb_money.setTextOn(String.valueOf(moneyNumber) + "云币");
            holder.tb_money.setTextOff(String.valueOf(moneyNumber) + "云币");

        } else {

            holder.tb_money.setTextOn("其他数额");
            holder.tb_money.setTextOff("其他数额");

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ToggleButton tb_money;

        public ViewHolder(ToggleButton tb_money) {
            super(tb_money);

            this.tb_money = tb_money;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
