package com.roxyapps.roxana.proyectopdm.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Words;

import java.util.List;

@Dao
public interface WordsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Words words);

    @Query("select * from Words")
    LiveData<List<Words>> getAll();
}
