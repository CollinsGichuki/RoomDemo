package com.example.android.roomdemoapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao fNoteDao();
    //Making the database be a singleton
    private static volatile NoteDatabase noteRoomInstance;
    public static NoteDatabase getDatabase(final Context context){
        if (noteRoomInstance == null){
            //If there is no existing instance of the database, create one
            synchronized (NoteDatabase.class){
                if (noteRoomInstance == null){
                    noteRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDatabase.class, "note_database").build();
                }
            }
        }
        //Return the existing instance
        return noteRoomInstance;
    }
}
