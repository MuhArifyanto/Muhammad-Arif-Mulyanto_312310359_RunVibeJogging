package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CartActivity extends AppCompatActivity {
    private ImageButton btnBack;
    private TextView tvHeaderTitle;
    private LinearLayout cartItemsContainer;
    private CardView firstItemCard, secondItemCard;
    private ImageView firstItemImage, secondItemImage;
    private TextView firstItemName, firstItemPrice, firstItemSize, tvFirstItemQuantity;
    private TextView secondItemName, secondItemPrice, secondItemSize, tvSecondItemQuantity;
    private ImageButton btnDecreaseFirstItem, btnIncreaseFirstItem, btnDeleteFirstItem;
    private ImageButton btnDecreaseSecondItem, btnIncreaseSecondItem, btnDeleteSecondItem;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keranjang);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        // Header
        btnBack = findViewById(R.id.btnBack);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        cartItemsContainer = findViewById(R.id.cartItemsContainer);

        // First Item
        firstItemCard = findViewById(R.id.firstItemCard);
        firstItemImage = findViewById(R.id.firstItemImage);
        firstItemName = findViewById(R.id.firstItemName);
        firstItemPrice = findViewById(R.id.firstItemPrice);
        firstItemSize = findViewById(R.id.firstItemSize);
        tvFirstItemQuantity = findViewById(R.id.tvFirstItemQuantity);

        // Second Item
        secondItemCard = findViewById(R.id.secondItemCard);
        secondItemImage = findViewById(R.id.secondItemImage);
        secondItemName = findViewById(R.id.secondItemName);
        secondItemPrice = findViewById(R.id.secondItemPrice);
        secondItemSize = findViewById(R.id.secondItemSize);
        tvSecondItemQuantity = findViewById(R.id.tvSecondItemQuantity);

        // Buttons
        btnCheckout = findViewById(R.id.btnCheckout);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(v -> onBackPressed());

        btnCheckout.setOnClickListener(v -> {
            if (firstItemCard.getVisibility() == View.VISIBLE) {
                navigateToPaymentSuccess(
                        firstItemName.getText().toString(),
                        firstItemPrice.getText().toString(),
                        Integer.parseInt(tvFirstItemQuantity.getText().toString())
                );
            } else if (secondItemCard.getVisibility() == View.VISIBLE) {
                navigateToPaymentSuccess(
                        secondItemName.getText().toString(),
                        secondItemPrice.getText().toString(),
                        Integer.parseInt(tvSecondItemQuantity.getText().toString())
                );
            }
        });
    }

    private void navigateToPaymentSuccess(String productName, String productPrice, int quantity) {
        Intent intent = new Intent(CartActivity.this, PaymentSuccessActivity.class);
        intent.putExtra("PRODUCT_NAME", productName);
        intent.putExtra("PRODUCT_PRICE", productPrice);
        intent.putExtra("PRODUCT_QUANTITY", quantity);
        startActivity(intent);
    }

    private void changeQuantity(TextView quantityTextView, int delta) {
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity += delta;
        if (quantity < 1) quantity = 1;
        quantityTextView.setText(String.valueOf(quantity));
    }

    private void removeItem(CardView itemCard) {
        cartItemsContainer.removeView(itemCard);
    }
}