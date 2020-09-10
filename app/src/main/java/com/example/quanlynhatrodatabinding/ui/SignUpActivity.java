package com.example.quanlynhatrodatabinding.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.quanlynhatrodatabinding.R;
import com.example.quanlynhatrodatabinding.databinding.ActivitySignUpBinding;
import com.example.quanlynhatrodatabinding.viewmodel.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding mBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        final SignUpViewModel viewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        mBinding.setViewModel(viewModel);
        mBinding.setLifecycleOwner(this);
    }
}