package com.example.android.roomdemoapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@SuppressWarnings("UNCHECKED_CAST")
/**
 * Note View Model Factory class responsible for creating an instance of Note View Model
 */
public class NoteViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    NoteViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NoteViewModel(application);
    }
}
