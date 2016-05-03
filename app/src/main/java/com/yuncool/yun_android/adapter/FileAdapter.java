package com.yuncool.yun_android.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.FileModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/2/14.
 */
public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {

    private List<FileModel> modelList = new ArrayList<>();

    private Context context;

    private OnItemClickListener onItemClickListener;

    public FileAdapter(List<FileModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_micro_lib, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.tv_micro_lib_name = (TextView) view.findViewById(R.id.tv_micro_lib_name);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String name = modelList.get(position).fileName;
        if (name != null) {
            holder.tv_micro_lib_name.setText(name);
        }

        Drawable drawable;

/// 这一步必须要做,否则不会显示.

        switch (modelList.get(position).fileType) {
            case FileModel.DOC:

                drawable = context.getResources().getDrawable(R.drawable.doc);

                break;
            case FileModel.PPT:

                drawable = context.getResources().getDrawable(R.drawable.ppt);

                break;
            case FileModel.XLS:

                drawable = context.getResources().getDrawable(R.drawable.xls);

                break;
            case FileModel.PDF:

                drawable = context.getResources().getDrawable(R.drawable.pdf);

                break;
            case FileModel.TXT:

                drawable = context.getResources().getDrawable(R.drawable.txt);

                break;
            case FileModel.OTHER:

                drawable = context.getResources().getDrawable(R.drawable.other);

                break;
            default:

                drawable = context.getResources().getDrawable(R.drawable.other);

                break;
        }


        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        holder.tv_micro_lib_name.setCompoundDrawables(drawable, null, null, null);


    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }
}
