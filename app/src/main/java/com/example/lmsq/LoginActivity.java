package com.example.lmsq;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnmasuk;
    String TAG = "log";
    String email,pass;
    private FirebaseAuth mAuth;
    //ini untuk sp
    private static final String EMAIL_KEY = "key_email";
    private SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        //menghubungkan variabel dengan layout
        username = findViewById(R.id.edtTxtUsername);
        password = findViewById(R.id.edtTxtPassword);
        btnmasuk = findViewById(R.id.btnLogin);
        //ini untuk sp
        this.sharedPrefs = this.getSharedPreferences("sp", Context.MODE_PRIVATE);

        //ketika button diklik
        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 email = username.getText().toString();
                 pass = password.getText().toString();

                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
//                                   Toast.makeText(LoginActivity.this,"berhasil login", Toast.LENGTH_LONG).show();
                                    saveUsername(email,true);
                                    Intent intent=new Intent(LoginActivity.this,MenuActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });

            }
        });
    }
    private void saveUsername(String email, Boolean save)
    {

        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        if(save){
            editor.putString(EMAIL_KEY, email);

        }
        else {
            editor.remove(EMAIL_KEY);

        }
        editor.apply();
    }
}