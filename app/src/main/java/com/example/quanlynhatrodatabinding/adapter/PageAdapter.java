package com.example.quanlynhatrodatabinding.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlynhatrodatabinding.ui.ContractFragment;
import com.example.quanlynhatrodatabinding.ui.HostelRoomFragment;
import com.example.quanlynhatrodatabinding.ui.RenterFragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HostelRoomFragment();
            case 1: return new RenterFragment();
            case 2: return new ContractFragment();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
