package com.rm.Sign.models;

import java.util.ArrayList;

/**
 * Created by Eric Freitez on 25/04/2017.
 */

public class Proyecto {


    private String nombreEmpresa;
    private String nombreProyecto;
    private String direccionEmpresa;
    private String fechaProyecto;



    public Proyecto() {

    }

    public Proyecto(String nombreEmpresa, String nombreProyecto, String direccionEmpresa, String fechaProyecto) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreProyecto = nombreProyecto;
        this.direccionEmpresa = direccionEmpresa;
        this.fechaProyecto = fechaProyecto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getFechaProyecto() {
        return fechaProyecto;
    }

    public void setFechaProyecto(String fechaProyecto) {
        this.fechaProyecto = fechaProyecto;
    }



    public ArrayList<Proyecto> cargarData(){
        ArrayList<Proyecto> itemsProyectos = new ArrayList<>();

        itemsProyectos.add(new Proyecto("Tubrica", "Limpieza de Maquinaria Embolsadora","Zona Industrial Galpon 20","17/04/17"));
        itemsProyectos.add(new Proyecto("Nestle", "Recostruccion Maquinaria","Zona Industrial IV con Avenida","25/04/17"));
        itemsProyectos.add(new Proyecto("Cartepila", "Mantenimiento General a Tuberias","Avenida 20 con 36","01/05/17"));
        itemsProyectos.add(new Proyecto("Covencaucho", "Mantenimiento Maquinaria General","Avenida 100 con 50","07/05/17"));

        return itemsProyectos;

    }

}

