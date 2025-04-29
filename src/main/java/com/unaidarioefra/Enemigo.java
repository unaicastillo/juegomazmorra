package com.unaidarioefra;

// La clase Enemigo hereda de Entidad
public class Enemigo extends Entidad {

    // Constructor: crea un nuevo enemigo con los valores iniciales
    public Enemigo(int salud, int ataque, int defensa, int evasion) {
        super(salud, ataque, defensa, evasion);
    }
}