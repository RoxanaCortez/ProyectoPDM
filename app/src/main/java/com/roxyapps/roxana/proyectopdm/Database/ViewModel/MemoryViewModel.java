package com.roxyapps.roxana.proyectopdm.Database.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Memory;
import com.roxyapps.roxana.proyectopdm.Database.Repository.MemoryRepository;

import java.util.List;

public class MemoryViewModel extends AndroidViewModel {
    private MemoryRepository mRepository;
    private LiveData<List<Memory>> obtenerImagenes;

    public MemoryViewModel(Application application) {
        super(application);
        mRepository = new MemoryRepository(application);
        obtenerImagenes = mRepository.getAll();
    }

    public LiveData<List<Memory>> getAll() {
        return obtenerImagenes;
    }

    public void insert(Memory memory) {
        mRepository.insert(memory);
    }
}
