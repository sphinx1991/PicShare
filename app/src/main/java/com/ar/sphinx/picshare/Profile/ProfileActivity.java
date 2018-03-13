package com.ar.sphinx.picshare.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by sPhinx on 03/03/18.
 */

public class ProfileActivity extends AppCompatActivity{

	private static final String TAG = "ProfileActivity";
	public static final int ACTIVITY_NUM = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Log.d(TAG, "onCreate: Running ");

		setupBottomNavView();
		setupToolbar();
	}

	private void setupToolbar() {
		Toolbar toolbar = findViewById(R.id.profileToolbar);
		setSupportActionBar(toolbar);
		ImageView goToprofileMenu = findViewById(R.id.img_acc_settings_goto);
		goToprofileMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent settingsIntent = new Intent(ProfileActivity.this,AccountSetttingsActivity.class);
				startActivity(settingsIntent);
			}
		});
		AppUtils.LogMsgUtil(TAG,"setup toolbar finished");
	}

	private void setupBottomNavView() {
		BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_nav_bar);
		BottomNavViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
		BottomNavViewHelper.enableNavigation(this,bottomNavigationViewEx);
		Menu menu = bottomNavigationViewEx.getMenu();
		MenuItem item = menu.getItem(ACTIVITY_NUM);
		item.setChecked(true);
		AppUtils.LogMsgUtil(TAG,"setup bottom nav view finished");
	}
}
