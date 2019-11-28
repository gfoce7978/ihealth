package com.example.healthapp.Retrofit;

import com.example.healthapp.Modal.CompleteBloodCountModal;
import com.example.healthapp.Modal.LoginModal;

import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRegister {


    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("email") String email,
                                        @Field("name") String name,
                                        @Field("password") String password);

    @POST("login")
    @FormUrlEncoded
    Observable<LoginModal> loginUser(@Field("email") String email,
                                 @Field("password") String password);

    @POST("savebloodpressure")
    @FormUrlEncoded
    Observable<String> saveBloodPressure(@Field("id") Long id, @Field("value") String value);

    @POST("savebloodpressure")
    @FormUrlEncoded
    Observable<String> saveHeart(@Field("id") Long id, @Field("value") String value);


    @POST("savediabetic")
    @FormUrlEncoded
    Observable<String> saveDiabetic(@Field("id") Long id, @Field("value") String value);


    @POST("saveglucose")
    @FormUrlEncoded
    Observable<String> saveGlucose(@Field("id") Long id, @Field("previousReading") String previousReading, @Field("currentReading") String currentReading);

    @POST("savecompletebloodcount")
    Observable<String> saveCompleteBloodCount(@Body CompleteBloodCountModal completeBloodCountModal);
}
