package com.example.lmsq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView txtemail;
    Button tugas,modul,kalender, overview;
    String email;
    private SharedPreferences sharedPrefs;
    private static final String EMAIL_KEY = "key_email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txtemail = findViewById(R.id.txtemail);

        this.sharedPrefs = this.getSharedPreferences("sp", Context.MODE_PRIVATE);
        email = this.sharedPrefs.getString("key_email",null);
        txtemail.setText(email);

        tugas = findViewById(R.id.btntugas);
        tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,TugasActivity.class);
                startActivity(i);
            }
        });
        modul = findViewById(R.id.btnmodul);
        modul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,ModulActivity.class);
                startActivity(i);
            }
        });
        kalender = findViewById(R.id.btnkalender);
        kalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long startMillis = System.currentTimeMillis();
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent);
            }
        });
    }
}
