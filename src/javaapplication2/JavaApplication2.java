/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import javaapplication2.controlador.*;
import javaapplication2.modelos.Usuarios;
/**
 *
 *
 */
public class JavaApplication2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ControladorUsuario Usuarios = new ControladorUsuario();
       Usuarios.registro("cesar", "123","correoxd");
       Usuarios.registro("juan", "123","correoxd");
       Usuarios.registro("juan", "123","correoxd");
       //Usuarios.eliminar("juan");
       Usuarios.actualizar("cesar","cesar123", "123");
       Usuarios.listar();
    }
    
}
