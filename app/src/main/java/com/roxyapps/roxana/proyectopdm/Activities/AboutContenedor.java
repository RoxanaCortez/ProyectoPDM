package com.roxyapps.roxana.proyectopdm.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roxyapps.roxana.proyectopdm.Fragments.About;
import com.roxyapps.roxana.proyectopdm.R;

public class AboutContenedor extends AppCompatActivity implements  About.OnFragmentInteractionListener {

    Fragment fragmentAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_contenedor);

        fragmentAbout = new About();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_about, fragmentAbout).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
