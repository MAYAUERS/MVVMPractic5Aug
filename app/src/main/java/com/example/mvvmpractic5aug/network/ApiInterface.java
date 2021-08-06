package com.example.mvvmpractic5aug.network;

import com.example.mvvmpractic5aug.model.APIResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


  //  api-key DkSRSDrzEELZrLtaUjvknDFTdESLkUFo
    @Headers("api-key:DkSRSDrzEELZrLtaUjvknDFTdESLkUFo")
    @POST("BalicLmsUtil/encdec")
    Call<APIResponse> getAPIResponse(@Body HashMap<String,String> hashMap);
}
