package com.example.pushpak.mediamagicassignment.view;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pushpak.mediamagicassignment.R;
import com.example.pushpak.mediamagicassignment.viewmodel.VTunerViewModel;
import com.example.pushpak.mediamagicassignment.viewmodel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private VTunerViewModel vTunerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vTunerViewModel = ViewModelProviders.of(this).get(VTunerViewModel.class);

        URLFragment urlFragment = URLFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.containerMain, urlFragment).addToBackStack(null).commit();
    }

    public VTunerViewModel getViewMModel(){
        return vTunerViewModel;
    }
}
