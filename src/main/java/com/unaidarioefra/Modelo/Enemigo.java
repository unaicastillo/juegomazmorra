package com.unaidarioefra.Modelo;

import java.util.HashMap;

public class Enemigo {
    private int tipo;
    private int vida;
    private int ataque;
    private int defensa;
    private int evasion;
    private int velocidad;
    private int posicionX;
    private int posicionY;

    public Enemigo(int tipo, int vida, int ataque, int defensa, int evasion, int velocidad, int posicionX, int posicionY) {
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
        this.velocidad = velocidad;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    // Constructor simplificado para inicialización básica
    public Enemigo(int tipo, int posicionX, int posicionY) {
        this.tipo = tipo;
        this.vida = 100;
        this.ataque = 10;
        this.defensa = 5;
        this.evasion = 3;
        this.velocidad = 2;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Enemigo(HashMap<String, Integer> atributos) {
        this.vida = atributos.getOrDefault("SALUD", 0);
        this.ataque = atributos.getOrDefault("ATAQUE", 0);
        this.defensa = atributos.getOrDefault("DEFENSA", 0);
        this.evasion = atributos.getOrDefault("EVASION", 0);
        this.velocidad = atributos.getOrDefault("PERCEPCION", 0);
        this.posicionX = 0;
        this.posicionY = 0;
    }

    // Getters y setters
    public int getTipo() { 
        return tipo; 
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

    public int getPosicionX() {
         return posicionX; 
        }

    public void setPosicionX(int posicionX) {
         this.posicionX = posicionX; 
        }

    public int getPosicionY() {
         return posicionY; 
        }

    public void setPosicionY(int posicionY) {
         this.posicionY = posicionY; 
        }
}
