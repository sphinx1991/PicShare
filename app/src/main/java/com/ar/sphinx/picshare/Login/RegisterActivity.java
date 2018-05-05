package com.ar.sphinx.picshare.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

	private static final String TAG = "RegisterActivity";
	private EditText etEmail;
	private EditText etPassword;
	private EditText etUserName;
	private Button btnSignUp;
	private ProgressBar progressBar;
	private FirebaseAuth mAuth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		Log.d(TAG, "onCreate: Running ");
		setupFirebaseAuth();
		init();
	}

	private void init() {
		etEmail = findViewById(R.id.et_register_email);
		etPassword = findViewById(R.id.et_register_password);
		etUserName = findViewById(R.id.et_register_username);
		btnSignUp = findViewById(R.id.btn_signup);
		progressBar = findViewById(R.id.progressBar_register);
		progressBar.setVisibility(View.GONE);

		btnSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				registerNewUser(etUserName.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString());
			}
		});
	}

	private void registerNewUser(String name, String email, String password) {
		if(name.equals("") || email.equals("") || password.equals("")) {
			AppUtils.showAtoast("Enter all info..", this);
		} else {
			progressBar.setVisibility(View.VISIBLE);
			mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
				@Override
				public void onComplete(@NonNull Task<AuthResult> task) {
					if(task.isSuccessful()) {
						// Sign in success, update UI with the signed-in user's information
						Log.d(TAG, "createUserWithEmail:success");
						FirebaseUser user = mAuth.getCurrentUser();
						AppUtils.showAtoast("User: "+ user.getDisplayName(),RegisterActivity.this);
					} else {
						// If sign in fails, display a message to the user.
						Log.w(TAG, "createUserWithEmail:failure", task.getException());
						AppUtils.showAtoast("FAiled",RegisterActivity.this);
					}
				}
			});
		}
	}


	/********** Firebase setup *********************/

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
			startActivity(new Intent(this,LoginActivity.class));
			finish();
		}
	}
}
