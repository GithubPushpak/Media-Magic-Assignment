package com.example.pushpak.mediamagicassignment.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import com.example.pushpak.mediamagicassignment.model.ModelClass;
import com.example.pushpak.mediamagicassignment.network.DataRepository;

/**
 * Created by Pushpak on 3/26/2022.
 */

public class VTunerViewModel extends ViewModel {


    public String url = "";
    private MutableLiveData<List<ModelClass>> _models = new MutableLiveData<>();
    private LiveData<List<ModelClass>> models = _models;


    public LiveData<List<ModelClass>> getTuners(){
        DataRepository<List<ModelClass>> repository = new DataRepository<List<ModelClass>>(new DataRepository.CallbackHandler<List<ModelClass>>() {
            @Override
            public void handleResult(List<ModelClass> data) {
                _models.setValue(data);
            }

            @Override
            public void handleError(Throwable error) {
                _models.setValue(null);
            }
        });
        repository.getData(url);
        return models;
    }



}
