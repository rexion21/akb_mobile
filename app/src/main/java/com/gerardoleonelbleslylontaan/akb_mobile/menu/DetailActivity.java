package com.gerardoleonelbleslylontaan.akb_mobile.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gerardoleonelbleslylontaan.akb_mobile.R;
import com.gerardoleonelbleslylontaan.akb_mobile.entity.Menu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Menu menu = (Menu)getIntent().getSerializableExtra("Menu");

        TextView namaMenu, deskripsi, harga;
        ImageView urlPhoto;
        FloatingActionButton btnBack;

        namaMenu = findViewById(R.id.tvNamaMenu);
        deskripsi = findViewById(R.id.tvDeskripsi);
        harga = findViewById(R.id.tvHarga);
        urlPhoto = findViewById(R.id.urlPhoto);
        btnBack = findViewById(R.id.btnBack);

        namaMenu.setText(menu.getNama_menu());
        deskripsi.setText(menu.getDeskripsi());
        harga.setText(convertToCurrency(menu.getHarga()));
        Glide.with(this).load("https://akbp3l.gerardoleonel.com/public/urlPhoto/"+ menu.getUrlPhoto()).into(urlPhoto);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public String convertToCurrency(String value) {
        Integer val = Integer.valueOf(value);
        DecimalFormat formatter = new DecimalFormat("###,###,##0");
        return "Rp " + formatter.format(val);
    }
}