package com.example.instagram;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {
  public static final String TAG = "LoginActivity";
   private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null){
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });
    }
            private void loginUser(String username, String password) {
                Log.i(TAG, "Attempting to login user" + username);
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (e != null) {
                            //TODO: better error handling
                            Log.e(TAG, "Issue with Login", e);Toast.makeText(LoginActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //TODO: navigate to the main activity if the user has signed in properly.
                        goMainActivity();
                        Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
                private void goMainActivity(){
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();

                    // Create the ParseUser
                    ParseUser user = new ParseUser();
// Set core properties
                    user.setUsername("caylaw");
                    user.setPassword("pass!");
                    user.setEmail("email@example.com");
// Set custom properties
                    user.put("phone", "");
// Invoke signUpInBackground
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Hooray! Let them use the app now.
                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                            }
                        }
                    });
    }
}
