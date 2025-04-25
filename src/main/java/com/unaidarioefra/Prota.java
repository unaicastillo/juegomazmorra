package com.unaidarioefra;

// La clase Protagonista hereda de Personaje
public class Prota extends Personaje {

    // Atributos del personaje con sus rangos específicos
    private int salud;    // debe estar entre 1 y 20
    private int ataque;   // debe estar entre 1 y 20
    private int defensa;  // debe estar entre 0 y 100
    private int evasion;  // debe estar entre 0 y 100

    // Constructor: crea un nuevo protagonista con los valores iniciales
    public Prota(int salud, int ataque, int defensa, int evasion) {
        setSalud(salud);       // se valida al asignar
        setAtaque(ataque);     // se valida al asignar
        setDefensa(defensa);   // se valida al asignar
        setEvasion(evasion);   // se valida al asignar
    }

    // Métodos "getter" (obtener) y "setter" (asignar) para cada atributo
    // Incluyen validaciones para asegurarse de que los valores estén dentro de los límites permitidos

    public int getSalud() { return salud; }

    public void setSalud(int salud) {
        if (salud >= 1 && salud <= 20)
            this.salud = salud;
        else
            throw new IllegalArgumentException("Salud debe estar entre 1 y 20.");
    }

    public int getAtaque() { return ataque; }

    public void setAtaque(int ataque) {
        if (ataque >= 1 && ataque <= 20)
            this.ataque = ataque;
        else
            throw new IllegalArgumentException("Ataque debe estar entre 1 y 20.");
    }

    public int getDefensa() { return defensa; }

    public void setDefensa(int defensa) {
        if (defensa >= 0 && defensa <= 20)
            this.defensa = defensa;
        else
            throw new IllegalArgumentException("Defensa debe estar entre 0 y 100.");
    }

    public int getEvasion() { return evasion; }

    public void setEvasion(int evasion) {
        if (evasion >= 0 && evasion <= 20)
            this.evasion = evasion;
        else
            throw new IllegalArgumentException("Evasión debe estar entre 0 y 100.");
    }

    // Método que devuelve una representación en texto del objeto protagonista
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