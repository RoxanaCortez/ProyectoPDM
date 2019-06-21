package com.roxyapps.roxana.proyectopdm.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.sql.Time;

@Entity(tableName = "Player")
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nombre") private String nombre;
    @ColumnInfo(name = "juego") private String juego;
    @ColumnInfo(name = "nivel") private String nivel;
    @ColumnInfo(name = "puntos") private String puntos;
    @ColumnInfo(name = "fecha") private Date fecha;
    @ColumnInfo(name = "hora") private Time hora;

    public Player(String nombre, String juego, String nivel, String puntos, Date fecha, Time hora)
    {this.nombre = nombre; this.juego = juego; this.nivel = nivel; this.puntos=puntos; this.fecha = fecha; this.hora=hora;}

}
