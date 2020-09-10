package com.example.quanlynhatrodatabinding.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.quanlynhatrodatabinding.BroadCastActions;
import com.example.quanlynhatrodatabinding.R;
import com.example.quanlynhatrodatabinding.databinding.ActivityLogInBinding;
import com.example.quanlynhatrodatabinding.viewmodel.LogInViewModel;

public class LogInActivity extends AppCompatActivity {
    private static final String TAG = "TanKiem";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLogInBinding mBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_log_in);

        final LogInViewModel viewModel = ViewModelProviders.of(this).get(LogInViewModel.class);
        mBinding.setViewModel(viewModel);
        mBinding.setLifecycleOwner(this);

        LocalBroadcastManager.getInstance(this).
                registerReceiver(
                        new HandleBroadcast(),
                        new IntentFilter(BroadCastActions.LOG_IN_COMPLETE)
                );
    }

    private class HandleBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(BroadCastActions.LOG_IN_COMPLETE)){
                startActivity(new Intent(LogInActivity.this,MainActivity.class));
                LogInActivity.this.finish();
            }
        }
    }
}