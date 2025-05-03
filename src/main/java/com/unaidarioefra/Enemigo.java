package com.unaidarioefra;

// La clase Enemigo hereda de Entidad
public class Enemigo extends Entidad {

    private int percepcion; //Atributo que representa el rango de visión del enemigo

    // Constructor: crea un nuevo enemigo con los valores iniciales
    public Enemigo(String tipo, int salud, int ataque, int defensa, int evasion, int percepcion) {
        super(tipo, salud, ataque, defensa, evasion);
        this.percepcion=percepcion;
    }


    public int getPercepcion() {
        return this.percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }



    public void errante(){
        /* if( percepcion < distancia )
         * Si el protagonista no esta dentro del rango de visión (percepción) del enemigo
         * Se moverá de forma errática por el mapa
         * 
         * 
         */
    }

    public void perseguir(){
        /* if( percepcion > distancia )
         * Si el protagonista se encuentra dentro del rango de visión del enemigo, este perseguira al jugador.
         */
    }

}