package com.example.room_test03;

import androidx.cardview.widget.CardView;

import com.example.room_test03.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
