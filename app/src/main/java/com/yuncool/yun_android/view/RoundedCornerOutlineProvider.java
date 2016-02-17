package com.yuncool.yun_android.view;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.yuncool.yun_android.R;

/**
 * Created by Black on 2016/2/16.
 */


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class RoundedCornerOutlineProvider extends ViewOutlineProvider {
    @Override
    public void getOutline(View view, Outline outline) {

        outline.setRoundRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(),
                view.getContext().getResources().getDimensionPixelSize(R.dimen.view_corner_radius));

    }
}
