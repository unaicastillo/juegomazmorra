package com.unaidarioefra;

public class Entidad {
    protected int salud;
    protected int ataque;
    protected int evasion;
    protected int defensa;
    
    public Entidad(int salud, int ataque, int evasion, int defensa) {
        this.salud = salud;
        this.ataque = ataque;
        this.evasion = evasion;
        this.defensa = defensa;
    }

    public int getSalud() {
        return this.salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return this.ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return this.defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getEvasion() {
        return this.evasion;
    }
    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }
}