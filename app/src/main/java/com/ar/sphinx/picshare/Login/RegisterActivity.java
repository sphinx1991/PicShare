package com.ar.sphinx.picshare.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ar.sphinx.picshare.R;

public class RegisterActivity extends AppCompatActivity {

	private static final String TAG = "RegisterActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		Log.d(TAG, "onCreate: Running ");

	}
}
