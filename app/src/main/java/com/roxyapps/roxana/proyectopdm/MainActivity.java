package com.roxyapps.roxana.proyectopdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.markushi.ui.CircleButton;

public class MainActivity extends AppCompatActivity {

    CircleButton parents_btn, games_btn, about_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parents_btn = findViewById(R.id.btn_parents);
        games_btn = findViewById(R.id.btn_games);
        about_btn = findViewById(R.id.btn_about);

        parents_btn.setOnClickListener(clickListener);
        games_btn.setOnClickListener(clickListener);
        about_btn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_parents:
                    Intent intent_parents = new Intent(MainActivity.this, Parents.class);
                    startActivity(intent_parents);
                break;
                case R.id.btn_games:
                    Intent intent_games = new Intent(MainActivity.this, Games.class);
                    startActivity(intent_games);
                    break;
                case R.id.btn_about:
                    Intent intent_about = new Intent(MainActivity.this, About.class);
                    startActivity(intent_about);
                    break;
            }
        }
    };
}
