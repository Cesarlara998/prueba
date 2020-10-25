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
        // INICIO DATOS DE ADM
        
        ControladorAdministrador administradores = new ControladorAdministrador();
        administradores.registro("correoxd123", "123");
        administradores.registro("asd123", "1234");
        
        // INICIO DATOS DE USUARIOS

        ControladorUsuario Usuarios = new ControladorUsuario();
        Usuarios.registro("cesar", "123", "correoxd123");
        Usuarios.registro("juan", "123", "correoxd");
        Usuarios.registro("juan", "123", "correoxd");
        //Usuarios.eliminar("juan");
        //Usuarios.actualizar("cesar","cesar123", "123");
        
        // INICIO DATOS DE GALERIA
        ControladorUsuario Galerias = new ControladorUsuario();
        
        System.out.println(Usuarios.login("cesar", "123"));
        if (Usuarios.Usuario != null) {
            if (administradores.findOne(Usuarios.Usuario.getEmailUsuario(), Usuarios.Usuario.getPasswordUsuario()) == true){
                System.out.println("ES ADM");
            }else {
                System.out.println("NO ES ADM");
            }
            
        }
        //Usuarios.listar();

        //
    }

}
