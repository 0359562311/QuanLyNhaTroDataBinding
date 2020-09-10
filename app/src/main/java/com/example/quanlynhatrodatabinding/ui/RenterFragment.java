package com.example.quanlynhatrodatabinding.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlynhatrodatabinding.R;
import com.example.quanlynhatrodatabinding.databinding.FragmentRenterBinding;


public class RenterFragment extends Fragment {


    public RenterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentRenterBinding mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_renter,container,false);

        return mBinding.getRoot();
    }
}