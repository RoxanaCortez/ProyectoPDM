package com.roxyapps.roxana.proyectopdm.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.roxyapps.roxana.proyectopdm.R;

public class WordsGame extends AppCompatActivity {

    private Banco palabras = new Banco();

    private TextView puntostxt, numerotxt, frutatxt;
    private ImageView fruta;
    private Button opcion1, opcion2, opcion3;

    private String selecciono, resultado ="";
    private int pntObtenido = 0, numFruta = 0, total1=0, total2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_game);

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
            fruta.setImageResource(palabras.getFruver(numFruta));
            frutatxt.setText(palabras.getFrutas(numFruta));
            opcion1.setText(palabras.getOpc1(numFruta));
            opcion2.setText(palabras.getOpc2(numFruta));
            opcion3.setText(palabras.getOpc3(numFruta));

            selecciono = palabras.getRespuesta(numFruta);

            numerotxt.setText(++numFruta+"/19");
        }else{
            finish();
        }
    }

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
                        actualizarFruta(); }

                    break;
                case R.id.btn_opc2:
                    if(opcion2.getText() == selecciono){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta(); }

                    break;
                case R.id.btn_opc3:
                    if(opcion3.getText() == selecciono){
                        pntObtenido += 1;
                        actualizarPuntos(pntObtenido);
                        actualizarFruta();
                    }else{
                        actualizarFruta();}

                    break;
            }
        }
    };

}


