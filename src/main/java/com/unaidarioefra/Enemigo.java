package com.unaidarioefra;

import java.util.HashMap;

public class Enemigo {
    private int vida;
    private int ataque;
    private int defensa;
    private int evasion;
    private int velocidad;
    private int[][] mapa;
    private int posicionX;
    private int posicionY;

    public Enemigo(int vida, int ataque, int defensa, int evasion, int velocidad) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
        this.velocidad = velocidad;
    }

    public Enemigo(HashMap<String, Integer> atributos) {
        this.vida = atributos.getOrDefault("SALUD", 0);
        this.ataque = atributos.getOrDefault("ATAQUE", 0);
        this.defensa = atributos.getOrDefault("DEFENSA", 0);
        this.evasion = atributos.getOrDefault("EVASION", 0);
        this.velocidad = atributos.getOrDefault("PERCEPCION", 0);
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getVelocidad() {
        return velocidad;
    }

}
