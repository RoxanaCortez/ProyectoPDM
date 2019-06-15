package com.roxyapps.roxana.proyectopdm;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.Inicio;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaFragments;

public class MainActivity extends AppCompatActivity implements ComunicaFragments, Inicio.OnFragmentInteractionListener{

    Fragment fragmentInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInicio = new Inicio();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentInicio).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void InicioParents() {
        Toast.makeText(getApplicationContext(),"Inicio Padres desde Main",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InicioGames() {
        Toast.makeText(getApplicationContext(),"Inicio Games desde Main",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InicioAbout() {
        Toast.makeText(getApplicationContext(),"Inicio About desde Main",Toast.LENGTH_SHORT).show();
    }
}