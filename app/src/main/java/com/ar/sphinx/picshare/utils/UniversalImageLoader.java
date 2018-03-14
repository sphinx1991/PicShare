package com.ar.sphinx.picshare.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ar.sphinx.picshare.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by sPhinx on 14/03/18.
 */

public class UniversalImageLoader {

	private static final int default_image = R.drawable.ic_android;
	private Context context;

	public UniversalImageLoader(Context context){
		this.context = context;
	}

	public ImageLoaderConfiguration getConfig(){

		DisplayImageOptions imageOptions = new DisplayImageOptions.Builder()
				.showImageOnLoading(default_image)
				.showImageOnFail(default_image)
				.showImageForEmptyUri(default_image)
				.cacheOnDisk(true).cacheInMemory(true)
				.resetViewBeforeLoading(true)
				.imageScaleType(ImageScaleType.EXACTLY)
				.displayer(new FadeInBitmapDisplayer(300))
				.build();

		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
				.defaultDisplayImageOptions(imageOptions)
				.memoryCache(new WeakMemoryCache())
				.diskCacheSize(100*1024*1024)
				.build();
		return configuration;
	}

	public static void setImage(String imgUrl, ImageView imageView, final ProgressBar progressBar){
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.displayImage(imgUrl, imageView, new ImageLoadingListener() { //callback number to inform
																							  //when image loads/fail and what to do
			@Override
			public void onLoadingStarted(String imageUri, View view) {
				if(progressBar!=null){
					progressBar.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
				if(progressBar!=null){
					progressBar.setVisibility(View.GONE);
				}
			}

			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				if(progressBar!=null){
					progressBar.setVisibility(View.GONE);
				}
			}

			@Override
			public void onLoadingCancelled(String imageUri, View view) {
				if(progressBar!=null){
					progressBar.setVisibility(View.GONE );
				}
			}
		});
	}
}
