/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converterEjemplo;

/**
 *
 * @author adbiel valdivia
 */
public class Conversion{
   String nombre; 
   String RutaImage;

   public Conversion(){
       
   }
   
    public Conversion(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.RutaImage = rutaImagen;
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getRutaImage() {
        return RutaImage;
    }
   
}
