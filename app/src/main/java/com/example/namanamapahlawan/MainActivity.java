package com.example.namanamapahlawan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    List<biodatapahlawan> biodatapahlawanList;
    ApiInterface apiInterface;
    DaftarPahlawanAdapter adapter;
    RecyclerView rvbiodatapahlawan;
    TextView txtBiodata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvbiodatapahlawan=(RecyclerView) findViewById(R.id.rv_biodatapahlawan);
        txtBiodata=(TextView) findViewById(R.id.biodata_pahlawan);
        layoutManager=new LinearLayoutManager(this);
        rvbiodatapahlawan.setLayoutManager(layoutManager);
        apiInterface = ApiClient.ambilData().create(ApiInterface.class);
        Call<List<biodatapahlawan>> listCall=apiInterface.getListdaftanama();
        listCall.enqueue(new Callback<List<biodatapahlawan>>() {
            @Override
            public void onResponse(Call<List<biodatapahlawan>> call, Response<List<biodatapahlawan>> response) {
                biodatapahlawanList=response.body();

                adapter=new DaftarPahlawanAdapter(MainActivity.this,biodatapahlawanList);
                rvbiodatapahlawan.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<biodatapahlawan>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "tidak dapat data", Toast.LENGTH_LONG).show();
            }
        });
    }
}