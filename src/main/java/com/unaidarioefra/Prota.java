package com.unaidarioefra;

// La clase Protagonista hereda de Entidad
public class Prota extends Entidad {

    // Constructor: crea un nuevo protagonista con los valores iniciales
    public Prota(String tipo, int salud, int ataque, int defensa, int evasion) {
        super(tipo, salud, ataque, defensa, evasion);
    }
}