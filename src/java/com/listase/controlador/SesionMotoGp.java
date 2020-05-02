/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
@Named(value = "sesionMotoGp")
@SessionScoped
public class SesionMotoGp implements Serializable {

    /**
     * Creates a new instance of SesionMotoGp
     */
    public SesionMotoGp() {
    }
    
}
