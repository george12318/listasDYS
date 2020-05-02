/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsf.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class TipoUsuario implements Serializable{
    private int codigo;
    private String descripcion;

    public TipoUsuario() {
    }    
    
    public TipoUsuario(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
