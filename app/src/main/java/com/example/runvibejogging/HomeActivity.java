package com.example.runvibejogging;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private ImageView ivMenu;
    private ImageView ivProfile;
    private SearchView svSearch;
    private RecyclerView rvProducts;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.home);
            initializeViews();
            setupClickListeners();
            setupRecyclerView();
            loadProducts();
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void initializeViews() {
        ivMenu = findViewById(R.id.ivMenu);
        ivProfile = findViewById(R.id.ivProfile);
        svSearch = findViewById(R.id.svSearch); // Update ID sesuai dengan layout
        rvProducts = findViewById(R.id.rvProducts);
    }

    private void setupClickListeners() {
        if (ivMenu != null) {
            ivMenu.setOnClickListener(view -> {
                Log.d(TAG, "Menu icon clicked");
                // Add menu functionality here
            });
        }

        if (ivProfile != null) {
            ivProfile.setOnClickListener(view -> {
                Log.d(TAG, "Profile icon clicked");
                // Add profile functionality here
            });
        }

        if (svSearch != null) {
            svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.d(TAG, "Search query submitted: " + query);
                    // Tambahkan logika pencarian di sini
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.d(TAG, "Search query changed: " + newText);
                    // Tambahkan logika filter pencarian di sini
                    return false;
                }
            });
        }
    }

    private void setupRecyclerView() {
        if (rvProducts != null) {
            productList = new ArrayList<>();
            rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
            productAdapter = new ProductAdapter(this, productList, product -> {
                // Ketika produk diklik, navigasi ke ProductDetailActivity
                Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
                // Tambahkan data produk ke intent jika diperlukan
                intent.putExtra("PRODUCT_NAME", product.getName());
                intent.putExtra("PRODUCT_PRICE", product.getPrice());
                intent.putExtra("PRODUCT_IMAGE", product.getImageResource());
                startActivity(intent);
            });
            rvProducts.setAdapter(productAdapter);
        }
    }

    private void loadProducts() {
        // Menambahkan produk sample
        productList.add(new Product("Adidas Duramo SL", "Rp540.000", R.drawable.didas1));
        productList.add(new Product("Nike Air Max", "Rp500.000", R.drawable.hijau));
        productList.add(new Product("Puma X", "Rp100.000", R.drawable.mipa));
        productList.add(new Product("Nike Zoom", "Rp100.000", R.drawable.hitam));

        // Memberitahu adapter bahwa data telah berubah
        productAdapter.notifyDataSetChanged();
    }
}
