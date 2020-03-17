package com.example.android.roomdemoapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.roomdemoapp.Database.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private String TAG = this.getClass().getSimpleName();
    private NoteViewModel fNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Creating a new note
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Move to the new note activity
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });

        fNoteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
    }

    //Result of the note saving action
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            //Code to insert the note
            final String note_id = UUID.randomUUID().toString();
            //Pass the note id and the key for fetching the note from the newNoteActivity through the @data param
            Note note = new Note(note_id, data.getStringExtra(NewNoteActivity.NOTE_ADDED));
            //Passing the note to the insert method
            fNoteViewModel.insert(note);

            //Toast to show note is saved
            Toast.makeText(this, R.string.save, Toast.LENGTH_SHORT).show();
        }else {
            //Toast to show note is not saved
            Toast.makeText(this, R.string.not_saved, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
