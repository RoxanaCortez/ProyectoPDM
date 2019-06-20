package com.roxyapps.roxana.proyectopdm.Activities;

import android.content.DialogInterface;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.WordsInstructions;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

public class WordsGame extends AppCompatActivity implements ComunicaGames, WordsInstructions.OnFragmentInteractionListener {

    private Banco palabras = new Banco();

    private TextView puntostxt, numerotxt, frutatxt;
    private ImageButton atras;
    private ImageView fruta;
    private Button opcion1, opcion2, opcion3, fin;

    private String selecciono, resultado ="";
    private int pntObtenido = 0, numFruta = 0, total1=0, total2=0;

    Fragment wordsInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_game);

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
        total1 = palabras.getLongitudOpciones();
        total2 = palabras.getLongitudFrutas();

        if(numFruta<total1 & numFruta<total2){
            int posicion = (int) (Math.random()*19);
            fruta.setImageResource(palabras.getFruver(posicion));
            frutatxt.setText(palabras.getFrutas(posicion));
            opcion1.setText(palabras.getOpc1(posicion));
            opcion2.setText(palabras.getOpc2(posicion));
            opcion3.setText(palabras.getOpc3(posicion));

            selecciono = palabras.getRespuesta(posicion);

            numerotxt.setText(++numFruta+"/19");
        }else{
            finish();
        }
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
                    if(opcion1.getText() == selecciono){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();
                    }
                    break;
                case R.id.btn_opc2:
                    if(opcion2.getText() == selecciono){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();
                    }
                    break;
                case R.id.btn_opc3:
                    if(opcion3.getText() == selecciono){
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
                    Toast.makeText(getApplicationContext(), "Estoy aceptando el click", Toast.LENGTH_SHORT).show();
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
}


