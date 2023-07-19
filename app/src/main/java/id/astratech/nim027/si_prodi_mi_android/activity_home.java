package id.astratech.nim027.si_prodi_mi_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import id.astratech.nim027.si_prodi_mi_android.architecture.viewmodel.MahasiswaViewModel;
import id.astratech.nim027.si_prodi_mi_android.helper.NetworkStateLiveData;
import id.astratech.nim027.si_prodi_mi_android.helper.ValidationHelper;
import id.astratech.nim027.si_prodi_mi_android.model.Mahasiswa;
import id.astratech.nim027.si_prodi_mi_android.model.response.LoginResponse;
import id.astratech.nim027.si_prodi_mi_android.model.response.MahasiswaResponse;

public class activity_home extends AppCompatActivity {

    SharedPreferences pref;
    private NetworkStateLiveData networkStateLiveData;
    private Button mButtonLogin;
    EditText mTxtNim;
    TextInputLayout mTxtNIMLayout;
    private MahasiswaViewModel mMahasiswaViewModel;
    private Mahasiswa mMahasiswa;
    private long backPressedTime; // Variabel untuk menyimpan waktu terakhir tombol back ditekan
    private static final int TIME_INTERVAL = 2000; // Waktu interval dalam milidetik

    public activity_home(){

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        networkStateLiveData = new NetworkStateLiveData(this);
        networkStateLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isConnected) {
                if (isConnected) {
                    // Koneksi terhubung
                } else {
                    // Tidak ada koneksi
                    Toast.makeText(activity_home.this, "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getWindow().setEnterTransition(new Fade());
        mMahasiswaViewModel = new ViewModelProvider(this).get(MahasiswaViewModel.class);
        pref = getSharedPreferences("user_pref", MODE_PRIVATE);
        mTxtNim = findViewById(R.id.etNIM);
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonLogin.setOnClickListener(v -> {
            if(TextUtils.isEmpty(mTxtNim.getText().toString())){
                Toast.makeText(this,"Please enter NIM",Toast.LENGTH_LONG).show();
                return;
            }
            String mhs_nim = mTxtNim.getText().toString();

            if(!isConnected()){
                Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                return;
            }
            if(validate(v)) {
                ProgressDialog progressDialog = ProgressDialog.show(this, "Sign In", "Signing in...");
                mMahasiswaViewModel.loginMahasiswa(mhs_nim).observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        if (loginResponse != null) {
                            if (loginResponse.getStatus() == 200) {
                                mMahasiswa = loginResponse.getMahasiswa();
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("nim", loginResponse.getMahasiswa().getNim());
                                //editor.putString("kry_nama", loginResponse.getmKaryawan().getNama());
                                editor.putString("nama", mMahasiswa.getNama());
                                editor.putString("email",mMahasiswa.getEmail());
                                editor.putString("kelas",mMahasiswa.getKelas());
                                editor.apply();

                                Toast.makeText(activity_home.this, "Login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(activity_home.this, DashboardActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(activity_home.this, "NIM tidak terdaftar", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(activity_home.this, "NIM tidak ditemukan", Toast.LENGTH_SHORT).show();
                        }

                        progressDialog.dismiss();
                    }
                });
            }
        });
    }

    public boolean validate(View v) {
//        boolean nimValidation = ValidationHelper.requiredTextInputValidation(mTxtNIMLayout);
        //boolean passwordValidation = ValidationHelper.requiredTextInputValidation(mPasswordLayout);

        return true;
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
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