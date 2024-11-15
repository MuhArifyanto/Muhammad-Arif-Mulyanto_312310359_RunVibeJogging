package com.example.runvibejogging;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private ImageButton btnTogglePassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout as the root layout
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setGravity(Gravity.CENTER);
        rootLayout.setPadding(40, 40, 40, 40);

        // Create and set up EditText for email
        etEmail = new EditText(this);
        etEmail.setHint("Email Address");
        rootLayout.addView(etEmail);

        // Create and set up EditText for password
        etPassword = new EditText(this);
        etPassword.setHint("Password");
        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        rootLayout.addView(etPassword);

        // Create and set up ImageButton for password visibility toggle
        btnTogglePassword = new ImageButton(this);
        btnTogglePassword.setImageResource(android.R.drawable.ic_menu_view); // Default icon
        rootLayout.addView(btnTogglePassword);

        // Create and set up Button for sign-in
        Button btnSignIn = new Button(this);
        btnSignIn.setText("Sign In");
        rootLayout.addView(btnSignIn);

        // Set the root layout as the content view
        setContentView(rootLayout);

        // Set password toggle functionality
        btnTogglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    btnTogglePassword.setImageResource(android.R.drawable.ic_menu_view); // Visibility icon
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    btnTogglePassword.setImageResource(android.R.drawable.ic_delete); // Another icon when password is visible
                }
                isPasswordVisible = !isPasswordVisible;
                etPassword.setSelection(etPassword.getText().length());
            }
        });

        // Set sign-in button functionality
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle sign-in logic here (e.g., API call or database authentication)
                    Toast.makeText(login.this, "Sign-in successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
