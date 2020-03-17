package com.example.android.roomdemoapp;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.android.roomdemoapp.Database.Note;
import com.example.android.roomdemoapp.Database.NoteDao;
import com.example.android.roomdemoapp.Database.NoteDatabase;

public class NoteViewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();
    private NoteDatabase fNoteDatabase;
    private NoteDao fNoteDao;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        fNoteDatabase = NoteDatabase.getDatabase(application);
        fNoteDao = fNoteDatabase.fNoteDao();
    }
    //Wrapper method for insert function from the Dao
    public void insert(Note note){
        //Needs to be performed in the background task
        new InsertAsyncTask(fNoteDao).execute(note);
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void>{
        NoteDao noteDao;

        public InsertAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel destroyed");
    }
}
