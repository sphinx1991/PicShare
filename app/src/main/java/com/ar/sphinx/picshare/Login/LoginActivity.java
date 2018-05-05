package com.ar.sphinx.picshare.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ar.sphinx.picshare.R;

public class LoginActivity extends AppCompatActivity {

	private static final String TAG = "LoginActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Log.d(TAG, "onCreate: Running ");
	}
}
