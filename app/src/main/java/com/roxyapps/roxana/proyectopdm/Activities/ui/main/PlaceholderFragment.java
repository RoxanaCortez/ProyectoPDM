package com.roxyapps.roxana.proyectopdm.Activities.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionFinal;
import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionInformacion;
import com.roxyapps.roxana.proyectopdm.Fragments.InstruccionIniciar;
import com.roxyapps.roxana.proyectopdm.Fragments.Introduccion;
import com.roxyapps.roxana.proyectopdm.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static Fragment newInstance(int index) {
        Fragment fragment = null;

        switch (index){
            case 1: fragment = new Introduccion();
            break;
            case 2: fragment = new InstruccionAyuda();
            break;
            case 3: fragment = new InstruccionFinal();
            break;
            case 4: fragment = new InstruccionInformacion();
            break;
            case 5: fragment = new InstruccionIniciar();
            break;
            case 6: fragment = new InstruccionNickName();
            break;
            case 7: fragment = new InstruccionRanKing();
            break;
            case 8: fragment = new InstruccionAjustes();
            break;
        }

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contenedor_instrucciones, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}