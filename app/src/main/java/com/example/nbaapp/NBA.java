package com.example.nbaapp;

import java.io.Serializable;

public class NBA implements Serializable {
    private String id;
    private String equipo;
    private String ciudad;
    private int anyof;
    private String pabellon;
    private String imagenurl;
    private String palmares;

    public NBA() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getAnyof() {
        return anyof;
    }

    public void setAnyof(int anyof) {
        this.anyof = anyof;
    }

    public String getPabellon() {
        return pabellon;
    }

    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getPalmares() {
        return palmares;
    }

    public void setPalmares(String palmares) {
        this.palmares = palmares;
    }
}
