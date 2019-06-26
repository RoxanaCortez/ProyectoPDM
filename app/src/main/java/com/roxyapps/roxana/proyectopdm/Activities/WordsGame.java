package com.roxyapps.roxana.proyectopdm.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Database.ViewModel.WordsViewModel;
import com.roxyapps.roxana.proyectopdm.Fragments.Games;
import com.roxyapps.roxana.proyectopdm.Fragments.WordsInstructions;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

public class WordsGame extends AppCompatActivity implements ComunicaGames, WordsInstructions.OnFragmentInteractionListener{

    private WordsViewModel words;

    private TextView puntostxt, numerotxt, frutatxt;
    private ImageButton atras;
    private ImageView fruta;
    private Button opcion1, opcion2, opcion3, fin;

    private String selecciono, resultado ="", opc1, opc2, opc3;
    private int pntObtenido, numFruta, total1, posicion;

    Fragment wordsInstructions;
    ComunicaGames interfaceComunicaGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_game);

        words = ViewModelProviders.of(this).get(WordsViewModel.class);

        atras = findViewById(R.id.btn_atras);
        fin = findViewById(R.id.btn_finalizar);
        puntostxt = findViewById(R.id.txt_num);
        numerotxt = findViewById(R.id.txt_pag);
        frutatxt = findViewById(R.id.txt_fruta);
        fruta = findViewById(R.id.img_fruta);
        opcion1 = findViewById(R.id.btn_opc1);
        opcion2 = findViewById(R.id.btn_opc2);
        opcion3 = findViewById(R.id.btn_opc3);

        opcion1.setOnClickListener(clickListener);
        opcion2.setOnClickListener(clickListener);
        opcion3.setOnClickListener(clickListener);
        fin.setOnClickListener(clickListener);
        atras.setOnClickListener(clickListener);

        wordsInstructions = new WordsInstructions();

        actualizarFruta();
    }

    public String getResultado() {
        return resultado = String.valueOf(pntObtenido);
    }

    public void actualizarPuntos(int a){
        puntostxt.setText(""+a);
    }

    private void actualizarFruta(){
        words.getAll().observe(this, word -> {
            if (word == null || word.size() == 0) return;
            posicion = (int) ((Math.random() * word.size())) % (word.size() - 1);

            total1 = word.size();
            if(numFruta<total1){
                fruta.setImageResource(word.get(posicion).getImagen());
                frutatxt.setText(word.get(posicion).getPregunta());
                opcion1.setText(word.get(posicion).getOpcion1());
                opc1 = word.get(posicion).getOpcion1();
                opcion2.setText(word.get(posicion).getOpcion2());
                opc2 = word.get(posicion).getOpcion2();
                opcion3.setText(word.get(posicion).getOpcion3());
                opc3 = word.get(posicion).getOpcion3();
                selecciono =word.get(posicion).getRespuesta();

                numerotxt.setText(++numFruta+"/19");
            }else{
                Intent intent_score = new Intent(getApplicationContext(), WordScore.class);
                startActivity(intent_score);
            }
        });
    }

    public AlertDialog mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(WordsGame.this);

        mensaje.setMessage("Está seguro de salir del juego")
                .setNegativeButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
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

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_opc1:
                    if(opc1.equals(selecciono)){
                        Toast.makeText(getApplicationContext(), "si entra", Toast.LENGTH_SHORT).show();
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();
                    }
                    break;
                case R.id.btn_opc2:
                    if(opc2.equals(selecciono)){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();
                    }
                    break;
                case R.id.btn_opc3:
                    if(opc3.equals(selecciono)){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();
                    }
                    break;
                case R.id.btn_atras:
                    mensaje().show();
                    break;
                case R.id.btn_finalizar:
                    //Toast.makeText(getApplicationContext(), "Estoy aceptando el click", Toast.LENGTH_SHORT).show();
                    Intent intent_score = new Intent(getApplicationContext(), WordScore.class);
                    startActivity(intent_score);
                    break;
            }
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void InicioMemory() {

    }

    @Override
    public void InicioWords() {

    }

    @Override
    public void InicioPlay() {

    }

    @Override
    public void InicioPlayMemory() {

    }

    @Override
    public void Salir() {

    }

    @Override
    public void Exit() {

    }

    @Override
    public void Exit2() {

    }
}


