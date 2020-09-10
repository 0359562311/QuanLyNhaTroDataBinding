package com.example.quanlynhatrodatabinding.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlynhatrodatabinding.databinding.ItemRenterBinding;

public class RenterAdapter extends RecyclerView.Adapter<RenterAdapter.ViewHolder> {



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRenterBinding irb;
        public ViewHolder(ItemRenterBinding irb){
            super(irb.getRoot());
            this.irb = irb;
        }
    }
}
