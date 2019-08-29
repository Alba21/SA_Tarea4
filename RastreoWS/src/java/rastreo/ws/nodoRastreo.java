/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastreo.ws;

/**
 *
 * @author albaj
 */
public class nodoRastreo {
    String id;
    String tipo; //C = cliente P = piloto
    String ubicacion;
    
    public nodoRastreo(String i, String t, String u){
        id = i;
        tipo = t;
        ubicacion = u;
    }
    
}
