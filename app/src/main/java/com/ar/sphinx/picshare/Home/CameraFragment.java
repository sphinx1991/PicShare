package com.ar.sphinx.picshare.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;

/**
 * Created by sPhinx on 04/03/18.
 */

public class CameraFragment extends Fragment{

	private static final String TAG = "CameraFragment";

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		AppUtils.LogMsgUtil(TAG,"onCreateView");
		View view = inflater.inflate(R.layout.fragment_camera,container,false);
		return view;
	}
}
