package id.astratech.nim027.si_prodi_mi_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    private CardView mAbsensiMuka;
    private CardView mInformasi;
    private CardView mKalenderAcara;
    private CardView mPengaturan;
    private ImageView mLogout;

    private long backPressedTime; // Variabel untuk menyimpan waktu terakhir tombol back ditekan
    private static final int TIME_INTERVAL = 2000; // Waktu interval dalam milidetik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAbsensiMuka = findViewById(R.id.cvAbsensiMuka);
        mAbsensiMuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, AbsensiMukaActivity.class);
                startActivity(intent);
            }
        });

        mInformasi = findViewById(R.id.cvInformasi);
        mInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, InformasiActivity.class);
                startActivity(intent);
            }
        });

        mKalenderAcara = findViewById(R.id.cvKalender);
        mKalenderAcara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, KalenderAcaraActivity.class);
                startActivity(intent);
            }
        });

//        mPengaturan = findViewById(R.id.cvPengaturan);
//        mPengaturan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DashboardActivity.this, PengaturanActivity.class);
//                startActivity(intent);
//            }
//        });

        mLogout = findViewById(R.id.btnLogout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, activity_home.class);
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