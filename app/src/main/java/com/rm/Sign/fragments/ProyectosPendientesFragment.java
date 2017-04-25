package com.rm.Sign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rm.Sign.R;
import com.rm.Sign.models.Proyecto;
import com.rm.Sign.recyclerview.ProyectosAdapterPendientes;

import java.util.ArrayList;

public class ProyectosPendientesFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    public static ProyectosPendientesFragment newInstance() {
        ProyectosPendientesFragment fragment = new ProyectosPendientesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_proyectos_pendientes, container, false);

        Proyecto proyecto=new Proyecto();
        ArrayList<Proyecto> itemsProyectos;
        itemsProyectos=proyecto.cargarData();

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.recycler_proyectos_pendientes);
        recycler.setHasFixedSize(true);


// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new ProyectosAdapterPendientes(itemsProyectos);
        recycler.setAdapter(adapter);


        return v;
    }

}
