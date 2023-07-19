package id.astratech.nim027.si_prodi_mi_android.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit sRetrofit = null;

    public static Retrofit getClient(String url) {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sRetrofit;
    }
}
