package id.astratech.nim027.si_prodi_mi_android.service;

import java.util.List;

import id.astratech.nim027.si_prodi_mi_android.model.Informasi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InformasiService {
//    @GET("")
//    Call getInformasiById(@Query("id") Integer id);

    @GET("getInformasisAktif")
    Call<List<Informasi>> getInformasis();
}
