package com.ar.sphinx.picshare.Profile;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by sPhinx on 14/03/18.
 */

public class EditProfileFragment extends Fragment {

	private static final String TAG = "EditProfileFragment";
	private ImageView profileImgView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
		profileImgView = view.findViewById(R.id.img_profilepic);
		initImageLoader();
		setProfileImage();
		return view;
	}

	private void setProfileImage() {
		String imageUrl = "https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/08/21/20/android-oreo-2.png";
		UniversalImageLoader.setImage(imageUrl,profileImgView,null,"");
	}

	private void initImageLoader() {
		UniversalImageLoader imageLoader = new UniversalImageLoader(getContext());
		ImageLoader.getInstance().init(imageLoader.getConfig());
	}
}
