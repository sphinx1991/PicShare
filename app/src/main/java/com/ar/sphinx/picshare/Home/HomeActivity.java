package com.ar.sphinx.picshare.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ar.sphinx.picshare.utils.SectionsPagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

	private static final String TAG = "HomeActivity";
	public static final int ACTIVITY_NUM = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate: Running ");

		setupBottomNavView();
		setupViewPager();
	}

	private void setupViewPager() {
		SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new CameraFragment()); //0
		adapter.addFragment(new HomeFragment()); //1
		adapter.addFragment(new MessagesFragment()); //2
		ViewPager viewPager = findViewById(R.id.view_pager);
		viewPager.setAdapter(adapter);

		TabLayout tabLayout = findViewById(R.id.tab_layout);
		tabLayout.setupWithViewPager(viewPager);
		tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
		tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
		tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);

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
