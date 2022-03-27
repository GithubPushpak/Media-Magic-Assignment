package com.example.pushpak.mediamagicassignment.network;

import com.example.pushpak.mediamagicassignment.model.ListItem;

import retrofit2.Call;
import retrofit2.http.Url;

/**
 * Created by Pushpak on 3/27/2022.
 */

public interface APIInterface {


    public Call<ListItem> getTuners(@Url String url);

}
