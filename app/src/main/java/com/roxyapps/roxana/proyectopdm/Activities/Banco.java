package com.roxyapps.roxana.proyectopdm.Activities;

import com.roxyapps.roxana.proyectopdm.R;

public class Banco {

    private int fruver [] = {
            R.drawable.apple_icon,
            R.drawable.avocado_icon,
            R.drawable.banana_icon,
            R.drawable.blueberry_icon,
            R.drawable.broccoli_icon,
            R.drawable.carrot_icon,
            R.drawable.cherry_icon,
            R.drawable.corn_icon,
            R.drawable.grape_icon,
            R.drawable.lemon_icon,
            R.drawable.letucce_icon,
            R.drawable.mango_icon,
            R.drawable.mushroom_icon,
            R.drawable.orange_icon,
            R.drawable.watermelon_icon,
            R.drawable.tomato_icon,
            R.drawable.strawberry_icon,
            R.drawable.potato_icon,
            R.drawable.pineapple_icon
    };

    private String option [][] = {
            {"SA","ZA","CA"},
            {"KA","QA","CA"},
            {"VA","BA","DA"},
            {"RA","RAN","RAM"},
            {"BRO","VRO","BRÓ"},
            {"HO","O","OH"},
            {"SE","CE","ZE"},
            {"HE","EE","E"},
            {"SAV","BAS","VAS"},
            {"MÓN","NON","MON"},
            {"SHEU","SHU","CHU"},
            {"MA","NAN","MAN"},
            {"HON","ON","HOM"},
            {"NA","RAN","RRAN"},
            {"BI","DÍ","DI"},
            {"TO","TOU","TE"},
            {"SOS","SAS","ZAZ"},
            {"PA","PÁ","PAA"},
            {"NA","NAN","ÑA"}
    };

    private String respuestas[] = {"ZA","CA","BA","RAN","BRO","HO","CE","E","VAS","MÓN","CHU","MAN","HON","NA","DÍ","TO","SAS","PA","ÑA"};


    public String getOpcion1(int a) {
        String opcion = option[a][0];
        return opcion;
    }

    public String getOpcion2(int a) {
        String opcion = option[a][1];
        return opcion;
    }

    public String getOpcion3(int a) {
        String opcion = option[a][2];
        return opcion;
    }

}
