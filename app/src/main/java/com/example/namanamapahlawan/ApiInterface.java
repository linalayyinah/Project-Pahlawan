package com.example.namanamapahlawan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
   @GET("heroes")
   Call<List<biodatapahlawan>> getListdaftanama();
}
