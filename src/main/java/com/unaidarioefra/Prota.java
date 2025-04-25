package com.unaidarioefra;

public class Prota extends Personaje {
    private int salud;
    private int ataque;
    private int defensa;
    private int evasion;

    public Prota(int salud, int ataque, int defensa, int evasion) {
        setSalud(salud);
        setAtaque(ataque);
        setDefensa(defensa);
        setEvasion(evasion);
    }

    public int getSalud() { return salud; }
    public void setSalud(int salud) {
        if (salud >= 1 && salud <= 20) this.salud = salud;
        else throw new IllegalArgumentException("Salud debe estar entre 1 y 20.");
    }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) {
        if (ataque >= 1 && ataque <= 20) this.ataque = ataque;
        else throw new IllegalArgumentException("Ataque debe estar entre 1 y 20.");
    }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) {
        if (defensa >= 0 && defensa <= 100) this.defensa = defensa;
        else throw new IllegalArgumentException("Defensa debe estar entre 0 y 100.");
    }

    public int getEvasion() { return evasion; }
    public void setEvasion(int evasion) {
        if (evasion >= 0 && evasion <= 100) this.evasion = evasion;
        else throw new IllegalArgumentException("Evasión debe estar entre 0 y 100.");
    }

    @Override
    public String toString() {
        return "Protagonista{" +
                "salud=" + salud +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", evasion=" + evasion +
                '}';
    }
}
