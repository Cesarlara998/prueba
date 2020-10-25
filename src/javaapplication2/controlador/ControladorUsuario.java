/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.controlador;
import java.util.ArrayList;
import java.util.Iterator;
import javaapplication2.modelos.Usuarios;
import javaapplication2.controlador.*;
/**
 *
 * @author 
 */

public class ControladorUsuario {
    public ArrayList <Usuarios> usuarios = new ArrayList <Usuarios>();
    public Usuarios Usuario;
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
        System.out.println("usuario eliminado");
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
    
    public String login(String nombre, String password) {
        
        if (nombre.length() == 0) {
             return "nombre requerido";
        }
        if (password.length() == 0) {
            return "password requerido";
        }
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            Usuarios elemento = nombreIterator.next();
            if (nombre == elemento.getNombreUsuario() && password == elemento.getPasswordUsuario()) {
                this.Usuario = elemento;
                return "LOGEADO CORRECTAMENTE";
            }
        }
        return "Usuario no encontrado";
    }
}
