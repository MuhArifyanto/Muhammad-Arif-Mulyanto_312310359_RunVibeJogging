package com.example.runvibejogging;

import android.os.Bundle;
import android.view.View;
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

        // Initialize views
        successIcon = findViewById(R.id.successIcon);
        successMessage = findViewById(R.id.successMessage);
        kembaliBerbelanjaButton = findViewById(R.id.kembaliBerbelanjaButton);

        // Set message text
        successMessage.setText("Pembayaran Anda Telah Berhasil");

        // Button click listener for kembali berbelanja
        kembaliBerbelanjaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToShopping();
            }
        });
    }

    // Handle back to shopping logic
    private void goBackToShopping() {
        // You can add logic to navigate back to the shopping page or any other activity
        // For example, if you want to navigate to the main shopping screen:
        // Intent intent = new Intent(PaymentSuccessActivity.this, ShoppingActivity.class);
        // startActivity(intent);
        // finish();
    }
}
