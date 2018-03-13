package com.ar.sphinx.picshare.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by sPhinx on 03/03/18.
 */

public class SearchActivity extends AppCompatActivity {

	private static final String TAG = "SearchActivity";
	private static final int ACTIVITY_NUM = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate: Running ");

		setupBottomNavView();
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
