package com.unaidarioefra;

public class Entidad extends Objeto {
    protected int salud;
    protected int ataque;
    protected int evasion;
    protected int defensa;

    public Entidad(TipoObjeto tipo ,int salud, int ataque, int evasion, int defensa) {
        super(tipo);
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

    public int getEvasion() {
        return this.evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
}
