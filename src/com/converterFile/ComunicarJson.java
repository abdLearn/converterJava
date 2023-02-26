/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converterEjemplo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author adbiel valdivia
 */
public class ComunicarJson {
    String tipoConversion;
    
    public ComunicarJson(String tipoConversion){
        this.tipoConversion = tipoConversion;
    }
    
    public ArrayList<Conversion> getJsonList(){
        ArrayList<Conversion> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("data/data.json"));
            JSONObject jSONObject = (JSONObject) obj;
            //Monedas
            JSONArray array = (JSONArray) jSONObject.get(this.tipoConversion);
            for (int i = 0; i < array.size(); i++) {
                JSONObject objetoMoneda = (JSONObject) array.get(i);
                list.add(new Conversion(objetoMoneda.get("nombre").toString(),objetoMoneda.get("ruta").toString()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo "+e.getMessage());
        } catch (IOException e){
            System.out.println("Ocurrio algo en la lectura"+e.getMessage());
        } catch (ParseException e){
            System.out.println("No se pudo convertir "+e.getMessage());
        }
        
        return list;
    }
    
}
