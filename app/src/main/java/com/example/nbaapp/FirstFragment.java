package com.example.nbaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.nbaapp.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MiAdapter adapter;
    ArrayList<NBA>nbas;
    ArrayList<NBA>info;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
    info=new ArrayList<NBA>();
    NBAApi api = new NBAApi();
    adapter=new MiAdapter(
      getContext(),
      R.layout.lv_nba_raw,
      R.id.txtequipo,
      info
    );
    binding.lvNBA.setAdapter(adapter);

    binding.lvNBA.setOnItemClickListener(((adapterView, view1, i, l) -> {

        NBA nba = (NBA) adapterView.getItemAtPosition(i);
        NBA info =(NBA)adapterView.getItemAtPosition(i);
        Bundle datos = new Bundle();
        datos.putSerializable("info",info);

        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment,datos);

    } ));
    NBAViewModel viewModel = new ViewModelProvider(getActivity()).get(NBAViewModel.class);
    viewModel.refresh();
    viewModel.getNbas().observe(getActivity(),nbas ->{
        adapter.clear();
        adapter.addAll(nbas);
    } );

    super.onViewCreated(view,savedInstanceState);
    }


    void refresh() {

        Toast.makeText(getContext(),"Refrescando",Toast.LENGTH_LONG).show();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tipo = preferences.getString("tipo","");
        if(!tipo.equals("")){

        }
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            NBAApi api = new NBAApi();

            nbas=api.GetNBA();
            handler.post(()->{
                adapter.clear();
                adapter.addAll(nbas);

            });
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void onStart() {
        super.onStart();
        refresh();
    }
}