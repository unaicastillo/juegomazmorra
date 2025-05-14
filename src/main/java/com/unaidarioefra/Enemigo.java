package com.unaidarioefra;

// La clase Enemigo hereda de Entidad
public class Enemigo  {

    private int tipo;
    private int salud;
    private int ataque;
    private int defensa;
    private int evasion;
    private int percepcion;
    private int posicionX;
    private int posicionY;

    // Constructor principal
    public Enemigo(int tipo, int salud, int ataque, int defensa, int evasion, int percepcion, int posicionX, int posicionY) {
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
        this.percepcion = percepcion;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    // Getters y setters
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
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

    // Métodos de comportamiento
    public void moverErraticamente() {
        // Lógica para mover al enemigo de forma errática
    }

    public void perseguir(int protaX, int protaY) {
        // Lógica para perseguir al protagonista si está dentro del rango de percepción
    }
}