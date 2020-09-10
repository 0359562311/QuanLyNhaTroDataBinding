package com.example.quanlynhatrodatabinding.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlynhatrodatabinding.BroadCastActions;
import com.example.quanlynhatrodatabinding.PreferenceConfig;
import com.example.quanlynhatrodatabinding.model.RetrofitAPI;
import com.example.quanlynhatrodatabinding.model.RetrofitCall;
import com.example.quanlynhatrodatabinding.model.UserResponse;
import com.example.quanlynhatrodatabinding.ui.MainActivity;
import com.example.quanlynhatrodatabinding.ui.SignUpActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInViewModel extends ViewModel {
    private static final String TAG = "TanKiem";
    MutableLiveData<String> account = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<Boolean> enabled = new MutableLiveData<>();

    public LogInViewModel() {
        enabled.setValue(true);
    }

    public MutableLiveData<Boolean> getEnabled(){
        return enabled;
    }

    public MutableLiveData<String> getAccount() {
        return account;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public void checkLogin(View v, String account, String password){
        Log.d(TAG, "checkLogin: " + account + " " + password);
        enabled.setValue(false);
        RetrofitAPI.getInstance().create(RetrofitCall.class).checkLogin(account, password).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                enabled.setValue(true);
                if(response.code() == 200){
                    UserResponse message = response.body();
                    Log.d(TAG, "onResponse: " + message.getError() + " " + message.getMessage());
                    Log.d(TAG, "onResponse: " + (message.getData()!=null? message.getData().getAccount() : "null"));

                    PreferenceConfig.putAccount(v.getContext(),account);
                    v.getContext().sendBroadcast(new Intent(BroadCastActions.LOG_IN_COMPLETE));
                }else if(response.code() == 422){
                    UserResponse userResponse = response.body();
                    if(userResponse == null)
                        Log.d(TAG, "onResponse: null on wrong login information.");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void openSignUp(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, SignUpActivity.class));
    }


}
