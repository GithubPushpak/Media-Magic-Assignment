package com.example.pushpak.mediamagicassignment.interactors;

import android.view.View;

import com.example.pushpak.mediamagicassignment.R;
import com.example.pushpak.mediamagicassignment.view.ListFragment;
import com.example.pushpak.mediamagicassignment.view.MainActivity;

/**
 * Created by Pushpak on 3/26/2022.
 */

public class OnClickHandlers {


   void onSubmitClick(View view){
      MainActivity activity = (MainActivity) view.getContext();
      activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, ListFragment.newInstance()).commit();
   }


}
