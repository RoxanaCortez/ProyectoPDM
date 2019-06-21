package com.roxyapps.roxana.proyectopdm.Database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Dao.PlayerDao;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;
import com.roxyapps.roxana.proyectopdm.Database.RoomDb;

import java.util.List;

public class PlayerRepository {
    private PlayerDao playerDao;
    private LiveData<List<Player>> obtenerPlayers;

    public PlayerRepository(Application application) {
        RoomDb db = RoomDb.getDatabase(application);
        playerDao = db.playerDao();
        obtenerPlayers = playerDao.getAll();
    }

    public LiveData<List<Player>> getAll() {
        return obtenerPlayers;
    }

    public void insert(Player player) {
        playerDao.insert(player);
    }
}
