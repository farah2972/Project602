package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(() -> {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                // User is already signed in, navigate to MainActivity
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            } else {
                // No user is signed in, navigate to LoginActivity
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
            }
            finish();
        }, 2000); // 2-second delay before navigating
    }
}
