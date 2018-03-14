package com.ar.sphinx.picshare.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ar.sphinx.picshare.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sPhinx on 15/03/18.
 */

public class GridImageAdapter extends ArrayAdapter<String> {

	private LayoutInflater layoutInflater;
	private Context context;
	private int resourceLayout;
	private ArrayList<String> imgUrls;

	public GridImageAdapter(Context context, int resource, ArrayList<String> imageUrls) {
		super(context, resource, imageUrls);
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		this.resourceLayout = resource;
		this.imgUrls = imageUrls;
	}

	private static class ViewHolder{
		ImageView imageView;
		ProgressBar progressBar;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		final ViewHolder holder;
		if(convertView == null){
			convertView = layoutInflater.inflate(resourceLayout,parent,false);
			holder = new ViewHolder();
			holder.imageView = convertView.findViewById(R.id.gridImageView);
			holder.progressBar = convertView.findViewById(R.id.gridProgressBar);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}

		String imgurl = getItem(position);
		UniversalImageLoader.setImage(imgurl,holder.imageView,holder.progressBar);
		return convertView;
	}
}
