package com.roxyapps.roxana.proyectopdm.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.About;
import com.roxyapps.roxana.proyectopdm.Fragments.Inicio;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaFragments;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

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
        Toast.makeText(getApplicationContext(),"Inicio Parents desde Main",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InicioGames() {
        Intent intent_parents = new Intent(this, ContenedorGames.class);
        startActivity(intent_parents);
    }

    @Override
    public void InicioAbout() {
        Intent intent_about = new Intent(this, AboutContenedor.class);
        startActivity(intent_about);
    }

    @Override
    public void InicioHelp() {
        Intent intent_help = new Intent(this, ContenedorInstrucciones.class);
        startActivity(intent_help);
    }

    @Override
    public void Salir() {
        mensaje().show();
    }

    public AlertDialog mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity.this);

        mensaje.setMessage("Está seguro que desea salir")
                .setNegativeButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(), "Estoy aceptando el click", Toast.LENGTH_SHORT).show();
                    }
                });
        return mensaje.create();
    };
}