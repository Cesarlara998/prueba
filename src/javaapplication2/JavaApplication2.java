/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javaapplication2.controlador.*;

/**
 *
 *
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ControladorAdministrador administrador = new ControladorAdministrador();
        administrador.registro("correoxd123", "123");
        administrador.registro("asd123", "1234");
        
        //

        ControladorUsuario Usuarios = new ControladorUsuario();
        Usuarios.registro("cesar", "123", "correoxd123");
        Usuarios.registro("juan", "123", "correoxd");
        Usuarios.registro("juan", "123", "correoxd");
        //Usuarios.eliminar("juan");
        //Usuarios.actualizar("cesar","cesar123", "123");
        
        
        
        System.out.println(Usuarios.login("cesar", "123"));
        if (Usuarios.Usuario != null) {
            if (administrador.findOne(Usuarios.Usuario.getEmailUsuario(), Usuarios.Usuario.getPasswordUsuario()) == true){
                System.out.println("ES ADM");
            }else {
                System.out.println("NO ES ADM");
            }
            
        }
        //Usuarios.listar();

        //
    }

}
