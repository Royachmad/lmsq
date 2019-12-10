package com.example.lmsq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lmsq.Adapter.AdapterMatakuliah;
import com.example.lmsq.Model.MatakuliahModel;

import java.util.ArrayList;
import java.util.List;

public class TugasActivity extends AppCompatActivity {
Button btnKembali;
    MatakuliahModel mk;
    RecyclerView rv;
    List<MatakuliahModel> matakuliahlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);


        btnKembali = findViewById(R.id.btnback1);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        rv = findViewById(R.id.rvmatakuliah);
        mk = new MatakuliahModel("Pemrograman android");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru
        mk = new MatakuliahModel("Sistem pendukung keputusan");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru
        mk = new MatakuliahModel("Pengolahan Citra");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru

        AdapterMatakuliah adaptermk  = new AdapterMatakuliah(matakuliahlist);
        //set adapter dan layoutmanager
        rv.setAdapter(adaptermk);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
