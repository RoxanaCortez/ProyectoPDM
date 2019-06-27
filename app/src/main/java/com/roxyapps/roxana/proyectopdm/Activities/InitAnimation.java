package com.roxyapps.roxana.proyectopdm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.roxyapps.roxana.proyectopdm.R;

public class InitAnimation extends AppCompatActivity {
    private static  int TIMEOUT = 4000;
    private ImageView logo;
    private Animation animation;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_animation);

        //creando transision fade entre las dos primeras actividades
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(InitAnimation.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, TIMEOUT);


        //agregando sonido a la animacion inicial
        MediaPlayer mp = MediaPlayer.create(this, R.raw.skyclad_sound_notification_tone_bell_x2_ascend_fifth_positive_278);
        mp.start();

        logo = (ImageView)findViewById(R.id.img_splash);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        logo.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
