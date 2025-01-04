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

    private Button btnCheckout, btnBuyNow;  // Add Buy Now button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keranjang); // Replace with your layout file

        // Initialize views
        btnBack = findViewById(R.id.btnBack);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);

        cartItemsContainer = findViewById(R.id.cartItemsContainer);

        firstItemCard = findViewById(R.id.firstItemCard);
        secondItemCard = findViewById(R.id.secondItemCard);

        firstItemImage = findViewById(R.id.firstItemImage);
        secondItemImage = findViewById(R.id.secondItemImage);

        firstItemName = findViewById(R.id.firstItemName);
        firstItemPrice = findViewById(R.id.firstItemPrice);
        firstItemSize = findViewById(R.id.firstItemSize);
        tvFirstItemQuantity = findViewById(R.id.tvFirstItemQuantity);

        secondItemName = findViewById(R.id.secondItemName);
        secondItemPrice = findViewById(R.id.secondItemPrice);
        secondItemSize = findViewById(R.id.secondItemSize);
        tvSecondItemQuantity = findViewById(R.id.tvSecondItemQuantity);

        btnCheckout = findViewById(R.id.btnCheckout);
        btnBuyNow = findViewById(R.id.btnCheckout); // Initialize Buy Now button

        // Set listeners for buttons
        btnBack.setOnClickListener(v -> onBackPressed());

        btnDecreaseFirstItem.setOnClickListener(v -> changeQuantity(tvFirstItemQuantity, -1));
        btnIncreaseFirstItem.setOnClickListener(v -> changeQuantity(tvFirstItemQuantity, 1));
        btnDeleteFirstItem.setOnClickListener(v -> removeItem(firstItemCard));

        btnDecreaseSecondItem.setOnClickListener(v -> changeQuantity(tvSecondItemQuantity, -1));
        btnIncreaseSecondItem.setOnClickListener(v -> changeQuantity(tvSecondItemQuantity, 1));
        btnDeleteSecondItem.setOnClickListener(v -> removeItem(secondItemCard));

        btnCheckout.setOnClickListener(v -> checkout());

        // Handle Buy Now button click
        btnBuyNow.setOnClickListener(v -> {
            if (firstItemCard.getVisibility() == View.VISIBLE) {
                navigateToPaymentSuccess(firstItemName.getText().toString(), firstItemPrice.getText().toString(), Integer.parseInt(tvFirstItemQuantity.getText().toString()));
            } else if (secondItemCard.getVisibility() == View.VISIBLE) {
                navigateToPaymentSuccess(secondItemName.getText().toString(), secondItemPrice.getText().toString(), Integer.parseInt(tvSecondItemQuantity.getText().toString()));
            } else {
                // Handle case when cart is empty
                // You could show a message to the user
            }
        });
    }

    // Navigate to PaymentSuccessActivity
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
        if (quantity < 1) {
            quantity = 1;
        }
        quantityTextView.setText(String.valueOf(quantity));
    }

    private void removeItem(CardView itemCard) {
        cartItemsContainer.removeView(itemCard);
    }

    private void checkout() {
        // Implement checkout logic here, for now, you could navigate to a checkout summary or show a message
        // Toast.makeText(this, "Proceeding to checkout", Toast.LENGTH_SHORT).show();
    }
}
