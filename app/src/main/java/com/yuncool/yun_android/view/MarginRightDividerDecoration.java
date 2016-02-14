package com.yuncool.yun_android.view;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuncool.yun_android.R;

/**
 * Created by Black on 2016/2/14.
 */
public class MarginRightDividerDecoration extends RecyclerView.ItemDecoration {

    private int marginLeftInPixel;

    public MarginRightDividerDecoration(int marginLeftInPixel) {
        this.marginLeftInPixel = marginLeftInPixel;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {

        Drawable dividerDrawable = new ColorDrawable(
                parent.getContext().getResources().getColor(R.color.colorLineDivider));

        for (int i = 0; i < parent.getChildCount() - 1; i++) {

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams childParams = (RecyclerView.LayoutParams) child.getLayoutParams();

            dividerDrawable.setBounds(parent.getLeft() + marginLeftInPixel,
                    child.getBottom() + childParams.bottomMargin,
                    parent.getRight(),
                    child.getBottom() + childParams.bottomMargin + parent.getContext().getResources().getDimensionPixelSize(R.dimen.view_min_dimen));

            dividerDrawable.draw(c);
        }

    }
}
