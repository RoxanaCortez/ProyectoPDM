package com.roxyapps.roxana.proyectopdm.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roxyapps.roxana.proyectopdm.Fragments.MemoryInstruccions;
import com.roxyapps.roxana.proyectopdm.Interfaces.ComunicaGames;
import com.roxyapps.roxana.proyectopdm.R;

public class MemoryGame extends AppCompatActivity implements ComunicaGames, MemoryInstruccions.OnFragmentInteractionListener {

    private SoundPool sonido;
    private int click;

    private ImageView imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7, imagen8, imagen9, imagen10, imagen11,
            imagen12, imagen13, imagen14, imagen15, imagen16;

    private TextView parejas, puntos;

    private Button terminar;
    private ImageButton atras2;

    private int imagenes[] = {R.drawable.elephant_icon, R.drawable.panda_icon, R.drawable.jaguar_icon,
            R.drawable.pig_icon, R.drawable.hippo_icon, R.drawable.monkey_icon, R.drawable.lion_icon, R.drawable.frog_icon};

    private  int imagenes2[] = {R.drawable.fish_icon, R.drawable.dog_icon, R.drawable.flamingo_icon, R.drawable.cat_icon,
            R.drawable.gorilla_icon, R.drawable.snail_icon, R.drawable.snake_icon, R.drawable.guacamaya_icon};

    private int x[][]=  {{R.drawable.fish_icon, R.drawable.dog_icon, R.drawable.flamingo_icon, R.drawable.cat_icon,
            R.drawable.gorilla_icon, R.drawable.snail_icon, R.drawable.snake_icon, R.drawable.guacamaya_icon},{R.drawable.elephant_icon, R.drawable.panda_icon, R.drawable.jaguar_icon,
            R.drawable.pig_icon, R.drawable.hippo_icon, R.drawable.monkey_icon, R.drawable.lion_icon, R.drawable.frog_icon}};
    private int cartas [] = new int[16];
    private int cartas_seleccionadas [] = new int[2];
    private int  imagenes_seleccionadas [] = new int[2];
    private int cartas_final []= new int[16];
    int turno = 0, ganador=0;
    private int  numero = 0, numero2 = 0;


    Fragment memoryInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        parejas = findViewById(R.id.txt_numparejas);
        puntos = findViewById(R.id.txt_numpuntos);
        terminar = findViewById(R.id.btn_terminar);
        atras2 = findViewById(R.id.btn_atras2);

        imagen1 = findViewById(R.id.img1);
        imagen2 = findViewById(R.id.img2);
        imagen3 = findViewById(R.id.img3);
        imagen4 = findViewById(R.id.img4);
        imagen5 = findViewById(R.id.img5);
        imagen6 = findViewById(R.id.img6);
        imagen7 = findViewById(R.id.img7);
        imagen8 = findViewById(R.id.img8);
        imagen9 = findViewById(R.id.img9);
        imagen10 = findViewById(R.id.img10);
        imagen11 = findViewById(R.id.img11);
        imagen12 = findViewById(R.id.img12);
        imagen13 = findViewById(R.id.img13);
        imagen14 = findViewById(R.id.img14);
        imagen15 = findViewById(R.id.img15);
        imagen16 = findViewById(R.id.img16);

        imagen1.setOnClickListener(clickListener);
        imagen2.setOnClickListener(clickListener);
        imagen3.setOnClickListener(clickListener);
        imagen4.setOnClickListener(clickListener);
        imagen5.setOnClickListener(clickListener);
        imagen6.setOnClickListener(clickListener);
        imagen7.setOnClickListener(clickListener);
        imagen8.setOnClickListener(clickListener);
        imagen9.setOnClickListener(clickListener);
        imagen10.setOnClickListener(clickListener);
        imagen11.setOnClickListener(clickListener);
        imagen12.setOnClickListener(clickListener);
        imagen13.setOnClickListener(clickListener);
        imagen14.setOnClickListener(clickListener);
        imagen15.setOnClickListener(clickListener);
        imagen16.setOnClickListener(clickListener);

        terminar.setOnClickListener(clickListener);
        atras2.setOnClickListener(clickListener);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){
            AudioAttributes audio = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            sonido = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audio).build();
        }else{
            sonido = new SoundPool(6, AudioManager.STREAM_MUSIC,0);
        }
        click = sonido.load(this, R.raw.click18c,1);

        if(savedInstanceState == null){
            colocarImagenes();
            for (int i=0;i<16;i++){
                cartas_final[i]=0;
            }
            cartas_seleccionadas[0]=16;
        }
    }

    public AlertDialog mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(MemoryGame.this);

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

                }
                });
        return mensaje.create();
    };

    private void colocarImagenes(){
        int coleccion=0 ;
                coleccion= (int)(Math.random()*2);
        int posicion, contador = 0;
        for(int i=0;i<8;){
            posicion = (int)(Math.random()*16);
            if(cartas[posicion]==0) {
                cartas[posicion] = x[coleccion][i];
                contador++;
                if(contador == 2){
                    i++;
                    contador=0;
                }
            }
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img1:
                    sonido.play(click,1,1,0,0,1);
                    imagen1.setImageResource(cartas[0]);
                    imagenes_seleccionadas[turno] = cartas[0];
                    cartas_seleccionadas[turno] = 0;
                    imagen1.setEnabled(false);
                    break;
                case R.id.img2:
                    sonido.play(click,1,1,0,0,1);
                    imagen2.setImageResource(cartas[1]);
                    imagenes_seleccionadas[turno] = cartas[1];
                    cartas_seleccionadas[turno] = 1;
                    imagen2.setEnabled(false);
                    break;
                case R.id.img3:
                    sonido.play(click,1,1,0,0,1);
                    imagen3.setImageResource(cartas[2]);
                    imagenes_seleccionadas[turno] = cartas[2];
                    cartas_seleccionadas[turno] = 2;
                    imagen3.setEnabled(false);
                    break;
                case R.id.img4:
                    sonido.play(click,1,1,0,0,1);
                    imagen4.setImageResource(cartas[3]);
                    imagenes_seleccionadas[turno] = cartas[3];
                    cartas_seleccionadas[turno] = 3;
                    imagen4.setEnabled(false);
                    break;
                case R.id.img5:
                    sonido.play(click,1,1,0,0,1);
                    imagen5.setImageResource(cartas[4]);
                    imagenes_seleccionadas[turno] = cartas[4];
                    cartas_seleccionadas[turno] = 4;
                    imagen5.setEnabled(false);
                    break;
                case R.id.img6:
                    sonido.play(click,1,1,0,0,1);
                    imagen6.setImageResource(cartas[5]);
                    imagenes_seleccionadas[turno] = cartas[5];
                    cartas_seleccionadas[turno] = 5;
                    imagen6.setEnabled(false);
                    break;
                case R.id.img7:
                    sonido.play(click,1,1,0,0,1);
                    imagen7.setImageResource(cartas[6]);
                    imagenes_seleccionadas[turno] = cartas[6];
                    cartas_seleccionadas[turno] = 6;
                    imagen7.setEnabled(false);
                    break;
                case R.id.img8:
                    sonido.play(click,1,1,0,0,1);
                    imagen8.setImageResource(cartas[7]);
                    imagenes_seleccionadas[turno] = cartas[7];
                    cartas_seleccionadas[turno] = 7;
                    imagen8.setEnabled(false);
                    break;
                case R.id.img9:
                    sonido.play(click,1,1,0,0,1);
                    imagen9.setImageResource(cartas[8]);
                    imagenes_seleccionadas[turno] = cartas[8];
                    cartas_seleccionadas[turno] = 8;
                    imagen9.setEnabled(false);
                    break;
                case R.id.img10:
                    sonido.play(click,1,1,0,0,1);
                    imagen10.setImageResource(cartas[9]);
                    imagenes_seleccionadas[turno] = cartas[9];
                    cartas_seleccionadas[turno] = 9;
                    imagen10.setEnabled(false);
                    break;
                case R.id.img11:
                    sonido.play(click,1,1,0,0,1);
                    imagen11.setImageResource(cartas[10]);
                    imagenes_seleccionadas[turno] = cartas[10];
                    cartas_seleccionadas[turno] = 10;
                    imagen11.setEnabled(false);
                    break;
                case R.id.img12:
                    sonido.play(click,1,1,0,0,1);
                    imagen12.setImageResource(cartas[11]);
                    imagenes_seleccionadas[turno] = cartas[11];
                    cartas_seleccionadas[turno] = 11;
                    imagen12.setEnabled(false);
                    break;
                case R.id.img13:
                    sonido.play(click,1,1,0,0,1);
                    imagen13.setImageResource(cartas[12]);
                    imagenes_seleccionadas[turno] = cartas[12];
                    cartas_seleccionadas[turno] = 12;
                    imagen13.setEnabled(false);
                    break;
                case R.id.img14:
                    sonido.play(click,1,1,0,0,1);
                    imagen14.setImageResource(cartas[13]);
                    imagenes_seleccionadas[turno] = cartas[13];
                    cartas_seleccionadas[turno] = 13;
                    imagen14.setEnabled(false);
                    break;
                case R.id.img15:
                    sonido.play(click,1,1,0,0,1);
                    imagen15.setImageResource(cartas[14]);
                    imagenes_seleccionadas[turno] = cartas[14];
                    cartas_seleccionadas[turno] = 14;
                    imagen15.setEnabled(false);
                    break;
                case R.id.img16:
                    sonido.play(click,1,1,0,0,1);
                    imagen16.setImageResource(cartas[15]);
                    imagenes_seleccionadas[turno] = cartas[15];
                    cartas_seleccionadas[turno] = 15;
                    imagen16.setEnabled(false);
                    break;
                case R.id.btn_atras2:
                    mensaje().show();
                    break;
                case R.id.btn_terminar:
                    Toast.makeText(getApplicationContext(), "Estoy aceptando el click", Toast.LENGTH_SHORT).show();
                    break;
            }
            if(turno == 0){
                turno = 1;
            }else {
                new Secuencia().execute();
                turno = 0;
            }
        }
    };

    class Secuencia extends AsyncTask<Void,Integer,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imagen1.setEnabled(false);
            imagen2.setEnabled(false);
            imagen3.setEnabled(false);
            imagen4.setEnabled(false);
            imagen5.setEnabled(false);
            imagen6.setEnabled(false);
            imagen7.setEnabled(false);
            imagen8.setEnabled(false);
            imagen9.setEnabled(false);
            imagen10.setEnabled(false);
            imagen11.setEnabled(false);
            imagen12.setEnabled(false);
            imagen13.setEnabled(false);
            imagen14.setEnabled(false);
            imagen15.setEnabled(false);
            imagen16.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(imagenes_seleccionadas[0] == imagenes_seleccionadas[1]){
                cartas_final[cartas_seleccionadas[0]] = 1;
                cartas_final[cartas_seleccionadas[1]] = 1;

                parejas.setText(++numero+"/8");
                puntos.setText(++numero2+"");
                ganador++;

                if (ganador == 8) {
                    Toast.makeText(getApplicationContext(), "!Encontro las 8 parejas¡", Toast.LENGTH_SHORT).show();
                }//Aqui se van a a cambiar los iconos
            }if (cartas_final[0] == 0) {
                imagen1.setImageResource(R.drawable.carta_icon);
                imagen1.setEnabled(true);
            }if (cartas_final[1] == 0) {
                imagen2.setImageResource(R.drawable.carta_icon);
                imagen2.setEnabled(true);
            }if (cartas_final[2] == 0) {
                imagen3.setImageResource(R.drawable.carta_icon);
                imagen3.setEnabled(true);
            }if (cartas_final[3] == 0) {
                imagen4.setImageResource(R.drawable.carta_icon);
                imagen4.setEnabled(true);
            }if (cartas_final[4] == 0) {
                imagen5.setImageResource(R.drawable.carta_icon);
                imagen5.setEnabled(true);
            }if (cartas_final[5] == 0) {
                imagen6.setImageResource(R.drawable.carta_icon);
                imagen6.setEnabled(true);
            }if (cartas_final[6] == 0) {
                imagen7.setImageResource(R.drawable.carta_icon);
                imagen7.setEnabled(true);
            }if (cartas_final[7] == 0) {
                imagen8.setImageResource(R.drawable.carta_icon);
                imagen8.setEnabled(true);
            }if (cartas_final[8] == 0) {
                imagen9.setImageResource(R.drawable.carta_icon);
                imagen9.setEnabled(true);
            }if (cartas_final[9] == 0) {
                imagen10.setImageResource(R.drawable.carta_icon);
                imagen10.setEnabled(true);
            }if (cartas_final[10] == 0) {
                imagen11.setImageResource(R.drawable.carta_icon);
                imagen11.setEnabled(true);
            }if (cartas_final[11] == 0) {
                imagen12.setImageResource(R.drawable.carta_icon);
                imagen12.setEnabled(true);
            }if (cartas_final[12] == 0) {
                imagen13.setImageResource(R.drawable.carta_icon);
                imagen13.setEnabled(true);
            }if (cartas_final[13] == 0) {
                imagen14.setImageResource(R.drawable.carta_icon);
                imagen14.setEnabled(true);
            }if (cartas_final[14] == 0) {
                imagen15.setImageResource(R.drawable.carta_icon);
                imagen15.setEnabled(true);
            }if (cartas_final[15] == 0) {
                imagen16.setImageResource(R.drawable.carta_icon);
                imagen16.setEnabled(true);
            }
            cartas_seleccionadas[0] = 15;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt("Turno", turno);
        estado.putInt("Ganador", ganador);
        estado.putIntArray("Cartas", cartas);
        estado.putIntArray("Cartas final", cartas_final);
        estado.putIntArray("Cartas seleccionadas", cartas_seleccionadas);
        estado.putIntArray("Imagenes seleccionadas", imagenes_seleccionadas);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cartas = savedInstanceState.getIntArray("Cartas");
        cartas_final = savedInstanceState.getIntArray("Cartas final");
        cartas_seleccionadas = savedInstanceState.getIntArray("Cartas seleccionadas");
        imagenes_seleccionadas = savedInstanceState.getIntArray("Imagenes seleccionadas");
        turno = savedInstanceState.getInt("Turno");
        ganador = savedInstanceState.getInt("Ganador");

        if(cartas_final[0] == 1 || cartas_seleccionadas[0]==0){
            imagen1.setImageResource(cartas[0]);
            imagen1.setEnabled(false);
        }if(cartas_final[1] == 1 || cartas_seleccionadas[0]==1){
            imagen2.setImageResource(cartas[1]);
            imagen2.setEnabled(false);
        }if(cartas_final[2] == 1 || cartas_seleccionadas[0]==2){
            imagen3.setImageResource(cartas[2]);
            imagen3.setEnabled(false);
        }if(cartas_final[3] == 1 || cartas_seleccionadas[0]==3){
            imagen4.setImageResource(cartas[3]);
            imagen4.setEnabled(false);
        }if(cartas_final[4] == 1 || cartas_seleccionadas[0]==4){
            imagen5.setImageResource(cartas[4]);
            imagen5.setEnabled(false);
        }if(cartas_final[5] == 1 || cartas_seleccionadas[0]==5){
            imagen6.setImageResource(cartas[5]);
            imagen6.setEnabled(false);
        }if(cartas_final[6] == 1 || cartas_seleccionadas[0]==6){
            imagen7.setImageResource(cartas[6]);
            imagen7.setEnabled(false);
        }if(cartas_final[7] == 1 || cartas_seleccionadas[0]==7){
            imagen8.setImageResource(cartas[7]);
            imagen8.setEnabled(false);
        }if(cartas_final[8] == 1 || cartas_seleccionadas[0]==8){
            imagen9.setImageResource(cartas[8]);
            imagen9.setEnabled(false);
        }if(cartas_final[9] == 1 || cartas_seleccionadas[0]==9) {
            imagen10.setImageResource(cartas[9]);
            imagen10.setEnabled(false);
        }if(cartas_final[10] == 1 || cartas_seleccionadas[0]==10){
            imagen11.setImageResource(cartas[10]);
            imagen11.setEnabled(false);
        }if(cartas_final[11] == 1 || cartas_seleccionadas[0]==11){
            imagen12.setImageResource(cartas[11]);
            imagen12.setEnabled(false);
        }if(cartas_final[12] == 1 || cartas_seleccionadas[0]==12){
            imagen13.setImageResource(cartas[12]);
            imagen13.setEnabled(false);
        }if(cartas_final[13] == 1 || cartas_seleccionadas[0]==13){
            imagen14.setImageResource(cartas[13]);
            imagen14.setEnabled(false);
        }if(cartas_final[14] == 1 || cartas_seleccionadas[0]==14){
            imagen15.setImageResource(cartas[14]);
            imagen15.setEnabled(false);
        }if(cartas_final[15] == 1 || cartas_seleccionadas[0]==15){
            imagen16.setImageResource(cartas[15]);
            imagen16.setEnabled(false);
        }
    }

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
