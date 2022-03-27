package com.example.pushpak.mediamagicassignment.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by Pushpak on 3/27/2022.
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return super.create(modelClass);
    }
}
