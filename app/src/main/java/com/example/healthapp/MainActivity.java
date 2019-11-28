package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.healthapp.Modal.LoginModal;
import com.example.healthapp.Retrofit.IRegister;
import com.example.healthapp.Retrofit.RetrofitClient;
import com.example.healthapp.Session.SessionManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IRegister myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    public static String USER_ID = "com.example.healthapp.MainActivity";

    // Session Manager Class
    SessionManager session;

    private EditText email;
    private EditText password;


    @Override
    protected void onStop() {
        compositeDisposable.dispose();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session Manager
        session = new SessionManager(getApplicationContext());

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IRegister.class);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    public void loginBtn(View view){
        loginUser(email.getText().toString(), password.getText().toString());
    }

    public void registerBtn(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void loginUser(String email, String password) {

         myAPI.loginUser(email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginModal>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoginModal loginModal) {
                            Log.d("user_id", loginModal.toString());
                            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            session.createLoginSession(loginModal.getId(), loginModal.getName(), loginModal.getEmail());
                            Intent intent = new Intent(getApplication(), Home.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(MainActivity.this, "Login Unsuccesssfull", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
