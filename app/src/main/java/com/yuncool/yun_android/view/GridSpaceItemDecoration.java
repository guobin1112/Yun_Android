package com.yuncool.yun_android.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuncool.yun_android.R;

/**
 * Created by Black on 2016/2/12.
 */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int spacingInPixel;
    private int lineDividerWidthInPixcel = 0;

    public GridSpaceItemDecoration(int spacingPixel) {
        this.spacingInPixel = spacingPixel;
    }

    public GridSpaceItemDecoration(int spacingInPixel, int lineDividerWidthInPixcel) {
        this.spacingInPixel = spacingInPixel;
        this.lineDividerWidthInPixcel = lineDividerWidthInPixcel;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int halfSpacingInPixel = spacingInPixel / 2;
        outRect.top = halfSpacingInPixel;
        outRect.right = halfSpacingInPixel;
        outRect.bottom = halfSpacingInPixel;
        outRect.left = halfSpacingInPixel;

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        Drawable dividerDrawable = new ColorDrawable(parent.getContext().getResources().getColor(R.color.colorLineDivider));

        View childView;
        RecyclerView.LayoutParams childLayoutParams;

        if (lineDividerWidthInPixcel > 0) {

            for (int i = 1; i < parent.getChildCount(); i += 2) {

                childView = parent.getChildAt(i);
                childLayoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();

                int left = parent.getLeft();
                int top = childView.getBottom() + childLayoutParams.bottomMargin;
                int right = parent.getRight();
                int bottom = top + lineDividerWidthInPixcel;

                dividerDrawable.setBounds(left, top, right, bottom);

                dividerDrawable.draw(c);

            }

        }
    }
}
