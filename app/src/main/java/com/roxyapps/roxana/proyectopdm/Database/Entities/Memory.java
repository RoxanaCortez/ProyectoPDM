package com.roxyapps.roxana.proyectopdm.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Memory")
public class Memory {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "imagen") private int imagen;

    public Memory(int id, int imagen){
        this.id = id;
        this.imagen= imagen;
    }


    public int getId() {

        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {

        this.imagen = imagen;
    }

}
