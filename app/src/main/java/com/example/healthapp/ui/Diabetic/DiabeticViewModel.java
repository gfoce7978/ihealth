package com.example.healthapp.ui.Diabetic;

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

public class DiabeticViewModel extends ViewModel {


    IRegister myAPI;
    SessionManager sessionManager;
    boolean success;

    public boolean saveDiabetic(String reading, Context context){

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IRegister.class);
        sessionManager = new SessionManager(context);
        Log.d("idChecker",sessionManager.getUserDetails().get("id") );
        myAPI.saveDiabetic(Long.parseLong(sessionManager.getUserDetails().get("id")),reading)
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
