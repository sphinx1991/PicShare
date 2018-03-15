package com.ar.sphinx.picshare.Profile;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.ar.sphinx.picshare.utils.BottomNavViewHelper;
import com.ar.sphinx.picshare.utils.GridImageAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by sPhinx on 03/03/18.
 */

public class ProfileActivity extends AppCompatActivity{

	private static final String TAG = "ProfileActivity";
	public static final int ACTIVITY_NUM = 4;
	private static final int NUM_COLOUMNS = 3;
	private ProgressBar progressBar;
	private ImageView imageView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Log.d(TAG, "onCreate: Running ");

		setupViews();
		setupBottomNavView();
		setupToolbar();

		gridSetup();
	}

	private void gridSetup() {
		ArrayList<String> list = new ArrayList<>();
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		list.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png");
		setupImageGrids(list);
	}

	private void setupImageGrids(ArrayList<String> imageUrls) {
		GridView gridView = findViewById(R.id.grid_view);
//		int gridWidth = getResources().getDisplayMetrics().widthPixels;
//		int imageWidth = gridWidth/NUM_COLOUMNS;
//		gridView.setColumnWidth(imageWidth);
		gridView.setNumColumns(NUM_COLOUMNS);
		GridImageAdapter adapter = new GridImageAdapter(this,R.layout.layout_gridview,imageUrls);
		gridView.setAdapter(adapter);
	}

	private void setupViews(){
		imageView = findViewById(R.id.img_edit_profile_pic);
		progressBar = findViewById(R.id.profile_progress_bar);
		progressBar.setVisibility(View.GONE);
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
