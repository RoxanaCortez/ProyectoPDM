package com.roxyapps.roxana.proyectopdm.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Words")
public class Words {

    @PrimaryKey private int id;
    @ColumnInfo(name = "imagen") private int imagen;
    @ColumnInfo(name = "opc1") private String opcion1;
    @ColumnInfo(name = "opc2") private String opcion2;
    @ColumnInfo(name = "opc3") private String opcion3;
    @ColumnInfo(name = "palabra") private String palabra;
    @ColumnInfo(name = "pregunta") private String pregunta;
    @ColumnInfo(name = "respuesta") private String respuesta;

    public Words(int id, int imagen, String opcion1, String opcion2, String opcion3, String palabra, String pregunta, String respuesta) {
        this.id = id;
        this.imagen = imagen;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.palabra = palabra;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
