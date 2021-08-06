package com.example.mvvmpractic5aug.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpractic5aug.model.APIResponse;
import com.example.mvvmpractic5aug.network.ApiInterface;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeRepository {

    public String BASEURL="https://sales.bajajallianzlife.com/";

    private MutableLiveData<APIResponse> mutableLiveData;

    ApiInterface apiInterface;


    public EmployeeRepository() {
        mutableLiveData=new MutableLiveData<>();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build();

        apiInterface=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class);
    }


    public void getAPICall(){

        HashMap hashMap=new HashMap();
        hashMap.put("message","109988");
        hashMap.put("enc_flag","e");

        apiInterface.getAPIResponse(hashMap).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.body()!= null){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<APIResponse> getRepositoryCall(){
        return mutableLiveData;
    }
}
