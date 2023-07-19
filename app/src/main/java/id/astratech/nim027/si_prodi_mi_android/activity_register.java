package id.astratech.nim027.si_prodi_mi_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_register extends AppCompatActivity {
    private Button mButtonRegister;
    private TextView mLoginLink;

    private long backPressedTime; // Variabel untuk menyimpan waktu terakhir tombol back ditekan
    private static final int TIME_INTERVAL = 2000; // Waktu interval dalam milidetik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mButtonRegister = findViewById(R.id.buttonRegister);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, activity_home.class);
                startActivity(intent);
                finish();
            }
        });

        mLoginLink = findViewById(R.id.tvLoginLink);
        mLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, activity_home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Cek jika tombol back ditekan dalam waktu interval yang ditentukan
        if (backPressedTime + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            finish(); // Keluar dari aplikasi
        } else {
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis(); // Menyimpan waktu terakhir tombol back ditekan
    }
}