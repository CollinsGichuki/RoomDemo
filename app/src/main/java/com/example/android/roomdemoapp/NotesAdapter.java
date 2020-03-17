package com.example.android.roomdemoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.roomdemoapp.Database.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Note> notes;

    NotesAdapter(List<Note> noteArrayList) {
        this.notes = noteArrayList;
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNoteId;
        private TextView textViewNote;

        NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteId = (TextView) itemView.findViewById(R.id.textViewNoteId);
            textViewNote = (TextView) itemView.findViewById(R.id.textViewNote);
        }

        private void bind(Note note) {
            textViewNoteId.setText(String.format("%s %s", "#", note.getId()));
            textViewNote.setText(note.getNote());
        }
    }
}
