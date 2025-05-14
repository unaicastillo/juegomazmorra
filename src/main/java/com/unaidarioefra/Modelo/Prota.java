package com.unaidarioefra.Modelo;

public class Prota {
    public int vida;
    public int ataque;
    public int defensa;
    public int evasion;
    public int velocidad;
    public int posicionX;
    public int posicionY;
    public Prota(int vida, int ataque, int defensa, int evasion, int velocidad) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.evasion = evasion;
        this.velocidad = velocidad;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        
        if (vida < 0|| vida > 20) {
            this.vida=15;
        }
        this.vida = vida;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        
        if (ataque < 0|| ataque > 20) {
            this.ataque=15;
        }
        this.ataque =ataque ;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        if (defensa< 0|| defensa> 20) {
            this.defensa=15;
        }
        this.defensa = defensa;
    }
    public int getEvasion() {
        return evasion;
    }
    public void setEvasion(int evasion) {
        if (evasion < 0|| evasion > 20) {
            this.evasion=15;
        }
        this.evasion = evasion;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        if (velocidad< 0|| velocidad> 20) {
            this.velocidad=15;
        }
        
        this.velocidad = velocidad;
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return this.posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }


    //Metodo por el cual un enemigo ataca al protagonista donde el daño del enemigo = damage
    public void atacado(int damage){
        if (defensa>=damage){
            defensa-=damage;
            vida = restarVida(vida, (damage/2));
        }
        else{
            vida = restarVida( vida, ((damage-defensa)+(defensa/2)) );
            defensa = 0;
        }
    }

    //Comprobar que la vida restada no sea menor que 0
    public int restarVida(int vida, int damage){
        if(damage >= vida){
            return 0;
        }
        else{
            return vida-damage;
        }
    }
}
