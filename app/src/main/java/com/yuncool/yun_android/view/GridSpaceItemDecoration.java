package com.yuncool.yun_android.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Black on 2016/2/12.
 */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int spacingInPixel;

    public GridSpaceItemDecoration(int spacingPixel) {
        this.spacingInPixel = spacingPixel;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int halfSpacingInPixel = spacingInPixel / 2;
        outRect.top = halfSpacingInPixel;
        outRect.right = halfSpacingInPixel;
        outRect.bottom = halfSpacingInPixel;
        outRect.left = halfSpacingInPixel;

    }
}
