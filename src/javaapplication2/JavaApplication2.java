/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;
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
        Usuarios.registro("pepe", "123", "asd");
        //Usuarios.eliminar("juan");
        //Usuarios.actualizar("cesar","cesar123", "123");

        // INICIO DATOS DE GALERIA
        ControladorGaleria Galerias = new ControladorGaleria();

        System.out.println("INGRESE USUARIO");
        Scanner sc = new Scanner(System.in);
        String usuario = sc.nextLine();
        System.out.println("INGRESE clave");
        String clave = sc.nextLine();
        System.out.println(Usuarios.login(usuario, clave));
        boolean end = false;
        while (!end) {
            if (Usuarios.Usuario == null) {
                System.out.println("INGRESE USUARIO");
                usuario = sc.nextLine();
                System.out.println("INGRESE clave");
                clave = sc.nextLine();
                System.out.println(Usuarios.login(usuario, clave));
            } else {
                /*MAIN CODE*/
                if (administradores.findOne(Usuarios.Usuario.getEmailUsuario(), Usuarios.Usuario.getPasswordUsuario()) == true) {

                    //ES ADMINISTRADOR
                    System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    System.out.println("-------MENU DE ADMINISTRADOR--------");
                    System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    System.out.println("1 - PARA CREAR GALERIA            --");
                    System.out.println("2 - PARA VER GALERIA              --");
                    System.out.println("3 - PARA MOSTRAR GALERIAS         --");
                    System.out.println("4 - PARA ACTUALIZAR GALERIAS      --");
                    System.out.println("5 - PARA ELIMINAR GALERIAS        --");
                    System.out.println("------------------------------------");
                    System.out.println("6 - PARA CREAR USUARIOS           --");
                    System.out.println("7 - PARA VER USUARIO              --");
                    System.out.println("8 - PARA MOSTRAR USUARIOS         --");
                    System.out.println("9 - PARA ACTUALIZAR USUARIOS      --");
                    System.out.println("10 - PARA ELIMINAR USUARIOS       --");
                    System.out.println("------------------------------------");
                    System.out.println("11 - PARA CREAR ADMINISTRADOR     --");
                    System.out.println("12 - PARA VER ADMINISTRADOR       --");
                    System.out.println("13 - PARA MOSTRAR ADMINISTRADORES --");
                    System.out.println("------------------------------------");
                    System.out.println("0  -     PARA DESLOGEARSE         --");
                    System.out.println("14 - PARA SALIR DEL PROGRAMA      --");
                    System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    String opcionpre = sc.nextLine();
                    int opcion = Integer.parseInt(opcionpre);
                    switch (opcion) {
                        case 14:
                            System.exit(0);
                            break;
                        case 0:
                            Usuarios.Usuario = null;
                            break;
                        case 1:
                            System.out.println("INGRESE NOMBRE");
                            String nombre = sc.nextLine();
                            System.out.println("INGRESE DIRECCION");
                            String direccion = sc.nextLine();
                            Galerias.CrearGaleria(nombre, direccion);
                            sc.nextLine();
                            break;
                        case 2:
                            System.out.println("INGRESE NOMBRE DE GALERIA");
                            Galerias.MostrarGaleria(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 3:
                            Galerias.ListarGalerias();
                            sc.nextLine();
                            break;
                        case 4:
                            System.out.println("INGRESE NOMBRE ACTUAL DE LA GALERIA");
                            nombre = sc.nextLine();
                            System.out.println("INGRESE NUEVO NOMBRE");
                            String nnombre = sc.nextLine();
                            System.out.println("INGRESE NUEVA UBICACION");
                            String ndireccion = sc.nextLine();
                            direccion = sc.nextLine();
                            Galerias.ActualizarGaleria(nombre, nnombre, ndireccion);
                            Galerias.MostrarGaleria(nnombre);
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.println("INGRESE NOMBRE DE GALERIA A ELIMINAR");
                            Galerias.EliminarGaleria(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 6:
                            System.out.println("INGRESE NOMBRE DE USUARIO");
                            nombre = sc.nextLine();
                            System.out.println("INGRESE CORREO DE USUARIO");
                            String coreo = sc.nextLine();
                            System.out.println("INGRESE CONTRASEÑA DE USUARIO");
                            String passw = sc.nextLine();
                            Usuarios.registro(nombre, clave, coreo);
                            sc.nextLine();
                            break;
                        case 7:
                            System.out.println("INGRESE NOMBRE");
                            Usuarios.MostrarUsuario(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 8:
                            Usuarios.listar();
                            sc.nextLine();
                            break;
                        case 9:
                            System.out.println("INGRESE NOMBRE DE USUARIO  A ACTUALIZAR");
                            nombre = sc.nextLine();
                            System.out.println("INGRESE NUEVO CORREO DE USUARIO");
                            coreo = sc.nextLine();
                            System.out.println("INGRESE NUEVA CONTRASEÑA DE USUARIO");
                            passw = sc.nextLine();
                            if (Usuarios.actualizar(nombre, clave, passw) == true) {
                                System.out.println("USUARIO ACTUALIZADO");
                                if (administradores.actualizar(Usuarios.Select.getEmailUsuario(), Usuarios.Select.getPasswordUsuario()) == true){
                                    System.out.println("ADMINISTRADOR ACTUALIZADO");
                                }
                            }else {
                                System.out.println("NO SE LOGRO ACTUALIZAR EL USUARIO");
                            }
                            sc.nextLine();
                            break;
                        case 10:
                            System.out.println("INGRESE NOMBRE DE USUARIO A ELIMINAR");
                            Usuarios.eliminar(sc.nextLine());
                            break;
                            
                        case 11:
                             System.out.println("INGRESE NOMBRE");
                             nombre = sc.nextLine();
                            if (Usuarios.MostrarUsuario(nombre) == false){
                                System.out.println("NO EXISTE USUARIO CON ESE NOMBRE DE USUARIO REGISTRADO");
                                nombre = sc.nextLine();
                            } else {
                                administradores.registro(Usuarios.Select.getEmailUsuario(),Usuarios.Select.getPasswordUsuario());
                                System.out.println("CUENTA DE USUARIO VINCULADA A ADMINISTRADORES");
                            }
                            sc.nextLine();
                            break;
                        case 12:
                            System.out.println("INGRESE CORREO DEL ADMINISTRADOR");
                            administradores.MostrarAdministrador(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 13:
                            administradores.listar();
                            sc.nextLine();
                            break;
                    }

                }

                //ES USUARIO
                System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    System.out.println("-------MENU DE ADMINISTRADOR--------");
                    System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    System.out.println("1 - PARA VER GALERIA              --");
                    System.out.println("2 - PARA MOSTRAR GALERIAS         --");
                    System.out.println("------------------------------------");
                    System.out.println("3 - PARA VER USUARIO              --");
                    System.out.println("4 - PARA MOSTRAR USUARIOS         --");
                    System.out.println("------------------------------------");
                    System.out.println("0  -     PARA DESLOGEARSE         --");
                    System.out.println("14 - PARA SALIR DEL PROGRAMA      --");
                    System.out.println("------------------------------------");
                    System.out.println("------------------------------------");
                    String opcionpre = sc.nextLine();
                    int opcion = Integer.parseInt(opcionpre);
                     switch (opcion) {
                        case 14:
                            System.exit(0);
                            break;
                        case 0:
                            Usuarios.Usuario = null;
                            break;
                        case 1:
                            System.out.println("INGRESE NOMBRE DE GALERIA");
                            Galerias.MostrarGaleria(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 2:
                            Galerias.ListarGalerias();
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.println("INGRESE NOMBRE");
                            Usuarios.MostrarUsuario(sc.nextLine());
                            sc.nextLine();
                            break;
                        case 4:
                            Usuarios.listar();
                            sc.nextLine();
                            break;
            }
        }
        //Usuarios.listar();

        //
    }

}
