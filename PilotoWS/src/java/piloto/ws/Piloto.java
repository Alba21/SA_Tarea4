/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piloto.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author albaj
 */
@WebService(serviceName = "Piloto")
public class Piloto {

    List<nodoPiloto> listaPilotos = new ArrayList<>();

    public Piloto() {
        listaPilotos.add(new nodoPiloto("1", "Alex Garcia", "Toyota Yaris Gris P809FVJ"));
        listaPilotos.add(new nodoPiloto("2", "Angel Prado", "Mitsubishi Mirage Rojo P811FVJ"));
        listaPilotos.add(new nodoPiloto("3", "Alex Garcia", "Honda FIT Negro P810FVJ"));

    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public String concatenar(String t1, String t2) {
        return t1 + t2;
    }

    public String returnInfPiloto(String id) {
        /*
            Busca la información de un piloto
            dado que entra su id.
        De no encontrar uno, devuelve una cadena vacía.
            
        */
        System.out.println("Return piloto: "+id);
        for (int i = 0; i < listaPilotos.size(); i++) {
            if (listaPilotos.get(i).id.equals(id)) {
                return listaPilotos.get(i).nombre + "Vehiculo " + listaPilotos.get(i).infVehiculo;

            }
        }
        return "";
    }
}
