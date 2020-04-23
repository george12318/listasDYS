/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class pilotosmotogp implements Serializable {
    
    private String nombre;
    private short numeroPiloto;
    private byte edad;
    private String paisDeNacimiento;
    private String equipo;

    public pilotosmotogp() {
        this.edad = 1;
    }

    public pilotosmotogp(String nombre, short numeroPiloto, byte edad, String equipo) {
        this.nombre = nombre;
        this.numeroPiloto = numeroPiloto;
        this.edad = edad;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getNumeroPiloto() {
        return numeroPiloto;
    }

    public void setNumeroPiloto(short numeroPiloto) {
        this.numeroPiloto = numeroPiloto;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getCiudadDeNacimiento() {
        return paisDeNacimiento;
    }

    public void setCiudadDeNacimiento(String ciudadDeNacimiento) {
        this.paisDeNacimiento = ciudadDeNacimiento;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
    
    
    

}
