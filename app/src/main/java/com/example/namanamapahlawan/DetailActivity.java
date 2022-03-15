package com.example.namanamapahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView txtname,txtbirth_year,txtdeath_year,txtdescription,txtascension_year;
    biodatapahlawan pahlawannya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtname=(TextView) findViewById(R.id.detailnama);
        txtbirth_year=(TextView) findViewById(R.id.text_detailbt);
        txtdeath_year=(TextView) findViewById(R.id.text_detaildy);
        txtdescription=(TextView) findViewById(R.id.text_detaildescription);
        txtascension_year=(TextView) findViewById(R.id.text_detailay);
        Intent dapet=getIntent();
          pahlawannya=(biodatapahlawan) dapet.getSerializableExtra("orang");
          txtname.setText(pahlawannya.getName());
          txtbirth_year.setText(pahlawannya.getBirth_year());
          txtdeath_year.setText(pahlawannya.getDeath_year());
          txtdescription.setText(pahlawannya.getDescription());
          txtascension_year.setText(pahlawannya.getAscension_year());

    }
}