package com.example.healthapp.ui.Heart;

import android.content.Context;
import android.util.Log;

import com.example.healthapp.Retrofit.IRegister;
import com.example.healthapp.Retrofit.RetrofitClient;
import com.example.healthapp.Session.SessionManager;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HeartViewModel extends ViewModel {

    IRegister myAPI;
    SessionManager sessionManager;
    boolean success;

    public boolean saveHeart(String reading, Context cotext){

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IRegister.class);
        sessionManager = new SessionManager(cotext);
        Log.d("idChecker",sessionManager.getUserDetails().get("id") );
        myAPI.saveHeart(Long.parseLong(sessionManager.getUserDetails().get("id")),reading)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        success = true;
                    }

                    @Override
                    public void onError(Throwable e) {
                        success = false;
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return success;

    }

    // TODO: Implement the ViewModel
}
