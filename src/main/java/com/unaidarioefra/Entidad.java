package com.unaidarioefra;

public class Entidad {
    protected String tipo;
    protected int salud;
    protected int ataque;
    protected int evasion;
    protected int defensa;
    
    public Entidad(String tipo, int salud, int ataque, int evasion, int defensa) {
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
        this.evasion = evasion;
        this.defensa = defensa;
    }

    public String getTipo(String tipo) {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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