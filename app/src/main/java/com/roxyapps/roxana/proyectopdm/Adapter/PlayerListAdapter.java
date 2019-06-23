package com.roxyapps.roxana.proyectopdm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;
import com.roxyapps.roxana.proyectopdm.R;

import java.util.Collections;
import java.util.List;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder> {

    class PlayerViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView juego;
        private final TextView puntos;
        private final TextView fecha;
        private final TextView tiempo;

        private PlayerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.id_nombre);
            juego = itemView.findViewById(R.id.id_juego);
            puntos = itemView.findViewById(R.id.id_puntos);
            fecha = itemView.findViewById(R.id.id_fecha);
            tiempo = itemView.findViewById(R.id.id_hora);
        }
    }

    private final LayoutInflater mInflater;
    private List<Player> mPlayer = Collections.emptyList(); // Cached copy of words

    public PlayerListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.player_cardview, parent, false);
        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        Player current = mPlayer.get(position);
        holder.nombre.setText(current.getNombre());
        holder.juego.setText(current.getJuego());
        holder.puntos.setText(current.getPuntos());
        holder.fecha.setText(current.getFecha());
        holder.tiempo.setText(current.getHora());

    }

    void setPlayers(List<Player> players) {
        mPlayer = players;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mPlayer.size();
    }
}
