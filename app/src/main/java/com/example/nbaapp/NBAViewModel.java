package com.example.nbaapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NBAViewModel extends AndroidViewModel {
    private final Application app;
    private MutableLiveData<List<NBA>>nbas;

    public NBAViewModel(@NonNull Application application) {
        super(application);
        this.app = application;
    }

    public MutableLiveData<List<NBA>> getNbas() {

        if(nbas==null){
            nbas=new MutableLiveData<>();
        }
        return nbas;
    }

    public void refresh(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
       // String tipo = preferences.getString("tipo","");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() ->{
            NBAApi api = new NBAApi();
            ArrayList<NBA>nbas=api.GetNBA();
            this.nbas.postValue(nbas);

        });

    }
}
