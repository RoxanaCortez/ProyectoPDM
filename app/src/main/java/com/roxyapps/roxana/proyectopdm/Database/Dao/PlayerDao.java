package com.roxyapps.roxana.proyectopdm.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;

import java.util.List;

@Dao
public interface PlayerDao {
    @Insert
    void insert(Player player);

    @Query("select * from Player")
    LiveData<List<Player>> getAll();
}
