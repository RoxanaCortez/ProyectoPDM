package com.roxyapps.roxana.proyectopdm.Database.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Words;
import com.roxyapps.roxana.proyectopdm.Database.Repository.WordsRepository;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {
    private WordsRepository mRepository;
    private LiveData<List<Words>> obtenerPalabras;

    public WordsViewModel(Application application) {
        super(application);
        mRepository = new WordsRepository(application);
        obtenerPalabras = mRepository.getAll();
    }

    public LiveData<List<Words>> getAll() {
        return obtenerPalabras;
    }

    public void insert(Words words) {
        mRepository.insert(words);
    }
}
