package com.unaidarioefra;

// La clase Enemigo hereda de Entidad
public class Enemigo extends Entidad {

    // Constructor: crea un nuevo enemigo con los valores iniciales
    public Enemigo(String tipo, int salud, int ataque, int defensa, int evasion) {
        super(tipo, salud, ataque, defensa, evasion);
    }
}