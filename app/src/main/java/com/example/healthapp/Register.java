package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthapp.Retrofit.IRegister;
import com.example.healthapp.Retrofit.RetrofitClient;

public class Register extends AppCompatActivity {

    IRegister myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private EditText email;
    private EditText password;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IRegister.class);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);

    }

    public void registerBtn(View view){
        registerUser(email.getText().toString(), name.getText().toString(), password.getText().toString());
    }

    private void registerUser(String email, String name, String password) {
        compositeDisposable.add(myAPI.registerUser(email, name, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("encrypted_password"))
                        {
                            Toast.makeText(Register.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplication(), MainActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(Register.this, ""+s, Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }
}

