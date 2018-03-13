package com.ar.sphinx.picshare.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by sPhinx on 04/03/18.
 */

public class AccountSetttingsActivity extends AppCompatActivity {

	private static final int ACTIVITY_NUM = 4; //same as profile

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_settings);
		setupBottomNavView();
		setupSettingsOptionsList();
		setupBackFunc();
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
		list.add("Edit Profile");
		list.add("Sign Out");
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);


	}

	private void setupBottomNavView() {
		BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_nav_bar);
		BottomNavViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
		BottomNavViewHelper.enableNavigation(this,bottomNavigationViewEx);
		Menu menu = bottomNavigationViewEx.getMenu();
		MenuItem item = menu.getItem(ACTIVITY_NUM);
		item.setChecked(true);
	}
}
