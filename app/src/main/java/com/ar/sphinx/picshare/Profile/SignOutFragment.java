package com.ar.sphinx.picshare.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.sphinx.picshare.R;

/**
 * Created by sPhinx on 14/03/18.
 */

public class SignOutFragment extends Fragment {

	private static final String TAG = "SignOutFragment";

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_signout,container,false);
		return view;
	}
}
