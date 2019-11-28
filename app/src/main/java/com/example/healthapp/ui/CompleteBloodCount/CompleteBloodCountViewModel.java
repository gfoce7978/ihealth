package com.example.healthapp.ui.CompleteBloodCount;

import android.content.Context;
import android.util.Log;

import com.example.healthapp.Modal.CompleteBloodCountModal;
import com.example.healthapp.Retrofit.IRegister;
import com.example.healthapp.Retrofit.RetrofitClient;
import com.example.healthapp.Session.SessionManager;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class CompleteBloodCountViewModel extends ViewModel {
    IRegister myAPI;
    SessionManager sessionManager;
    boolean success;

    public boolean saveCompleteBloodCount(CompleteBloodCountModal completeBloodCountModal,Context context){

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(IRegister.class);
        sessionManager = new SessionManager(context);

        Log.d("idChecker",sessionManager.getUserDetails().get("id") );
        Log.d("CompleteBloodCount", completeBloodCountModal.toString());

        completeBloodCountModal.setUserId(Long.parseLong(sessionManager.getUserDetails().get("id")));

//        RequestBody body = RequestBody.create(MediaType.parse("application/json"),completeBloodCountModal.toString());
//        System.out.println(body.contentType());
 //       Log.d("boydPrint");

        myAPI.saveCompleteBloodCount(completeBloodCountModal)
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

}
