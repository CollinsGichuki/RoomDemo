package com.example.android.roomdemoapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;

//The app uses DAO(Database Access Object) to access the database
@Dao
public interface NoteDao {
    //Insert method
    @Insert
    void insert(Note note);
}
