package id.astratech.nim027.si_prodi_mi_android.api;

import id.astratech.nim027.si_prodi_mi_android.service.InformasiService;
import id.astratech.nim027.si_prodi_mi_android.service.MahasiswaService;

public class ApiUtils {
    public static final String API_URL = "http://10.8.2.29:8080/";

    private ApiUtils() {

    }

    public static MahasiswaService getMahasiswaService() {
        return RetrofitClient.getClient(API_URL).create(MahasiswaService.class);
    }

    public static InformasiService getInformasiService() {
        return RetrofitClient.getClient(API_URL).create(InformasiService.class);
    }
}


