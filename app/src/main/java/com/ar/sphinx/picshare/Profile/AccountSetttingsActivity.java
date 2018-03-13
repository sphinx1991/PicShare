package com.ar.sphinx.picshare.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ar.sphinx.picshare.utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by sPhinx on 04/03/18.
 */

public class AccountSetttingsActivity extends AppCompatActivity {

	private static final String TAG = "AccountSetttingsActivit";
	private static final int ACTIVITY_NUM = 4; //same as profile
	private SectionsStatePagerAdapter sectionsStatePagerAdapter;
	private ViewPager viewPager;
	private RelativeLayout relativeLayout;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_settings);
		setupBottomNavView();
		setupSettingsOptionsList();
		setupBackFunc();
		setupFragmentsAdapter();
	}

	public void setupViewPager(int fragmentNumber){
		relativeLayout = findViewById(R.id.rel_layout_acc_settings);
		relativeLayout.setVisibility(View.GONE);
		viewPager = findViewById(R.id.view_pager);
		viewPager.setAdapter(sectionsStatePagerAdapter);
		viewPager.setCurrentItem(fragmentNumber);
		AppUtils.LogMsgUtil(TAG,"setup viewpager finished");
	}

	public void setupFragmentsAdapter(){
		sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
		sectionsStatePagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.fragment_edit_profile));
		sectionsStatePagerAdapter.addFragment(new SignOutFragment(),getString(R.string.fragment_signout));
		AppUtils.LogMsgUtil(TAG,"setup adapter finished");
	}

	private void setupBackFunc() {
		ImageView backBtn = findViewById(R.id.back_settings);
		backBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	private void setupSettingsOptionsList() {
		ListView listView = findViewById(R.id.list_settings);
		ArrayList<String> list = new ArrayList<>();
		list.add(getString(R.string.fragment_edit_profile));
		list.add(getString(R.string.fragment_signout));
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				setupViewPager(position);
			}
		});
	}

	private void setupBottomNavView() {
		BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_nav_bar);
		BottomNavViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
		BottomNavViewHelper.enableNavigation(this,bottomNavigationViewEx);
		Menu menu = bottomNavigationViewEx.getMenu();
		MenuItem item = menu.getItem(ACTIVITY_NUM);
		item.setChecked(true);
		AppUtils.LogMsgUtil(TAG,"set up bottom nav view");
	}
}
