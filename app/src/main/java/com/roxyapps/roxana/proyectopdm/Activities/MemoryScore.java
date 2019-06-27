package com.roxyapps.roxana.proyectopdm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.roxyapps.roxana.proyectopdm.R;

public class MemoryScore extends AppCompatActivity {
    ImageButton home2;
    Button nueva2;
    TextView parejas, iparejas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_score);

        home2=findViewById(R.id.btn_home3);
        home2.setOnClickListener(clickListener);
        nueva2=findViewById(R.id.btn_nueva2);
        nueva2.setOnClickListener(clickListener);
        parejas=findViewById(R.id.nparejas);
        iparejas=findViewById(R.id.nfaltantes);

        Intent mIntent = this.getIntent();
        if(mIntent != null){
            parejas.setText(mIntent.getStringExtra(AppConstants.TEXT_PAREJAS));
            iparejas.setText(mIntent.getStringExtra(AppConstants.TEXT_IPAREJAS));
        }
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
                    Intent intent_nueva = new Intent(getApplicationContext(), MemoryGame.class);
                    startActivity(intent_nueva);
                    break;
            }
        }
    };
}
