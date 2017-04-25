package com.rm.Sign.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rm.Sign.R;
import com.rm.Sign.models.Proyecto;

import java.util.List;

/**
 * Created by Eric Freitez on 25/04/2017.
 */

public class ProyectosAdapterPendientes extends RecyclerView.Adapter<ProyectosAdapterPendientes.ProyectosViewHolder>{

    private List<Proyecto> itemsProyectos;


    public static class ProyectosViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreEmpresa;
        public TextView nombreProyecto;
        public TextView direccionEmpresa;
        public TextView fechaProyecto;


        public CardView card_view;


        public ProyectosViewHolder(View v) {
            super(v);

            nombreEmpresa = (TextView) v.findViewById( R.id.nombre_empresa);
            nombreProyecto = (TextView) v.findViewById(R.id.nombre_proyecto);
            direccionEmpresa = (TextView) v.findViewById(R.id.direccion_empresa);
            fechaProyecto = (TextView) v.findViewById(R.id.fecha_proyecto);


        }
    }

    public ProyectosAdapterPendientes(List<Proyecto> items) {
        this.itemsProyectos = items;
    }


    public ProyectosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_proyectos, parent, false);


        return new ProyectosViewHolder(v);

    }


    public void onBindViewHolder(ProyectosViewHolder holder, int position) {

        holder.nombreEmpresa.setText(String.valueOf(itemsProyectos.get(position).getNombreEmpresa()));
        holder.nombreProyecto.setText(String.valueOf(itemsProyectos.get(position).getNombreProyecto()));
        holder.direccionEmpresa.setText(String.valueOf(itemsProyectos.get(position).getDireccionEmpresa()));
        holder.fechaProyecto.setText(String.valueOf(itemsProyectos.get(position).getFechaProyecto()));

    }


    public int getItemCount() {
        return itemsProyectos.size();
    }



}
