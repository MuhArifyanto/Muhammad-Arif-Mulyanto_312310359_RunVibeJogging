package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    // Define UI elements
    private ImageButton backButton, favoriteButton, shareButton;
    private ImageView productImage;
    private TextView productTitle, productPrice, productDescription, sizeLabel;
    private TextView size38, size39, size40, size41, size42, size43, size44;
    private Button addToCartButton;
    private int selectedSize = -1; // Variable to store the selected size (default is none)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_barang); // Replace with your XML file name

        // Initialize UI elements
        backButton = findViewById(R.id.back_button);
        favoriteButton = findViewById(R.id.favorite_button);
        productImage = findViewById(R.id.product_image);
        productTitle = findViewById(R.id.product_title);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);
        sizeLabel = findViewById(R.id.size_label);
        size38 = findViewById(R.id.size_38);
        size39 = findViewById(R.id.size_39);
        size40 = findViewById(R.id.size_40);
        size41 = findViewById(R.id.size_41);
        size42 = findViewById(R.id.size_42);
        size43 = findViewById(R.id.size_43);
        size44 = findViewById(R.id.size_44);
        addToCartButton = findViewById(R.id.add_to_cart_button);

        // Handle Back Button Click
        backButton.setOnClickListener(v -> onBackPressed());

        // Handle Favorite Button Click
        favoriteButton.setOnClickListener(v -> {
            // Toggle favorite status
            Toast.makeText(ProductDetailActivity.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
        });

        // Handle Share Button Click
        shareButton.setOnClickListener(v -> {
            // Implement share functionality
            Toast.makeText(ProductDetailActivity.this, "Share Product", Toast.LENGTH_SHORT).show();
        });

        // Handle Size Selection
        size38.setOnClickListener(v -> selectSize(38));
        size39.setOnClickListener(v -> selectSize(39));
        size40.setOnClickListener(v -> selectSize(40));
        size41.setOnClickListener(v -> selectSize(41));
        size42.setOnClickListener(v -> selectSize(42));
        size43.setOnClickListener(v -> selectSize(43));
        size44.setOnClickListener(v -> selectSize(44));

        // Handle Add to Cart Button Click
        addToCartButton.setOnClickListener(v -> {
            if (selectedSize != -1) {
                // Pass product details to CartActivity
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                intent.putExtra("PRODUCT_NAME", productTitle.getText().toString());
                intent.putExtra("PRODUCT_PRICE", productPrice.getText().toString());
                intent.putExtra("PRODUCT_SIZE", selectedSize);

                // Navigate to CartActivity
                startActivity(intent);
            } else {
                // If no size selected, show a message
                Toast.makeText(ProductDetailActivity.this, "Please select a size", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Function to handle size selection
    private void selectSize(int size) {
        selectedSize = size; // Store the selected size
        Toast.makeText(ProductDetailActivity.this, "Size " + size + " selected", Toast.LENGTH_SHORT).show();
    }
}
