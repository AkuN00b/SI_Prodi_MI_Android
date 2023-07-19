package id.astratech.nim027.si_prodi_mi_android.viewModel;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.astratech.nim027.si_prodi_mi_android.model.Informasi;
import id.astratech.nim027.si_prodi_mi_android.repository.InformasiRepository;

public class InformasiListViewModel extends ViewModel {
    private static final String TAG = "InformasiListViewModel";
    private MutableLiveData<List<Informasi>> mInformasiListMutableLiveData;
    private InformasiRepository mInformasiRepository;

    public InformasiListViewModel(){
        Log.d(TAG, "InformasiListViewModel constructor called");
        mInformasiRepository = InformasiRepository.get();
    }

    public MutableLiveData<List<Informasi>> getInformasis(){
        return mInformasiRepository.getInformasis();
    }
}
