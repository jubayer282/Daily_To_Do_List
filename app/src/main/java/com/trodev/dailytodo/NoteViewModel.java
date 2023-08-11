package com.trodev.dailytodo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepo noteRepo;
    private LiveData<List<Note>> notelist;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepo = new NoteRepo(application);
        notelist = noteRepo.getAllData();
    }

    public void insert(Note note){
        noteRepo.insertData(note);
    }
    public void delete(Note note){
        noteRepo.deleteData(note);
    }
    public void update(Note note){
        noteRepo.updateData(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return notelist;
    }
}
