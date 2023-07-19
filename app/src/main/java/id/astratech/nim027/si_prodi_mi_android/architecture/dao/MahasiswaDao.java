package id.astratech.nim027.si_prodi_mi_android.architecture.dao;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import id.astratech.nim027.si_prodi_mi_android.model.Mahasiswa;

public class MahasiswaDao {
    private static final String TAG = "MahasiswaDao";

    private MutableLiveData<Mahasiswa> mMahasiswaMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Mahasiswa> getMahasiswaLogin() { return mMahasiswaMutableLiveData; }

    public void setMahasiswaLogin(Mahasiswa mahasiswaLogin) {
        mMahasiswaMutableLiveData.setValue(mahasiswaLogin);
        Log.d(TAG, "setUserLogin: " + mMahasiswaMutableLiveData.getValue());
    }
}
