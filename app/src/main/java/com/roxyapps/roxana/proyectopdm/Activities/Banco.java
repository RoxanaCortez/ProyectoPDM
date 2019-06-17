package com.roxyapps.roxana.proyectopdm.Activities;

import com.roxyapps.roxana.proyectopdm.R;

public class Banco {

    private int fruver [] = {R.drawable.apple_icon, R.drawable.avocado_icon, R.drawable.banana_icon, R.drawable.blueberry_icon,
            R.drawable.broccoli_icon, R.drawable.carrot_icon, R.drawable.cherry_icon, R.drawable.corn_icon, R.drawable.grape_icon,
            R.drawable.lemon_icon, R.drawable.letucce_icon, R.drawable.mango_icon, R.drawable.mushroom_icon, R.drawable.orange_icon,
            R.drawable.watermelon_icon, R.drawable.tomato_icon, R.drawable.strawberry_icon, R.drawable.potato_icon, R.drawable.pineapple_icon};

    public int getFruver(int n){
        return fruver[n];
    }

    private int fruta [] = {R.string.manzana, R.string.aguacate, R.string.banana, R.string.arandano, R.string.brocoli,
            R.string.zanahoria, R.string.cereza, R.string.elote, R.string.uvas, R.string.limon, R.string.lechuga,
            R.string.mango, R.string.hongos, R.string.naranja, R.string.sandia, R.string.tomate, R.string.fresas,
            R.string.papa, R.string.piña};

    public int getFrutas(int n){
        return fruta[n];
    }

    private String option [][] = {{"SA","ZA","CA"}, {"KA","QA","CA"}, {"VA","BA","DA"}, {"RA","RAN","RAM"}, {"BRO","VRO","BRÓ"},
            {"HO","O","OH"}, {"SE","CE","ZE"}, {"HE","EE","E"}, {"SAV","BAS","VAS"}, {"MÓN","NON","MON"},
            {"SHEU","SHU","CHU"}, {"MA","NAN","MAN"}, {"HON","ON","HOM"}, {"NA","RAN","RRAN"}, {"BI","DÍ","DI"},
            {"TO","TOU","TE"}, {"SOS","SAS","ZAZ"}, {"PA","PÁ","PAA"}, {"NA","NAN","ÑA"}};

    private String respuestas[] = {"ZA","CA","BA","RAN","BRO","HO","CE","E","VAS","MÓN","CHU","MAN","HON","NA","DÍ","TO","SAS","PA","ÑA"};

    public String getRespuesta(int n){
        return respuestas[n];
    }

    public String getOpc1(int n) {
        return option[n][0];
    }

    public String getOpc2(int n) {
        return option[n][1];
    }

    public String getOpc3(int n) {
        return option[n][2];
    }

    public int getLongitudOpciones(){
        return fruver.length;
    }

    public int getLongitudFrutas(){
        return fruta.length;
    }

}
