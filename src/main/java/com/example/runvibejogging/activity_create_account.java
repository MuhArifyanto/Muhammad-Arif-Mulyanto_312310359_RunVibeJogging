package com.example.runvibejogging;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

class create_account extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private Button btnSignIn;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResources().getIdentifier("create_account", "layout", getPackageName())); // Gunakan ID layout secara manual

        // Gunakan ID secara manual, tanpa menggunakan R
        etName = findViewById(getResources().getIdentifier("etName", "id", getPackageName()));
        etEmail = findViewById(getResources().getIdentifier("etEmail", "id", getPackageName()));
        etPassword = findViewById(getResources().getIdentifier("etPassword", "id", getPackageName()));
        btnSignIn = findViewById(getResources().getIdentifier("btnSignIn", "id", getPackageName()));
        btnBack = findViewById(getResources().getIdentifier("btnBack", "id", getPackageName()));

        // Event handler untuk tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengakhiri aktivitas saat tombol kembali ditekan
                finish();
            }
        });

        // Event handler untuk tombol sign in
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil nilai dari input
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validasi input
                if (TextUtils.isEmpty(name)) {
                    etName.setError("Name is required");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Password is required");
                    return;
                }

                // Menampilkan pesan Toast jika input valid
                Toast.makeText(create_account.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();

                // Di sini Anda dapat menambahkan logika lebih lanjut, seperti mengirim data ke server atau menyimpan ke database.
            }
        });
    }
}
