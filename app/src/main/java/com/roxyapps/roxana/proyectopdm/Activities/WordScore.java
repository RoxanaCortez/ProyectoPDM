package com.roxyapps.roxana.proyectopdm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.roxyapps.roxana.proyectopdm.R;

public class WordScore extends AppCompatActivity {
    ImageButton home,nueva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_score);

        home=findViewById(R.id.btn_home2);
        home.setOnClickListener(clickListener);
        nueva=findViewById(R.id.btn_nueva);
        nueva.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_home2:
                    Intent intent_salir = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent_salir);
                    break;
                case R.id.btn_nueva:
                    Intent intent_nueva = new Intent(getApplicationContext(), WordsGame.class);
                    startActivity(intent_nueva);
                    break;
            }
        }
    };
}
