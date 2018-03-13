package com.ar.sphinx.picshare.utils;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ar.sphinx.picshare.Home.HomeActivity;
import com.ar.sphinx.picshare.Like.LikeActivity;
import com.ar.sphinx.picshare.Profile.ProfileActivity;
import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.Search.SearchActivity;
import com.ar.sphinx.picshare.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by sPhinx on 03/03/18.
 */

public class BottomNavViewHelper {

	private static final String TAG = "BottomNavViewHelper";

	public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
		bottomNavigationViewEx.enableAnimation(false);
		bottomNavigationViewEx.enableItemShiftingMode(false);
		bottomNavigationViewEx.enableShiftingMode(false);
		bottomNavigationViewEx.setTextVisibility(false);
	}

	public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx){
		viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch(item.getItemId()){

					case R.id.ic_house:
						Intent intentOne = new Intent(context, HomeActivity.class);
						context.startActivity(intentOne);
						break;

					case R.id.ic_search:
						Intent intentTwo = new Intent(context, SearchActivity.class);
						context.startActivity(intentTwo);
						break;

					case R.id.ic_circle:
						Intent intentThree = new Intent(context, ShareActivity.class);
						context.startActivity(intentThree);
						break;

					case R.id.ic_alert:
						Intent intentFour = new Intent(context, LikeActivity.class);
						context.startActivity(intentFour);
						break;

					case R.id.ic_android:
						Intent intentFive = new Intent(context, ProfileActivity.class);
						context.startActivity(intentFive);
						break;
				}
				return false;
			}
		});
	}
}
