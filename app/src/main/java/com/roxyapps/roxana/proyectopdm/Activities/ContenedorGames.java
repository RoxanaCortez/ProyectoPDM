package com.roxyapps.roxana.proyectopdm.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.Games;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

public class ContenedorGames extends AppCompatActivity implements ComunicaGames, Games.OnFragmentInteractionListener{

    Fragment fragmentGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_games);

        fragmentGames = new Games();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_games, fragmentGames).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void InicioMemory() {
        Toast.makeText(getApplicationContext(),"Inicio Memory desde el contenedor games",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InicioWords() {
        Toast.makeText(getApplicationContext(),"Inicio Words desde el contenedor games",Toast.LENGTH_SHORT).show();
    }
}
