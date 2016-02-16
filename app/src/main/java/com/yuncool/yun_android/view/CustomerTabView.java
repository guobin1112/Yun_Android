package com.yuncool.yun_android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuncool.yun_android.R;

/**
 * Created by Black on 2016/2/16.
 */
public class CustomerTabView extends LinearLayout {

    private RadioGroup rg_customer_tab;
    private RadioButton rb_left, rb_middle, rb_right;

    private String leftText, middleText, rightText;

    private OnTabChangedListener onTabChangedListener;


    public CustomerTabView(Context context) {
        this(context, null);
    }

    public CustomerTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomerTabView);

        leftText = typedArray.getString(R.styleable.CustomerTabView_leftText);
        middleText = typedArray.getString(R.styleable.CustomerTabView_middleText);
        rightText = typedArray.getString(R.styleable.CustomerTabView_rightText);

        typedArray.recycle();

        if (leftText == null) {
            leftText = "leftText";
        }
        if (middleText == null) {
            middleText = "middleText";
        }
        if (rightText == null) {
            rightText = "rightText";
        }

        LayoutInflater.from(context).inflate(R.layout.view_customer_tab, this, true);

        rg_customer_tab = (RadioGroup) findViewById(R.id.rg_customer_tab);
        rb_left = (RadioButton) findViewById(R.id.rb_left);
        rb_middle = (RadioButton) findViewById(R.id.rb_middle);
        rb_right = (RadioButton) findViewById(R.id.rb_right);

        rb_left.setText(leftText);
        rb_middle.setText(middleText);
        rb_right.setText(rightText);

        rb_left.setChecked(true);

        rg_customer_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (onTabChangedListener != null) {
                    switch (i) {
                        case R.id.rb_left:

                            onTabChangedListener.checkLeft();

                            break;
                        case R.id.rb_middle:

                            onTabChangedListener.checkMiddle();

                            break;
                        case R.id.rb_right:

                            onTabChangedListener.checkRight();

                            break;
                    }
                }
            }
        });

    }

    public void setOnTabChangedListener(OnTabChangedListener onTabChangedListener) {
        this.onTabChangedListener = onTabChangedListener;
    }

    public interface OnTabChangedListener {
        void checkLeft();

        void checkMiddle();

        void checkRight();
    }

}
