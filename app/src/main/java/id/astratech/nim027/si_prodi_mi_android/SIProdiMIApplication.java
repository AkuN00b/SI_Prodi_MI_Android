package id.astratech.nim027.si_prodi_mi_android;

import android.app.Application;
import android.util.Log;

import id.astratech.nim027.si_prodi_mi_android.architecture.repository.MahasiswaRepository;
import id.astratech.nim027.si_prodi_mi_android.repository.InformasiRepository;

public class SIProdiMIApplication extends Application {
    private static final String TAG = "SIProdiMIApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "SIProdiMIApplication.onCreate() called");
        InformasiRepository.initialize(this);
        MahasiswaRepository.initialize(this);
    }
}
