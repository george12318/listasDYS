/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listade.modelo.motogp.pilotosmotogp;

/**
 *
 * @author carloaiza
 */
public class NodoDE {
    private Infante dato;
    private NodoDE siguiente;
    private NodoDE anterior;

    public NodoDE(Infante dato) {
        this.dato = dato;
    }

    public NodoDE(pilotosmotogp Pilotos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Infante getDato() {
        return dato;
    }

    public void setDato(Infante dato) {
        this.dato = dato;
    }

    public NodoDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE anterior) {
        this.anterior = anterior;
    }
    
    
    
}
