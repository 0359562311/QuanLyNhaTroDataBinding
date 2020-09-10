package com.example.quanlynhatrodatabinding.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlynhatrodatabinding.model.RetrofitAPI;
import com.example.quanlynhatrodatabinding.model.RetrofitCall;
import com.example.quanlynhatrodatabinding.model.UserResponse;
import com.example.quanlynhatrodatabinding.ui.LogInActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpViewModel extends ViewModel {
    private static final String TAG = "TanKiem";
    MutableLiveData<String> account = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<String> cfPassword = new MutableLiveData<>();
    MutableLiveData<String> message = new MutableLiveData<>();

    public SignUpViewModel() {
        account.setValue("");
        password.setValue("");
        cfPassword.setValue("");
        message.setValue("");
    }

    public void checkSignUp(View v, String account, String password, String cfPassword){
        Log.d(TAG, "checkSignUp: " + account + " " + password + " " + cfPassword);
        if(account.isEmpty() || password.isEmpty() || cfPassword.isEmpty()){
            message.setValue("Fill in all information.");
            return;
        }

        if(!password.equals(cfPassword)){
            message.setValue("password and confirm password not match.");
            return;
        }

        RetrofitAPI.getInstance().create(RetrofitCall.class).createUser(account, password).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if(response.code() == 201){
                    message.setValue(response.body().getMessage());
                }else if(response.code() == 409){
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        message.setValue(object.getString("message"));
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    message.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                message.setValue(t.getMessage());
            }
        });
    }


    public MutableLiveData<String> getAccount() {
        return account;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<String> getCfPassword() {
        return cfPassword;
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }
}
