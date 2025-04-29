package com.unaidarioefra;

// La clase Protagonista hereda de Personaje
public class Prota extends Personaje {

    // Atributos del personaje con sus rangos específicos
    private int salud;    // debe estar entre 1 y 20
    private int ataque;   // debe estar entre 1 y 20
    private int defensa;  // debe estar entre 0 y 20
    private int evasion;  // debe estar entre 0 y 20

    // Constructor: crea un nuevo protagonista con los valores iniciales
    public Prota(int salud, int ataque, int defensa, int evasion) {
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
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