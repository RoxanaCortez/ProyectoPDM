package com.roxyapps.roxana.proyectopdm.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.roxyapps.roxana.proyectopdm.Activities.ui.main.SectionsPagerAdapter;
import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionFinal;
import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionInformacion;
import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionIniciar;
import com.roxyapps.roxana.proyectopdm.Fragments.Introduccion;
import com.roxyapps.roxana.proyectopdm.Fragments.instruccionPadres;
import com.roxyapps.roxana.proyectopdm.R;

public class ContenedorInstrucciones extends AppCompatActivity implements Introduccion.OnFragmentInteractionListener,
        instruccionPadres.OnFragmentInteractionListener, InstruccionIniciar.OnFragmentInteractionListener,
        InstruccionInformacion.OnFragmentInteractionListener, InstruccionFinal.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_instrucciones);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}