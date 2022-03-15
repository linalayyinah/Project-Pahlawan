package com.example.namanamapahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splashscreen extends AppCompatActivity {
    ApiInterface apiInterface;
    List<biodatapahlawan> biodatapahlawanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Dapetdata().execute();
    }

    private class Dapetdata extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() { super. onPreExecute(); }
        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface = ApiClient.ambilData().create(ApiInterface.class);
            Call<List<biodatapahlawan>> listCall = apiInterface.getListdaftanama();
            listCall.enqueue(new Callback<List<biodatapahlawan>>() {
                @Override
                public void onResponse(Call<List<biodatapahlawan>> call, Response<List<biodatapahlawan>> response) {
                    biodatapahlawanList = response.body();
                    Intent kirimdata = new Intent(Splashscreen.this, MainActivity.class);
                    kirimdata.putExtra("datanya", (Serializable) biodatapahlawanList);
                    startActivity(kirimdata);
                    finish();
                }

                @Override
                public void onFailure(Call<List<biodatapahlawan>> call, Throwable t) {
                    Toast.makeText(Splashscreen.this,"data gagal didapat",Toast.LENGTH_LONG).show();

                }
            });
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);

        }
    }
}



