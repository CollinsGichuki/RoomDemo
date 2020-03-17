package com.example.android.roomdemoapp.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Here we get or set the field values
@Entity(tableName = "notes")
public class Note {
    //id column is the priimary key and it is not null
    @PrimaryKey
    @NonNull
    private String id;

    //note column is not null as well
    @NonNull
    private String note;

    public Note(@NonNull String id, @NonNull String note) {
        this.id = id;
        this.note = note;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getNote() {
        return this.note;
    }
}
