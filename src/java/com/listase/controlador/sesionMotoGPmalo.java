/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listade.modelo.motogp.listaDEmotoGp;
import com.listade.modelo.motogp.nodoMtogoGp;
import com.listade.modelo.motogp.pilotosmotogp;
import com.listase.excepciones.InfanteExcepcion;
import com.listase.excepciones.pilotoException;
import com.listase.modelo.Infante;
import com.listase.modelo.NodoDE;
import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author sebas
 */
@ManagedBean
@RequestScoped
public class sesionMotoGPmalo implements Serializable {

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

    public sesionMotoGPmalo() {
    }

    public listaDEmotoGp getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(listaDEmotoGp listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public pilotosmotogp getPiloto() {
        return piloto;
    }

    public void setPiloto(pilotosmotogp piloto) {
        this.piloto = piloto;
    }

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

    public nodoMtogoGp getAyudante() {
        return ayudante;
    }

    public void setAyudante(nodoMtogoGp ayudante) {
        this.ayudante = ayudante;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public List getListadoPilotos() {
        return listadoPilotos;
    }

    public void setListadoPilotos(List listadoPilotos) {
        this.listadoPilotos = listadoPilotos;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public short getNumeroEliminar() {
        return numeroEliminar;
    }

    public void setNumeroEliminar(short numeroEliminar) {
        this.numeroEliminar = numeroEliminar;
    }

    public short getPilotoSelect() {
        return pilotoSelect;
    }

    public void setPilotoSelect(short pilotoSelect) {
        this.pilotoSelect = pilotoSelect;
    }

    public pilotosmotogp getDiagramaPiloto() {
        return diagramaPiloto;
    }

    public void setDiagramaPiloto(pilotosmotogp diagramaPiloto) {
        this.diagramaPiloto = diagramaPiloto;
    }

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flowlabel", 0.5));
        }
        return conn;
    }

    public void guargarPiloto() {
        piloto.setNumeroPiloto((short) (listaPilotos.contarNodos() + 1));
        if (alInicio.compareTo("1") == 0) {
            listaPilotos.adicionarNodoAlInicio(piloto);
        } else {
            listaPilotos.adicionarNodo(piloto);
        }

        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
        deshabilitarFormulario = true;
        JsfUtil.addSuccessMessage("el infante se ha guardado");
    }

        public void habilitarFormulario() {
            deshabilitarFormulario = false;
            piloto = new pilotosmotogp();
        }

    public void ponerPilotoPrimero() {
        if (listaPilotos.getCabeza() != null) {
            ayudante = listaPilotos.getCabeza();
            piloto = ayudante.getDato();
        } else {
            piloto = new pilotosmotogp();
        }
        listadoPilotos = listaPilotos.obtenerListaPilotos();

    }

    public void ponerPilotoUltimo() {
        if (listaPilotos.getCabeza() != null) {
            while (ayudante.getSiguiente() != null) {
                ayudante = ayudante.getSiguiente();
            }
            piloto = ayudante.getDato();
        }
    }
        public void irposicionAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            piloto = ayudante.getDato();
        }        
    }

    public void irPosicionSiguiente() {
        if (ayudante.getSiguiente() != null) {
            ayudante = ayudante.getSiguiente();
            piloto = ayudante.getDato();
        }
    }

    public void cambiarVistaInfantes() {
        if (textoVista.compareTo("Tabla") == 0) {
            textoVista = "Gráfico";
        } else {
            textoVista = "Tabla";
        }
    }

    public void invertirLista() {
        //Invierte la lista
        listaPilotos.invertirPosiciones();
        ponerPilotoPrimero();
    }

    public void pintarLista() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        if (listaPilotos.getCabeza() != null) {
            //llamo a mi ayudante
            nodoMtogoGp temp = listaPilotos.getCabeza();
            int posX = 2;
            int posY = 2;
            while (temp != null) {
                Element ele = new Element(temp.getDato().getNumeroPiloto() + " "
                        + temp.getDato().getNombre(),
                        posX + "em", posY + "em");
                ele.setId(String.valueOf(temp.getDato().getNumeroPiloto()));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));

                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(ele);
                temp = temp.getSiguiente();
                posX = posX + 5;
                posY = posY + 6;
            }
        }
        for (int i = 0; i < model.getElements().size() - 1; i++) {
            model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1),
                    model.getElements().get(i + 1).getEndPoints().get(0), "Sig"));

            model.connect(createConnection(model.getElements().get(i + 1).getEndPoints().get(2),
                    model.getElements().get(i).getEndPoints().get(3), "Ant"));
        }

    }

    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");

        pilotoSelect = Short.valueOf(id.replaceAll("frmPiloto:diagrama-", ""));

    }

    public void eliminarPiloto() {
        if (numeroEliminar > 0) {
            //llamo el eliminar de la lista
            try {
                listaPilotos.eliminarPiloto(pilotoSelect);
                ponerPilotoPrimero();
                JsfUtil.addSuccessMessage("Infante " + numeroEliminar + " eliminado.");
            } catch (pilotoException e) {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        } else {
            JsfUtil.addErrorMessage("El código a eliminar " + numeroEliminar + " no es válido");
        }
    }

    public void obtenerInfanteDiagrama() throws pilotoException {
        try {
            diagramaPiloto = listaPilotos.obtenerPiloto(pilotoSelect);
        } catch (InfanteExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void enviarAUltimaPosicion() throws pilotoException {
        try {
            pilotosmotogp infTemporal = listaPilotos.obtenerPiloto(pilotoSelect);
            listaPilotos.eliminarPiloto(pilotoSelect);
            listaPilotos.adicionarNodo(infTemporal);

            pintarLista();
        } catch (InfanteExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void enviarAlInicio() throws pilotoException {
        try {
            pilotosmotogp infTemporal = listaPilotos.obtenerPiloto(pilotoSelect);
            listaPilotos.eliminarPiloto(pilotoSelect);
            listaPilotos.adicionarNodoAlInicio(infTemporal);

            pintarLista();
        } catch (InfanteExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    

}
