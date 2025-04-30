package com.unaidarioefra;

public class Objeto {
    protected TipoObjeto tipo;

    public Objeto(TipoObjeto tipo) {
        this.tipo = tipo;
    }

    public TipoObjeto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoObjeto tipo) {
        this.tipo = tipo;
    }

}
