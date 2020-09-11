package com.example.quanlynhatrodatabinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlynhatrodatabinding.OnItemClickHandler;
import com.example.quanlynhatrodatabinding.R;
import com.example.quanlynhatrodatabinding.databinding.ItemRenterBinding;
import com.example.quanlynhatrodatabinding.model.Renter;

import java.util.List;

public class RenterAdapter extends RecyclerView.Adapter<RenterAdapter.ViewHolder> implements OnItemClickHandler {

    List<Renter> list;
    Context context;

    public RenterAdapter(List<Renter> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_renter,parent,
                false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Renter renter = list.get(position);
        holder.irb.setRenter(renter);
        holder.irb.setOnClick(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void openPopupMenu(ImageButton view, Renter renter) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRenterBinding irb;
        public ViewHolder(ItemRenterBinding irb){
            super(irb.getRoot());
            this.irb = irb;
        }
    }
}
