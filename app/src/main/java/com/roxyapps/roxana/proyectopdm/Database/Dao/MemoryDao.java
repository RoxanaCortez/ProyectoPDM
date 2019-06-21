package com.roxyapps.roxana.proyectopdm.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Memory;
import java.util.List;

@Dao
public interface MemoryDao {
    @Insert
    void insert(Memory memory);

    @Query("select * from Memory")
    LiveData<List<Memory>> getAll();
}
