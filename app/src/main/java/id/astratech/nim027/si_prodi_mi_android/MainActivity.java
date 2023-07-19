package id.astratech.nim027.si_prodi_mi_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import id.astratech.nim027.si_prodi_mi_android.repository.InformasiRepository;

public class MainActivity extends AppCompatActivity {
    private int loading_time = 1000;
    private  static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InformasiRepository.initialize(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(MainActivity.this, activity_home.class);
                startActivity(home);
                finish();
            }
        }, loading_time);
    }
}