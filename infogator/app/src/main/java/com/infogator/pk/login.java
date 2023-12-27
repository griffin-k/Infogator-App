package com.infogator.pk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find views by their IDs
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the input values from the EditText fields
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Perform login validation
                if (isValidLogin(username, password)) {
                    // Show a success message
                    Toast.makeText(login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    // Optionally, you can navigate to the next screen or perform any other desired action
                }
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        // Perform validation logic for the login inputs
        // Add your own validation criteria here

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Retrieve the stored username and password from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String storedUsername = sharedPreferences.getString(USERNAME_KEY, null);
        String storedPassword = sharedPreferences.getString(PASSWORD_KEY, null);

        // Check if the entered username and password match the stored credentials
        if (storedUsername != null && storedPassword != null && storedUsername.equals(username) && storedPassword.equals(password)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
