/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.controlador;
import java.util.ArrayList;
import java.util.Iterator;
import javaapplication2.modelos.Usuarios;
/**
 *
 * @author 
 */

public class ControladorUsuario {
    public ArrayList <Usuarios> usuarios = new ArrayList <Usuarios>();
 
     public Boolean registro(String nombre,String passw,String email) {
         if (nombre.length() == 0) {
            return false;
        }
        if (passw.length() == 0) {
            return false;
        }
        if (email.length() == 0) {
            return false;
        }
        Usuarios user = new Usuarios();
        user.setEmailUsuario(email);
        user.setNombreUsuario(nombre);
        user.setPasswordUsuario(passw);
        usuarios.add(user);
        return true;
    }
     
    public void listar(){
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            Usuarios elemento = nombreIterator.next();
            System.out.println(elemento.getEmailUsuario());
            //return elemento.getEmailUsuario();
        }
    }
    
    public void eliminar(String nombre) {
        this.usuarios.removeIf(user -> user.getEmailUsuario() == nombre);
    }
    
    public boolean actualizar(String nombre, String email, String passw) {
        if (passw.length() == 0) {
            return false;
            
        }
        if (email.length() == 0) {
            return false;
        }
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            Usuarios elemento = nombreIterator.next();
            if (nombre == elemento.getNombreUsuario()) {
                elemento.setEmailUsuario(email);
                elemento.setPasswordUsuario(passw);
                return true;
            }
        }
        return false;
    }
}
