package com.ar.sphinx.picshare.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sPhinx on 04/03/18.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentList = new ArrayList<>();

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

	public void addFragment(Fragment fragment){
		fragmentList.add(fragment);
	}
}
