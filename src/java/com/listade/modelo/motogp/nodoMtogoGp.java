/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

/**
 *
 * @author sebas
 */
public class nodoMtogoGp {
    private pilotosmotogp dato;
    private nodoMtogoGp siguiente;
    private nodoMtogoGp anterior;

    public nodoMtogoGp(pilotosmotogp dato) {
        this.dato = dato;
    }

    public pilotosmotogp getDato() {
        return dato;
    }

    public void setDato(pilotosmotogp dato) {
        this.dato = dato;
    }

    public nodoMtogoGp getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoMtogoGp siguiente) {
        this.siguiente = siguiente;
    }

    public nodoMtogoGp getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoMtogoGp anterior) {
        this.anterior = anterior;
    }
    
    
}
