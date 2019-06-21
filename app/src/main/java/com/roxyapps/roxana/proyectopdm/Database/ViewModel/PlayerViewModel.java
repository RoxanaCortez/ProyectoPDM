package com.roxyapps.roxana.proyectopdm.Database.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;
import com.roxyapps.roxana.proyectopdm.Database.Repository.PlayerRepository;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {
    private PlayerRepository pRepository;
    private LiveData<List<Player>> obtenerPlayers;

    public PlayerViewModel(Application application) {
        super(application);
        pRepository = new PlayerRepository(application);
        obtenerPlayers = pRepository.getAll();
    }

    public LiveData<List<Player>> getAll() {
        return obtenerPlayers;
    }

    public void insert(Player player) {
        pRepository.insert(player);
    }
}
