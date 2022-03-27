package com.example.pushpak.mediamagicassignment.network;

import com.example.pushpak.mediamagicassignment.model.ListItem;
import com.example.pushpak.mediamagicassignment.model.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pushpak on 3/27/2022.
 */

public class DataRepository<T> {

    private CallbackHandler<T> callbackHandler;

    public DataRepository(CallbackHandler<T> callbackHandler){
        this.callbackHandler = callbackHandler;
    }


    public void getData(String url){
        RetrofitClient.getInstance().getRetrofit().create(APIInterface.class).getTuners(url).enqueue(new Callback<ListItem>() {
            @Override
            public void onResponse(Call<ListItem> call, Response<ListItem> response) {
                callbackHandler.handleResult((T) response);
            }

            @Override
            public void onFailure(Call<ListItem> call, Throwable t) {
                callbackHandler.handleError(t);
            }
        });
    }

  public   interface CallbackHandler<T> {
        void handleResult(T data);
        void handleError(Throwable error);
    }
}
