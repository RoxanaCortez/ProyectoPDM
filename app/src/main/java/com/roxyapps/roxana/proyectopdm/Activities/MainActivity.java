package com.roxyapps.roxana.proyectopdm.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.Inicio;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaFragments;
import com.roxyapps.roxana.proyectopdm.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements ComunicaFragments, Inicio.OnFragmentInteractionListener{
    //inicializando variables para fragmento y musica
    Fragment fragmentInicio;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInicio = new Inicio();
        player = MediaPlayer.create(this, R.raw.music01); //Archivo por Bensound.com
        player.start();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentInicio).commit();
    }

    public void onPause(){
        super.onPause();
        //player.pause();
    }

    public void onResume(){
        super.onResume();
        player.start();
    }

    public void onDestroy(){
        super.onDestroy();
        player.release();
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

    @Override
    public void Play() {
        if(player.isPlaying()==true){
            player.pause();
        }
        else{
            player.start();
        }
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