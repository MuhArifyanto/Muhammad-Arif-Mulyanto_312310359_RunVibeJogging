package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentSuccessActivity extends AppCompatActivity {
    private ImageView successIcon;
    private TextView successMessage;
    private Button kembaliBerbelanjaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayaran);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        successIcon = findViewById(R.id.successIcon);
        successMessage = findViewById(R.id.successMessage);
        kembaliBerbelanjaButton = findViewById(R.id.kembaliBerbelanjaButton);

        successMessage.setText("Pembayaran Anda Telah Berhasil");
    }

    private void setupClickListeners() {
        kembaliBerbelanjaButton.setOnClickListener(v -> goBackToShopping());
    }

    private void goBackToShopping() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}