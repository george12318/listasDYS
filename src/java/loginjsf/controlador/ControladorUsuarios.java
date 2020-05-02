/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsf.controlador;

import java.util.ArrayList;
import java.util.List;
import loginjsf.modelo.TipoUsuario;
import loginjsf.modelo.Usuario;

/**
 *
 * @author carloaiza
 */
public class ControladorUsuarios {
    private List<TipoUsuario> tiposUsuario;
    private List<Usuario> usuarios;

    public ControladorUsuarios() {
        this.iniciarListados();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    private void iniciarListados()
    {
        //Simula la conexion a bds o archivos planos
        tiposUsuario = new ArrayList<>();
        tiposUsuario.add(new TipoUsuario(1,"participante"));
       
        
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("sebascj2000@gmail.com","123456","sebastian cañon ",
         tiposUsuario.get(0)));
        
        
    }
    
    
    public Usuario encontrarUsuarioxCorreo(String correo)
    {
        Usuario usuarioEncontrado = null;
        //Recorre la lista de principio a fin 
        for(Usuario usu: this.usuarios)
        {
            if(usu.getCorreo().equals(correo))
            {
                return usu;
            }
        }
        
        return usuarioEncontrado;
    }
    
    
}
