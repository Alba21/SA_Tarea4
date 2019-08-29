/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastreo.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author albaj
 */
@WebService(serviceName = "Rastreo")
public class Rastreo {

    List<nodoRastreo> ubicaciones = new ArrayList<>();

    public Rastreo() {
        ubicaciones.add(new nodoRastreo("1", "C", "1230"));
        ubicaciones.add(new nodoRastreo("1", "P", "1235"));
        ubicaciones.add(new nodoRastreo("2", "C", "1240"));
        ubicaciones.add(new nodoRastreo("2", "P", "1245"));
        ubicaciones.add(new nodoRastreo("3", "C", "1250"));
        ubicaciones.add(new nodoRastreo("3", "P", "1255"));
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public String rastrearCliente(String id) {
        /*
            Esta función busca la ubicación de un cliente
            y llama a una función para ubicar un piloto cercano
            de no encontrarlo devuelve -1
        */
        System.out.println("inicio rastrear cliente");
        for (int i = 0; i < ubicaciones.size(); i++) {
            if (ubicaciones.get(i).id.equals(id) && ubicaciones.get(i).tipo.equals("C")) {
                System.out.println("encontro al cliente");
                return rastrearPiloto(ubicaciones.get(i).ubicacion);
            }
        }
        System.out.println("error rastrear cliente");
        return "-1";
    }

    public String rastrearPiloto(String ubicacionCliente1) {
        /*
            Esta función busca el id de un piloto
            dado que entra la ubicacion de un cliente
            busca que el piloto este cerca de la ubicación del cliente
        
            de no encontrarlo devuelve -1
        */
        int ubicacionCliente = Integer.parseInt(ubicacionCliente1);
        for (int i = 0; i < ubicaciones.size(); i++) {
            if(ubicaciones.get(i).tipo=="P"){
                int ubicacionPiloto = Integer.parseInt(ubicaciones.get(i).ubicacion);
                if(ubicacionPiloto>= ubicacionCliente-5 && ubicacionPiloto<=ubicacionCliente +5){
                    return ubicaciones.get(i).id;
                }
            }
           
        }
        return "-1";
    }

}
