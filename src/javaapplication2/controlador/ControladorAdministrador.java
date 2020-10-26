/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javaapplication2.modelos.administrador;

/**
 *
 * @author cesar}
 */
public class ControladorAdministrador {

    public administrador adm;
    public administrador Select;
    public ArrayList<administrador> usuarios = new ArrayList<administrador>();

    public Boolean registro(String Email, String passw) {
        if (Email.length() == 0) {
            return false;
        }
        if (passw.length() == 0) {
            return false;
        }
        administrador user = new administrador();
        user.setEmailAdministrador(Email);
        user.setClaveSeguriad(passw);
        usuarios.add(user);
        System.out.println("ADMINISTRADOR REGISTRADO");
        return true;
    }

    public boolean findOne(String Email, String passw) {
        Iterator<administrador> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            administrador elemento = nombreIterator.next();
            if (elemento.getClaveSeguriad() == passw && elemento.getEmailAdministrador() == Email) {
                this.adm = elemento;
                return true;
            }
        }
        return false;
    }

    public Boolean MostrarAdministrador(String email) {
        Iterator<administrador> nombreIterator = this.usuarios.iterator();
        int Contador = 0;
        while (nombreIterator.hasNext()) {
            Contador++;
            administrador elemento = nombreIterator.next();
            if (elemento.getEmailAdministrador().equals(email)) {
                System.out.println("--------------------");
                System.out.println("ADM NUMERO: " + Contador);
                System.out.println("ADM EMAIL: " + elemento.getEmailAdministrador());
                System.out.println("ADM CLAVE: " + elemento.getClaveSeguriad());
                System.out.println("--------------------");
                this.Select = elemento;
                return true;
            }
        }
        return false;
    }

    public void listar() {
        Iterator<administrador> nombreIterator = this.usuarios.iterator();
        int Contador = 0;
        while (nombreIterator.hasNext()) {
            Contador++;
            administrador elemento = nombreIterator.next();
            System.out.println("--------------------");
            System.out.println("ADM NUMERO: " + Contador);
            System.out.println("ADM EMAIL: " + elemento.getEmailAdministrador());
            System.out.println("ADM CLAVE: " + elemento.getClaveSeguriad());

            //return elemento.getEmailUsuario();
        }
    }

    public boolean actualizar(String email, String passw) {
        if (passw.length() == 0) {
            return false;

        }
        if (email.length() == 0) {
            return false;
        }
        Iterator<administrador> nombreIterator = this.usuarios.iterator();
        while (nombreIterator.hasNext()) {
            administrador elemento = nombreIterator.next();
            if (email.equals(elemento.getEmailAdministrador())) {
                elemento.setEmailAdministrador(email);
                elemento.setClaveSeguriad(passw);
                return true;
            }
        }
        return false;
    }
        public void eliminar(String nombre) {
        this.usuarios.removeIf(user -> user.getEmailAdministrador().equals(nombre) );
        System.out.println("ADMINISTRADOR ELIMINADO");
    }
}
