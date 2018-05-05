package com.ar.sphinx.picshare.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

	private static final String TAG = "LoginActivity";
	private EditText etEmail;
	private EditText etPassword;
	private Button btnSignIn;
	private TextView tvNewUser;
	private ProgressBar progressBar;
	private FirebaseAuth mAuth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Log.d(TAG, "onCreate: Running ");
		setupFirebaseAuth();
		init();
	}

	private void init() {
		etEmail = findViewById(R.id.et_email);
		etPassword = findViewById(R.id.et_password);
		btnSignIn = findViewById(R.id.btn_signin);
		tvNewUser = findViewById(R.id.tv_newUser);
		progressBar = findViewById(R.id.progressBar);
		progressBar.setVisibility(View.GONE);
		btnSignIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email = etEmail.getText().toString();
				String pass = etPassword.getText().toString();
				if(email.isEmpty() && pass.isEmpty()){
					AppUtils.showAtoast("Please fill out all details",LoginActivity.this);
				}else {
					progressBar.setVisibility(View.VISIBLE);
					mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(
							LoginActivity.this, new OnCompleteListener<AuthResult>() {
						@Override
						public void onComplete(@NonNull Task<AuthResult> task) {
							if(task.isSuccessful()) {
								// Sign in success, update UI with the signed-in user's information
								Log.d(TAG, "signInWithEmail:success");
								AppUtils.showAtoast("succesfull",LoginActivity.this);
								progressBar.setVisibility(View.GONE);
							} else {
								// If sign in fails, display a message to the user.
								Log.w(TAG, "signInWithEmail:failure", task.getException());
								AppUtils.showAtoast("failure",LoginActivity.this);
								progressBar.setVisibility(View.GONE);
							}
						}
					});
				}
			}
		});
	}

	private void setupFirebaseAuth() {
		mAuth = FirebaseAuth.getInstance();
	}

	@Override
	public void onStart() {
		super.onStart();
		FirebaseUser currentUser = mAuth.getCurrentUser();
		checkCurrentUser(currentUser);
	}
	private void checkCurrentUser(FirebaseUser currentUser) {
		if(currentUser == null){

		}
	}

}
