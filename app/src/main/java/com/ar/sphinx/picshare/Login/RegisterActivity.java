package com.ar.sphinx.picshare.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ar.sphinx.picshare.R;
import com.ar.sphinx.picshare.models.User;
import com.ar.sphinx.picshare.models.UserAccountSettings;
import com.ar.sphinx.picshare.utils.AppUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

	private static final String TAG = "RegisterActivity";
	private EditText etEmail;
	private EditText etPassword;
	private EditText etUserName;
	private String tempuserName;
	private Button btnSignUp;
	private ProgressBar progressBar;
	private FirebaseAuth mAuth;
	private FirebaseDatabase mData;
	private DatabaseReference mDataRef;


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
		tempuserName = etUserName.getText().toString();
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

	private void registerNewUser(final String name, String email, String password) {
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
						checkAndAddUserToDatabase(name);
//						startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
//						finish();
					} else {
						// If sign in fails, display a message to the user.
						Log.w(TAG, "createUserWithEmail:failure", task.getException());
						AppUtils.showAtoast("FAiled",RegisterActivity.this);
					}
					progressBar.setVisibility(View.GONE);
				}
			});
		}
	}


	/********** Firebase setup *********************/

	private void setupFirebaseAuth() {
		mAuth = FirebaseAuth.getInstance();
		mData = FirebaseDatabase.getInstance();
		mDataRef = mData.getReference();
	}

	private String append;
	private void checkAndAddUserToDatabase(final String username){
		// Read from the database
		mDataRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				// This method is called once with the initial value and again
				// whenever data at this location is updated.

				//check if username is not already in user
				if(checkIfUserExits(username,dataSnapshot)){
					append = mDataRef.push().getKey().substring(0,7);
					Log.d(TAG, "onDataChange: Name already exits. Appending it :"+ append);
					tempuserName = tempuserName +append;
				}else {
					tempuserName = username;
				}

				//add new user to database
				addNewUser(etEmail.getText().toString(),tempuserName,"","","");
				progressBar.setVisibility(View.GONE);

				//add new user_account_settings to the database
			}

			@Override
			public void onCancelled(DatabaseError error) {
				// Failed to read value
				Log.w(TAG, "Failed to read value.", error.toException());
			}
		});
	}

	private void addNewUser(String email,String username,String desc,String website,String profile_photo){
		User user = new User(email,"1","user1",username);
		mDataRef.child("users")
				.child("user1")
				.setValue(user);

		UserAccountSettings accountSettings = new UserAccountSettings(desc,username,"0","0","0"
				,profile_photo,username);
		mDataRef.child("user_account_settings")
				.child("user1")
				.setValue(accountSettings);
		AppUtils.showAtoast("user added",this);
	}

	private boolean checkIfUserExits(String username, DataSnapshot dataSnapshot){
		Log.d(TAG, "checkIfUserExits: "+ username );
		User user = new User();
		for(DataSnapshot dataSnap : dataSnapshot.child("user1").getChildren()){
			Log.d(TAG, "checkIfUserExits: dataSnapshot:"+ dataSnapshot);
			user.setUsername(dataSnap.getValue(User.class).getUsername());
			if(user.getUsername().equals(username)){
				Log.d(TAG, "checkIfUserExits: Yes exists "+ user.getUsername());
				return true;
			}
		}
		return false;
	}

}
