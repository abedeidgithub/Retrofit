package com.example.abedeid.button;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.text);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://developerhendy.16mb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_interface api_interface = retrofit.create(Api_interface.class);
        Call<ResultModel> contents = api_interface.getContents();
        contents.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                List<Content> contentses = response.body().getContents();
                for (int i = 0; i < contentses.size(); i++) {
                    String postContent = contentses.get(i).getPostContent();
                    text.append(postContent);
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                text.append("  Failed");
            }
        });


    }
}
