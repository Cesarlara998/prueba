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
}
