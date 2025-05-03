package com.unaidarioefra;

import java.util.Random;

public class Personaje implements Movement{
    private Random r = new Random();
    private int salud;  //1-20
    private int ataque; //1-20
    private int defensa;//0-100
    private int evasion;//0-60

    public Personaje(){
        this.salud=20;
        this.ataque=20;
        this.defensa=63;
        this.evasion=20;
    }


    public Personaje(int salud, int ataque, int defensa, int evasion) {
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


    @Override
    public void atacar(int damage) {
        //TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'ataque'");

        //1º esquiva el ataque
        if(r.nextInt(101)>=evasion){
            //No ataca
            //Mensaje "Esquivado"
        }
        else {
            if(defensa > damage){
                defensa -= ataque;
                salud = damage/2;
            }
            else{// 
                
                salud = (ataque-defensa)+(defensa/2);
                defensa = 0;
            }
        }


        //  e2.VidaFinal = e2.Vida-e1.ataque/(e2.defensa*0,01+1)
        //  e2 -> atacado     e1 -> atacante
    }




    @Override
    public void movimiento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movimiento'");
    }


    @Override
    public void evasion() { //Si se evade el ataque se llama a evasión para mover al personaje (como si se evadirea el ataque)
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evasion'");
    }



}
