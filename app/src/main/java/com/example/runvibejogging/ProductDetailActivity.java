package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {
    private ImageButton backButton, favoriteButton;
    private ImageView productImage;
    private TextView productTitle, productPrice, productDescription;
    private TextView size38, size39, size40, size41, size42, size43, size44;
    private Button addToCartButton;
    private int selectedSize = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_barang);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        backButton = findViewById(R.id.back_button);
        favoriteButton = findViewById(R.id.favorite_button);
        productImage = findViewById(R.id.product_image);
        productTitle = findViewById(R.id.product_title);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);

        size38 = findViewById(R.id.size_38);
        size39 = findViewById(R.id.size_39);
        size40 = findViewById(R.id.size_40);
        size41 = findViewById(R.id.size_41);
        size42 = findViewById(R.id.size_42);
        size43 = findViewById(R.id.size_43);
        size44 = findViewById(R.id.size_44);

        addToCartButton = findViewById(R.id.add_to_cart_button);
    }

    private void setupClickListeners() {
        backButton.setOnClickListener(v -> onBackPressed());

        favoriteButton.setOnClickListener(v ->
                Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        );

        setupSizeClickListeners();

        addToCartButton.setOnClickListener(v -> {
            if (selectedSize != -1) {
                navigateToCart();
            } else {
                Toast.makeText(this, "Please select a size", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupSizeClickListeners() {
        size38.setOnClickListener(v -> selectSize(38));
        size39.setOnClickListener(v -> selectSize(39));
        size40.setOnClickListener(v -> selectSize(40));
        size41.setOnClickListener(v -> selectSize(41));
        size42.setOnClickListener(v -> selectSize(42));
        size43.setOnClickListener(v -> selectSize(43));
        size44.setOnClickListener(v -> selectSize(44));
    }

    private void selectSize(int size) {
        selectedSize = size;
        Toast.makeText(this, "Size " + size + " selected", Toast.LENGTH_SHORT).show();
    }

    private void navigateToCart() {
        Intent intent = new Intent(this, CartActivity.class);
        intent.putExtra("PRODUCT_NAME", productTitle.getText().toString());
        intent.putExtra("PRODUCT_PRICE", productPrice.getText().toString());
        intent.putExtra("PRODUCT_SIZE", selectedSize);
        startActivity(intent);
    }
}