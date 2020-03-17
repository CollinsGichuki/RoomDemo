package com.example.android.roomdemoapp.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//The app uses DAO(Database Access Object) to access the database
@Dao
public interface NoteDao {
    //Insert method
    @Insert
    void insert(Note note);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();
}
