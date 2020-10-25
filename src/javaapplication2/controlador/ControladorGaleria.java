/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.controlador;

import javaapplication2.modelos.Galeria;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author cesar}
 */
public class ControladorGaleria {

    public ArrayList<Galeria> Galerias = new ArrayList<Galeria>();

    /* Creacion de galeria*/
    public void CrearGaleria(String nombre, String ubicacion) {
        if (nombre.length() == 0) {
            return;
        }
        if (ubicacion.length() == 0) {
            return;
        }
        Galeria Galeria = new Galeria();
        Galeria.setUbicacionGaleria(ubicacion);
        Galeria.setNombreGaleria(nombre);
        Galerias.add(Galeria);
    }

    /* Update de galeria   array 1 = nombre, 2 = ubicacion*/
    public void ActualizarGaleria(String nombreActual, String[] Datosnuevos) {
        Iterator<Galeria> nombreIterator = this.Galerias.iterator();
        while (nombreIterator.hasNext()) {
            Galeria elemento = nombreIterator.next();
            if (elemento.getNombreGaleria() == nombreActual) {
                elemento.setNombreGaleria(Datosnuevos[1]);
                elemento.setUbicacionGaleria(Datosnuevos[2]);

                System.out.println("Galeria actualizada");
                return;
            }
        }
        System.out.println("Galeria no encontrada");
    }

    /* Eliminar galeria*/
    public void EliminarGaleria(String nombre) {
        this.Galerias.removeIf(Galeria -> Galeria.getNombreGaleria() == nombre);
        System.out.println("Galeria eliminada");
    }

    /*Mostrar  galeria*/

    public void MostrarGaleria(String nombre) {
        Iterator<Galeria> nombreIterator = this.Galerias.iterator();
        int Contador = 0;
        while (nombreIterator.hasNext()) {
            Contador++;
            Galeria elemento = nombreIterator.next();
            if (elemento.getNombreGaleria() == nombre) {
                System.out.println("--------------------");
                System.out.println("Galeria numero: " + Contador);
                System.out.println("Galeria Nombre: " + elemento.getNombreGaleria());
                System.out.println("Galeria Direccion: " + elemento.getUbicacionGaleria());
                System.out.println("--------------------");
            }
        }
    }
    /*Mostrar  todas las galerias*/
    public void ListarGalerias(String nombre) {
        Iterator<Galeria> nombreIterator = this.Galerias.iterator();
        int Contador = 0;
        while (nombreIterator.hasNext()) {
            Contador++;
            Galeria elemento = nombreIterator.next();
            System.out.println("--------------------");
            System.out.println("Galeria numero: " + Contador);
            System.out.println("Galeria Nombre: " + elemento.getNombreGaleria());
            System.out.println("Galeria Direccion: " + elemento.getUbicacionGaleria());
            System.out.println("--------------------");
        }
    }
}
