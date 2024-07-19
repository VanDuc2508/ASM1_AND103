package com.example.asm1_and103;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
     String DOMAIN = "http://192.168.1.3:3000";

     @GET("/mobiles")
     Call<List<MobileModel>> getMobiles();
}
