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
    public Usuarios Select;
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
        System.out.println("USUARIO CREADO");
        return true;
    }
         public Boolean MostrarUsuario(String nombre) {
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        int Contador = 0;
        while (nombreIterator.hasNext()) {
            Contador++;
            Usuarios elemento = nombreIterator.next();
            if (elemento.getNombreUsuario().equals(nombre)) {
                System.out.println("--------------------");
                System.out.println("USUARIO NUMERO: " + Contador);
                System.out.println("USUARIO NOMBRE: " + elemento.getNombreUsuario());
                System.out.println("USUARIO CORREO: " + elemento.getPasswordUsuario());
                System.out.println("--------------------");
                this.Select = elemento;
                return true;
            }
        }
        return false;
    }
    public void listar(){
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            Usuarios elemento = nombreIterator.next();
            System.out.println("--------------------");
            System.out.println("NOMBRE: " + elemento.getNombreUsuario());
            System.out.println("CORREO: "+ elemento.getEmailUsuario());
            //return elemento.getEmailUsuario();
        }
    }
    
    public void eliminar(String nombre) {
        this.usuarios.removeIf(user -> user.getEmailUsuario().equals(nombre) );
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
            if (nombre.equals(elemento.getNombreUsuario())) {
                elemento.setEmailUsuario(email);
                elemento.setPasswordUsuario(passw);
                this.Select = elemento;
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
        System.out.println(password);
        Iterator<Usuarios> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            Usuarios elemento = nombreIterator.next();
            if (nombre.equals(elemento.getNombreUsuario()) && password.equals(elemento.getPasswordUsuario())) {
                this.Usuario = elemento;
                return "LOGEADO CORRECTAMENTE";
            }
        }
        return "Usuario no encontrado";
    }
}
