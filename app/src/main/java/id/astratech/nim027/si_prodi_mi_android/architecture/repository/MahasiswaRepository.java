package id.astratech.nim027.si_prodi_mi_android.architecture.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import id.astratech.nim027.si_prodi_mi_android.api.ApiUtils;
import id.astratech.nim027.si_prodi_mi_android.architecture.dao.MahasiswaDao;
import id.astratech.nim027.si_prodi_mi_android.helper.NetworkStateLiveData;
import id.astratech.nim027.si_prodi_mi_android.model.Mahasiswa;
import id.astratech.nim027.si_prodi_mi_android.model.response.LoginResponse;
import id.astratech.nim027.si_prodi_mi_android.service.MahasiswaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaRepository {
    private static final String TAG = "MahasiswaRepository";

    private static MahasiswaRepository INSTANCE;
    private MahasiswaService mMahasiswaService;
    private static MahasiswaDao sMahasiswaDao;
    private NetworkStateLiveData networkStateLiveData;
    private Context context;

    private MahasiswaRepository(Context context) {
        mMahasiswaService = ApiUtils.getMahasiswaService();

        this.context = context;
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            sMahasiswaDao = new MahasiswaDao();
            INSTANCE = new MahasiswaRepository(context);
        }
    }

    public static MahasiswaRepository get() {
        return INSTANCE;
    }

    public LiveData<LoginResponse> doLogin(String nim){
        MutableLiveData<LoginResponse> loginResponseMutableLiveData = new MutableLiveData<>();

        Call<LoginResponse> call = mMahasiswaService.login(nim);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                Log.d(TAG, "onResponse: " + response.body());
                loginResponseMutableLiveData.setValue(loginResponse);
                if (loginResponse.getMahasiswa() != null){
                    Log.d(TAG, "onResponse: " + loginResponse.getMahasiswa().getNama());
                    sMahasiswaDao.setMahasiswaLogin(loginResponse.getMahasiswa());
                }else{
                    sMahasiswaDao.setMahasiswaLogin(loginResponse.getMahasiswa());
                    Log.d(TAG, "onResponse: " + loginResponse.getMahasiswa());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResponseMutableLiveData.setValue(null);
                Log.e(TAG, "Login Gagal : " + t.getMessage()  );
                networkStateLiveData.onPostValue(false);
            }
        });
        return loginResponseMutableLiveData;
    }

/*    public LiveData<LoginResponse> doLogin(String nim) {
        MutableLiveData<Mahasiswa> mahasiswaMutableLiveData = new MutableLiveData<>();

        Call<Mahasiswa> call = mMahasiswaService.login(nim);
        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                Mahasiswa mahasiswa = response.body();
                Log.d(TAG, "onResponse: " + mahasiswa);
                mahasiswaMutableLiveData.setValue(mahasiswa);
                sMahasiswaDao.setMahasiswaLogin(mahasiswa);
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return mahasiswaMutableLiveData;
    }*/

    /*public LiveData<Mahasiswa> getMahasiswaLogin() { return sMahasiswaDao.getMahasiswaLogin(); }*/
}
