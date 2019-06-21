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
    @ColumnInfo(name = "fecha") private String fecha;
    @ColumnInfo(name = "hora") private String hora;

    public Player(String nombre, String juego, String nivel, String puntos, String fecha, String hora){
        this.nombre = nombre;
        this.juego = juego;
        this.nivel = nivel;
        this.puntos=puntos;
        this.fecha = fecha;
        this.hora=hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
