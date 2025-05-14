package com.unaidarioefra.Modelo;

import java.util.ArrayList;

public class Juego {
    private static Juego instance;
    private int nivel;
    private ArrayList<Enemigo> enemigos = new ArrayList<>();

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
        enemigos.clear(); // Reiniciar lista de enemigos al comenzar nuevo mapa

        // Añadir enemigos de ejemplo, puedes personalizar según mapa
        enemigos.add(new Enemigo(2, 5, 5));   // tipo 2 (esbirro)
        enemigos.add(new Enemigo(3, 10, 8));  // tipo 3 (esqueleto)
        enemigos.add(new Enemigo(4, 3, 12));  // tipo 4 (zombie)
    }

    public ArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    public void limpiarEnemigos() {
        enemigos.clear();
    }
}
