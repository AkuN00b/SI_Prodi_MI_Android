package id.astratech.nim027.si_prodi_mi_android.list;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;

import id.astratech.nim027.si_prodi_mi_android.R;
import id.astratech.nim027.si_prodi_mi_android.model.Informasi;
import id.astratech.nim027.si_prodi_mi_android.viewModel.InformasiListViewModel;

public class ListInformasiFragment extends Fragment {
    private static final String TAG = "ListInformasiFragment";
    private InformasiListViewModel mInformasiListViewModel;
    private RecyclerView mInformasiRecyclerView;
    private TextView mTextView;
    private InformasiAdapter mAdapter;

    public static ListInformasiFragment newInstance() {
        return new ListInformasiFragment();
    }

    private void updateUI(List<Informasi> informasis) {
        Log.i(TAG, "updateUI called");
        mAdapter = new InformasiAdapter(informasis);
        mInformasiRecyclerView.setAdapter(mAdapter);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "ListInformasiFragment.onCreate() called");
        mInformasiListViewModel = new ViewModelProvider(this)
                .get(InformasiListViewModel.class);
        mAdapter = new InformasiAdapter(Collections.<Informasi>emptyList());
//        Log.d(TAG, "Total User: " + mInformasiListViewModel.getInformasis().getValue().size())
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

        Log.i(TAG, "InformasiListFragment.onViewCreated() called");
        mInformasiListViewModel.getInformasis().observe(
                getViewLifecycleOwner(),
                new Observer<List<Informasi>>() {
                    @Override
                    public void onChanged(List<Informasi> informasis) {
                        updateUI(informasis);
                        Log.i(TAG, "Got Informasis: " + informasis.size());
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informasi_list, container, false);
        Log.i(TAG, "ListInformasiFragment.onCreateView() called");

        mInformasiRecyclerView = (RecyclerView) view.findViewById(R.id.informasi_recycler_view);
        mInformasiRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        updateUI();
        mInformasiRecyclerView.setAdapter(mAdapter);
//        view.setFocusableInTouchMode(true);
//        view.requestFocus();
//        view.setOnKeyListener(new View.OnKeyListener() {
//
//
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//                    // Kembali ke aktivitas utama (dashboard utama)
//                    getActivity().onBackPressed();
//                    return true;
//                }
//                return false;
//            }
//        });
        return view;
    }

    private class InformasiHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mJudulInformasi;
        private Informasi mInformasi;

        public InformasiHolder (LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_informasi, parent, false));
            this.itemView.setOnClickListener(this);

            mJudulInformasi = this.itemView.findViewById(R.id.nama_informasi);
        }

        public void bind(Informasi informasi){
            mInformasi = informasi;
            mJudulInformasi.setText(mInformasi.getJudulInformasi());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                            mInformasi.getJudulInformasi() + " clicked!",
                            Toast.LENGTH_SHORT).show();
        }
    }

    private class InformasiAdapter extends RecyclerView.Adapter<ListInformasiFragment.InformasiHolder>{
        private List<Informasi> mInformasiList;

        public InformasiAdapter(List<Informasi> informasis){
            mInformasiList = informasis;
        }

        @Override
        public InformasiHolder onCreateViewHolder (ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new InformasiHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ListInformasiFragment.InformasiHolder holder, int position){
            Informasi informasi = mInformasiList.get(position);
//
//            Informasi informasi1 = new Informasi();
//
//            informasi1.setIdInformasi(informasi.getIdInformasi());
//
            holder.bind(informasi);
        }

        @Override
        public int getItemCount() {
            return mInformasiList.size();
        }
    }
}
