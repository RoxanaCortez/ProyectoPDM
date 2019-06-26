package com.roxyapps.roxana.proyectopdm.Activities;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.roxyapps.roxana.proyectopdm.Fragments.Games;
import com.roxyapps.roxana.proyectopdm.Fragments.MemoryInstruccions;
import com.roxyapps.roxana.proyectopdm.Fragments.WordsInstructions;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

public class ContenedorGames extends AppCompatActivity implements ComunicaGames, Games.OnFragmentInteractionListener,
        WordsInstructions.OnFragmentInteractionListener, MemoryInstruccions.OnFragmentInteractionListener{

    Fragment fragmentGames, fragmentWordInstruccion, fragmentMemoryInstruccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_games);

        fragmentGames = new Games();
        fragmentWordInstruccion = new WordsInstructions();
        fragmentMemoryInstruccion = new MemoryInstruccions();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentGames).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void InicioMemory() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentMemoryInstruccion).commit();
    }

    @Override
    public void InicioWords() {

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentWordInstruccion).commit();
    }

    @Override
    public void InicioPlay() {
        Intent intent_play = new Intent(this, WordsGame.class);
        startActivity(intent_play);
    }

    @Override
    public void InicioPlayMemory() {
        Intent intent_playMemory = new Intent(this, MemoryGame.class);
        startActivity(intent_playMemory);
    }

    @Override
    public void Salir() {
        onBackPressed();
    }

    @Override
    public void Exit() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentGames).commit();
    }

    @Override
    public void Exit2() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentGames).commit();
    }


}
