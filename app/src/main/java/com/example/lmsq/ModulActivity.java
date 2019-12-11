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

public class ModulActivity extends AppCompatActivity {
Button btnKembali;
MatakuliahModel mk;
RecyclerView rv1;
    List<MatakuliahModel> matakuliahlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul);
        btnKembali = findViewById(R.id.btnback1);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rv1 = findViewById(R.id.rv1matakuliah);
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
        mk = new MatakuliahModel("Bahasa Inggris");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru
        mk = new MatakuliahModel("Manajemen Proyek");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru
        mk = new MatakuliahModel("Kewirausahaan");
        //menambahkan hero ke listSuperHero
        matakuliahlist.add(mk);
        //membuat object hero baru

        AdapterMatakuliah adaptermk  = new AdapterMatakuliah(matakuliahlist);
        //set adapter dan layoutmanager
        rv1.setAdapter(adaptermk);
        rv1.setLayoutManager(new LinearLayoutManager(this));
    }
}
