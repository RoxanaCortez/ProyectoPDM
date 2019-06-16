package com.roxyapps.roxana.proyectopdm.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private LinearLayout marcadorll;
    private TextView[] marcadorSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_instrucciones);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        marcadorll = findViewById(R.id.ll_marcador);
        agregarMarcador(0);

        viewPager.addOnPageChangeListener(viewListener);
    }

    private void agregarMarcador(int posicion) {
        marcadorSlide = new TextView[5];
        marcadorll.removeAllViews();

        for(int i=0; i<marcadorSlide.length; i++){
            marcadorSlide[i] = new TextView(this);
            marcadorSlide[i].setText(Html.fromHtml("&#8226"));
            marcadorSlide[i].setTextSize(25);
            marcadorSlide[i].setTextColor(getResources().getColor(R.color.gray));

            marcadorll.addView(marcadorSlide[i]);
        }

        if(marcadorSlide.length > 0){
            marcadorSlide[posicion].setTextColor(getResources().getColor(R.color.darkgray));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            agregarMarcador(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}