package com.infogator.pk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sign extends AppCompatActivity {
    private EditText usernameEditText, emailEditText, passwordEditText;
    private Button signupButton;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        // Find views by their IDs
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.loginButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the input values from the EditText fields
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Perform signup validation
                if (isValidSignup(username, email, password)) {
                    // Store the username and password in SharedPreferences
                    saveCredentials(username, password);

                    // Show a success message
                    Toast.makeText(sign.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sign.this, MainActivity.class);
                    startActivity(i);
                    finish();


                    // Optionally, you can navigate to the next screen or perform any other desired action
                }
            }
        });
    }

    private boolean isValidSignup(String username, String email, String password) {
        // Perform validation logic for the signup inputs
        // Add your own validation criteria here

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void saveCredentials(String username, String password) {
        // Store the username and password in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME_KEY, username);
        editor.putString(PASSWORD_KEY, password);
        editor.apply();
    }
}
