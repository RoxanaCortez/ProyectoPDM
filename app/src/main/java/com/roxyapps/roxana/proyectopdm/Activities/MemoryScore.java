package com.roxyapps.roxana.proyectopdm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.roxyapps.roxana.proyectopdm.R;

public class MemoryScore extends AppCompatActivity {
    ImageButton home2,nueva2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_score);

        home2=findViewById(R.id.btn_home3);
        home2.setOnClickListener(clickListener);
        nueva2=findViewById(R.id.btn_nueva2);
        nueva2.setOnClickListener(clickListener);
    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_home3:
                    Intent intent_salir = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent_salir);
                    break;
                case R.id.btn_nueva2:
                    Intent intent_nueva = new Intent(getApplicationContext(), WordsGame.class);
                    startActivity(intent_nueva);
                    break;
            }
        }
    };
}
