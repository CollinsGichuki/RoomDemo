package com.example.android.roomdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {
    //Key for fetching the note
    public static final String NOTE_ADDED = "new_note";
    private String TAG = this.getClass().getSimpleName();
    private EditText fEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        //When the save button is clicked
        Button saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saving the note to the database
                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(fEditText.getText())){
                    setResult(RESULT_CANCELED, resultIntent);
                }else {
                    //Note we are saving
                    String note = fEditText.getText().toString();
                    //NOTE_ADDEED is the key for fetching the note we are saving
                    resultIntent.putExtra(NOTE_ADDED, note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });
    }
}
