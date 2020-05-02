/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

import com.listase.excepciones.InfanteExcepcion;
import com.listase.excepciones.pilotoException;
import com.listase.modelo.Infante;
import com.listase.modelo.NodoDE;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author sebas
 */
public class listaDEmotoGp implements Serializable {

    private nodoMtogoGp cabeza;

    public listaDEmotoGp() {
    }

    public nodoMtogoGp getCabeza() {
        return cabeza;
    }

    public void setCabeza(nodoMtogoGp cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodo(pilotosmotogp Pilotos) {
        if (cabeza == null) {
            cabeza = new nodoMtogoGp(Pilotos);
        } else {
            nodoMtogoGp temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new nodoMtogoGp(Pilotos));
            temp.getSiguiente().setAnterior(temp);
        }
    }

    public void adicionarNodoAlInicio(pilotosmotogp pilotos) {
        if (cabeza == null) {
            cabeza = new nodoMtogoGp(pilotos);
        } else {
            nodoMtogoGp temp = new nodoMtogoGp(pilotos);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        }
    }

    public short contarNodos() {
        if (cabeza == null) {
            return 0;
        } else {
            nodoMtogoGp temp = cabeza;
            short cont = 1;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }

    public String obtenerListadoPilotos() {
        return listarPilotos("");
    }

    public String listarPilotos(String listado) {
        if (cabeza != null) {
            nodoMtogoGp temp = cabeza;
            while (temp != null) {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }
            return listado;
        }
        return "no hay infantes";
    }

    public List obtenerListaPilotos() {
        List<pilotosmotogp> listado = new ArrayList<>();
        listarPilotos(listado);
        return listado;

    }

    public void listarPilotos(List listado) {
        if (cabeza != null) {
            nodoMtogoGp temp = cabeza;
            while (temp != null) {
                listado.add(temp.getDato());
                temp = temp.getSiguiente();
            }
        }
    }

    public void invertirPosiciones() {
        if (cabeza != null) {
            listaDEmotoGp listaTeGp = new listaDEmotoGp();
            nodoMtogoGp temp = cabeza;
            while (temp != null) {
                listaTeGp.adicionarNodoAlInicio(temp.getDato());
                temp = temp.getSiguiente();
            }
            cabeza = listaTeGp.getCabeza();
        }
    }

//    public short contarInfantesxGenero(boolean genero) {
//        if (cabeza == null) {
//            return 0;
//        } else {
//            //llamar a mi ayudante
//            NodoDE temp = cabeza;
//            short cont = 0;
//            while (temp != null) {
//                if (temp.getDato().isGenero() == genero) {
//                    cont++;
//                }
//                temp = temp.getSiguiente();
//
//            }
//            return cont;
//        }
//    }
    public void eliminarPiloto(short codigo) throws pilotoException {

        if (cabeza != null) {
            if (cabeza.getDato().getNumeroPiloto() == codigo) {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
                return;
            } else {
                nodoMtogoGp temp = cabeza;
                while (temp.getSiguiente() != null) {
                    if (temp.getSiguiente().getDato().getNumeroPiloto() == codigo) {
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if (temp.getSiguiente() != null) {
                            temp.getSiguiente().setAnterior(temp);
                            return;
                        }
                    }
                    temp = temp.getSiguiente();
                }
                throw new pilotoException("el codigo" + codigo + "no existe en la lista");

            }
        }

        throw new pilotoException(
                "la lista de pilotos esta vacia");
    }

    public pilotosmotogp obtenerPiloto(short codigo) throws InfanteExcepcion, pilotoException {
        if (cabeza != null) {
            if (cabeza.getDato().getNumeroPiloto() == codigo) {
                return cabeza.getDato();
            } else {
                nodoMtogoGp temp = cabeza;
                while (temp != null) {
                    if (temp.getDato().getNumeroPiloto() == codigo) {
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }

                throw new pilotoException("el codigo" + codigo + "no existe en la lista");
            }
        }
        throw new pilotoException("");
    }
}
