package com.example.abedeid.button;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abed Eid on 13/07/2016.
 */
interface Api_interface {
    @GET("getposts.php")
    Call<ResultModel>getContents();
}
