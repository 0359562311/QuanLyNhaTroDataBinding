package com.example.quanlynhatrodatabinding;

import android.widget.ImageButton;

import com.example.quanlynhatrodatabinding.model.Renter;

public interface OnItemClickHandler {
    void openPopupMenu(ImageButton view, Renter renter);
}
