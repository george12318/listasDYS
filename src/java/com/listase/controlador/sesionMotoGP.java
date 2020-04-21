/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listade.modelo.motogp.listaDEmotoGp;
import com.listade.modelo.motogp.nodoMtogoGp;
import com.listade.modelo.motogp.pilotosmotogp;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.diagram.DefaultDiagramModel;

/**
 *
 * @author sebas
 */
@ManagedBean
@RequestScoped
public class sesionMotoGP implements Serializable {

    private listaDEmotoGp listaPilotos;
    private pilotosmotogp piloto;
    private String alInicio = "1";
    private boolean deshabilitarFormulario = true;
    private nodoMtogoGp ayudante;
    private String textoVista = "grafico";

    private List listadoPilotos;

    private DefaultDiagramModel model;

    private short numeroEliminar;

    private short pilotoSelect;

    private pilotosmotogp diagramaPiloto;

    
    public sesionMotoGP() {
    }
    


    


    
}
