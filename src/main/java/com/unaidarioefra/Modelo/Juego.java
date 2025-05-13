package com.unaidarioefra.Modelo;

import java.util.ArrayList;

public class Juego {
    private static Juego instance;
    private int nivel;

    public static Juego getInstance() {
        if (instance == null) {
            instance = new Juego();
        }
        return instance;
    }


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public GestorMapa getGestorMapas() {
        return new GestorMapa();
    }

    public void iniciarentidades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarentidades'");
    }

    public ArrayList<Enemigo> getEnemigos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEnemigos'");
    }
}
