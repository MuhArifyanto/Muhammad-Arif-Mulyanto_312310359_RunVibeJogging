package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    // Declare views
    private ImageView productImage1, productImage2, productImage3, productImage4;
    private TextView productName1, productName2, productName3, productName4;
    private TextView productPrice1, productPrice2, productPrice3, productPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_product); // Replace with your layout filename

        // Initialize Views
        productImage1 = findViewById(R.id.product_image_1);
        productImage2 = findViewById(R.id.product_image_2);
        productImage3 = findViewById(R.id.product_image_3);
        productImage4 = findViewById(R.id.product_image_4);

        // Set sample data for products
        productName1.setText("Product Name 1");
        productPrice1.setText("Rp0.000.000");

        productName2.setText("Product Name 2");
        productPrice2.setText("Rp0.000.000");

        productName3.setText("Product Name 3");
        productPrice3.setText("Rp0.000.000");

        productName4.setText("Product Name 4");
        productPrice4.setText("Rp0.000.000");

        // Set click listeners for product cards
        productImage1.setOnClickListener(v -> {
            // Navigate to ProductDetailActivity when Product 1 image is clicked
            Intent intent = new Intent(ProductActivity.this, ProductDetailActivity.class);
            intent.putExtra("product_name", "Product 1");
            intent.putExtra("product_price", "Rp0.000.000");
            startActivity(intent);
        });
    }
}
