package id.astratech.nim027.si_prodi_mi_android.service;

import id.astratech.nim027.si_prodi_mi_android.model.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MahasiswaService {
    @FormUrlEncoded
    @POST("LoginMahasiswaAPI")
    Call<LoginResponse> login(@Field("nim") String nim);
}
