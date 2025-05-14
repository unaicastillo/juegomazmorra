package com.unaidarioefra.Modelo;

import java.util.HashMap;

public class Enemigo {
    private int tipo;
    private int vida;
    private int ataque;
    private int defensa;
    private int evasion;
    private int velocidad;
    private int percepcion;
    private int posicionX;
    private int posicionY;

    public Enemigo(int tipo, int vida, int ataque, int defensa, int evasion, int velocidad, int percepcion, int posicionX, int posicionY) {
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
        this.velocidad = velocidad;
        this.percepcion = percepcion;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Enemigo(HashMap<String, Integer> atributos) {
        this.vida = atributos.getOrDefault("SALUD", 0);
        this.ataque = atributos.getOrDefault("ATAQUE", 0);
        this.defensa = atributos.getOrDefault("DEFENSA", 0);
        this.evasion = atributos.getOrDefault("EVASION", 0);
        this.velocidad = atributos.getOrDefault("PERCEPCION", 0);
        this.posicionX = 0; // Inicializa la posición X
        this.posicionY = 0; // Inicializa la posición Y
    }

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

    public int getPercepcion(){
        return percepcion;
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


    public void atacado(int damage){
        if (defensa>=damage){
            defensa-=damage;
            vida = restarVida(vida, (damage/2));
        }
        else{
            vida = restarVida( vida, ((damage-defensa)+(defensa/2)) );
            defensa = 0;
        }
    }

    public int restarVida(int vida, int damage){
        if(damage >= vida){
            return 0;
        }
        else{
            return vida-damage;
        }
    }

    public boolean detectarProtagonista(int[] posicionPrtota){
        //Si la posición del protagonista se encuentra a una menor o igual distancia que el radio de vision (percepción)
        //devuelve true, para inicializar el metodo perseguir
        
        if ( percepcion >= Math.sqrt(Math.pow(posicionPrtota[0] - posicionX, 2) + Math.pow(posicionPrtota[1] - posicionY, 2))){
            // radio de vision >= distancia entre el enemigo y el protagonista
            return true;
        }
        else return false;
    }

}
