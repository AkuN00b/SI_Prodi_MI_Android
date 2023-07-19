package id.astratech.nim027.si_prodi_mi_android.architecture.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.astratech.nim027.si_prodi_mi_android.architecture.repository.MahasiswaRepository;
import id.astratech.nim027.si_prodi_mi_android.model.Mahasiswa;
import id.astratech.nim027.si_prodi_mi_android.model.response.LoginResponse;

public class MahasiswaViewModel extends ViewModel {
    private static final String TAG = "MahasiswaViewModel";
    private MahasiswaRepository mMahasiswaRepository;

    public MahasiswaViewModel() {
        Log.d(TAG, "MahasiswaViewModel constructor called");
        mMahasiswaRepository = MahasiswaRepository.get();
    }

    public LiveData<LoginResponse> loginMahasiswa(String nim) {
        return mMahasiswaRepository.doLogin(nim);
    }
}
