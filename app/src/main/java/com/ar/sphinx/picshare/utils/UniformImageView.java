package com.ar.sphinx.picshare.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by sPhinx on 15/03/18.
 */

public class UniformImageView extends AppCompatImageView {

	public UniformImageView(Context context) {
		super(context);
	}

	public UniformImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UniformImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
}
