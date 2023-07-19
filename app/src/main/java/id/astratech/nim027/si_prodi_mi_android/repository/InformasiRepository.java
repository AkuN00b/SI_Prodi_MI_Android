package id.astratech.nim027.si_prodi_mi_android.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import id.astratech.nim027.si_prodi_mi_android.api.ApiUtils;
import id.astratech.nim027.si_prodi_mi_android.model.Informasi;
import id.astratech.nim027.si_prodi_mi_android.service.InformasiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformasiRepository {
    private static final String TAG = "InformasiRepository";
    public static InformasiRepository INSTANCE;
    private InformasiService mInformasiService;

    //hubungan dgn API utils utk dapetin fungsi

    private InformasiRepository(Context context) {
        mInformasiService = ApiUtils.getInformasiService();
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InformasiRepository(context);
        }
    }

    public static InformasiRepository get() {
        return INSTANCE;
    }

    public MutableLiveData<List<Informasi>> getInformasis() {
        MutableLiveData<List<Informasi>> informasis = new MutableLiveData<>();

        Call<List<Informasi>> call = mInformasiService.getInformasis();
        call.enqueue(new Callback<List<Informasi>>() {
            @Override
            public void onResponse(Call<List<Informasi>> call, Response<List<Informasi>> response) {
                if (response.isSuccessful()){
                    informasis.setValue(response.body());
                    Log.d(TAG, "getInformasis.onResponse() called");
                }
            }

            @Override
            public void onFailure(Call<List<Informasi>> call, Throwable t) {
                Log.e("Error API call ", t.getMessage());
            }
        });

        return informasis;
    }
}
