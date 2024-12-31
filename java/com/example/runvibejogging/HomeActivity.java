package com.example.runvibejogging;  // Replace with your package name

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    private ImageView ivMenu, ivProfile;
    private EditText etSearch;
    private RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);  // Make sure XML file name matches

        // Initialize views
        ivMenu = findViewById(R.id.ivMenu);
        etSearch = findViewById(R.id.etSearch);
        rvProducts = findViewById(R.id.rvProducts);

        // Set up RecyclerView with a LinearLayoutManager
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        // Set up your adapter here (assuming a ProductAdapter is defined)
        // ProductAdapter adapter = new ProductAdapter(getProductList());
        // rvProducts.setAdapter(adapter);

        // Menu button click listener (you can implement your logic here)
        ivMenu.setOnClickListener(v -> {
            // Handle menu button click (e.g., open a navigation drawer or options)
        });

        // Profile button click listener (you can implement your logic here)
        ivProfile.setOnClickListener(v -> {
            // Handle profile button click (e.g., open profile activity)
        });

        // Search bar functionality (filter products based on search input)
        etSearch.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Optional: Handle text before it's changed
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Implement search functionality (e.g., filter products)
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) {
                // Optional: Handle text after it's changed
            }
        });
    }
}
