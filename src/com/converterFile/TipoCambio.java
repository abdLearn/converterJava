/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converterEjemplo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author adbiel valdivia
 */
public class TipoCambio extends Conversion {

    String nombreInicio;
    String nombreDestino;

    public TipoCambio(String nombreInicio, String nombreDestino) {
        this.nombreInicio = nombreInicio;
        this.nombreDestino = nombreDestino;
    }

    public Double getCambioDivisa() {
        HashMap<String, Double> pais = new HashMap<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("data/data.json"));
            JSONObject jSONObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jSONObject.get("Monedas");
            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()) {
                JSONObject moneda = iterator.next();
                if (moneda.get("nombre").toString().equals(this.nombreInicio)) {

                    JSONArray tipoCambio = (JSONArray) moneda.get("tipoCambio");
                    Iterator<JSONObject> tcIterator = tipoCambio.iterator();

                    while (tcIterator.hasNext()) {
                        JSONObject cambio = tcIterator.next();
                        pais.put(cambio.get("simbolo").toString(), Double.valueOf(cambio.get("valor").toString()));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocurrio algo en la lectura" + e.getMessage());
        } catch (ParseException e) {
            System.out.println("No se pudo convertir " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("valores nulos " + e.getMessage());
        }

        return pais.get(this.nombreDestino);
    }

    public Double getCambioTemperatura(double x) {
        HashMap<String, Double> celcius = new HashMap<>();
        celcius.put("Celcius", x);
        celcius.put("Kelvin", x + 273.15);
        celcius.put("Fahrenheit", (x*9/5) + 32);
        celcius.put("Reamur", x * 0.8);
        celcius.put("Rankine", (x*9/5) + 491.67); 

        HashMap<String, Double> kelvin = new HashMap<>();
        kelvin.put("Celcius", x - 273.15);
        kelvin.put("Kelvin", x);
        kelvin.put("Fahrenheit", (x - 273.15)*1.8 + 32);
        kelvin.put("Reamur", (x - 273.15)*1.8);
        kelvin.put("Rankine", (x - 273.15)*1.8 + 491.67);

        HashMap<String, Double> Fahrenheit = new HashMap<>();
        Fahrenheit.put("Celcius",(x - 32)/1.8);
        Fahrenheit.put("Kelvin", (x - 32)/1.8 + 273.15);
        Fahrenheit.put("Fahrenheit", x);
        Fahrenheit.put("Reamur", (x - 32)/1.8*0.8);
        Fahrenheit.put("Rankine", (x - 32) + 491.67);

        HashMap<String, Double> Reamur = new HashMap<>();
        Reamur.put("Celcius",x/0.8);
        Reamur.put("Kelvin", x/0.8 + 273.15);
        Reamur.put("Fahrenheit", (x/0.8)*1.8 + 32);
        Reamur.put("Reamur", x);
        Reamur.put("Rankine", (x/0.8)*1.8 + 491.67);

        HashMap<String, Double> Rankine = new HashMap<>();
        Rankine.put("Celcius",(x - 491.67)/1.8 );
        Rankine.put("Kelvin", (x - 491.67)/1.8 + 273.15);
        Rankine.put("Fahrenheit", (x - 491.67) + 32);
        Rankine.put("Reamur", (x - 491.67)/1.8*0.8);
        Rankine.put("Rankine", x);

        switch (this.nombreInicio) {
            case "Celcius":
                return celcius.get(this.nombreDestino);
            case "Kelvin":
                return kelvin.get(this.nombreDestino);
            case "Fahrenheit":
                return Fahrenheit.get(this.nombreDestino);
            case "Reamur":
                return Reamur.get(this.nombreDestino);
            case "Rankine":
                return Rankine.get(this.nombreDestino);
            default:
                throw new AssertionError();
        }
    }

    public String getSimboloTemperatura(String text) {
        switch (text) {
            case "Celcius":
                return "°C";
            case "Kelvin":
                return "°K";
            case "Fahrenheit":
                return "°F";
            case "Reamur":
                return "°Re";
            case "Rankine":
                return "°R";
            default:
                throw new AssertionError();
        }
    }

}
