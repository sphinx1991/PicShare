package com.ar.sphinx.picshare.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sPhinx on 14/03/18.
 */

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

	private List<Fragment> fragmentList = new ArrayList<>();
	private HashMap<Fragment,Integer> mFragments = new HashMap<>();
	private HashMap<String,Integer> mFragmentNumbers = new HashMap<>();
	private HashMap<Integer,String> mFragmentNames = new HashMap<>();


	public SectionsStatePagerAdapter(FragmentManager fm) {
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

	private void addFragment(Fragment fragment,String fragmentName){
		fragmentList.add(fragment);
		mFragments.put(fragment,fragmentList.size()-1);
		mFragmentNumbers.put(fragmentName,fragmentList.size()-1);
		mFragmentNames.put(fragmentList.size()-1,fragmentName);
	}

	public Integer getFragmentNumber(String fragmentName){
		if(mFragmentNumbers.containsKey(fragmentName)){
			return mFragmentNumbers.get(fragmentName);
		}else {
			return null;
		}
	}

	public Integer getFragmentNumber(Fragment fragment){
		if(mFragmentNumbers.containsKey(fragment)){
			return mFragmentNumbers.get(fragment);
		}else {
			return null;
		}
	}

	public String getFragmentName(Integer fragmentNumber){
		if(mFragmentNames.containsKey(fragmentNumber)){
			return mFragmentNames.get(fragmentNumber);
		}else {
			return null;
		}
	}
}
