/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author albaj
 */
@WebService(serviceName = "Cliente")
public class Cliente {
    List<nodoCliente> clientes = new ArrayList<>();
    public Cliente(){
        clientes.add(new nodoCliente("1","Alba Chinchilla"));
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    public String getId(String nombre){
        for(int i=0; i < clientes.size(); i++){
            if(clientes.get(i).nombre.equalsIgnoreCase(nombre)){
                System.out.println("Cliente Retorna: " + clientes.get(i).id);
                return clientes.get(i).id;
            }
        }
        System.out.println("Error en Cliente");
        return "-1";
    }
}
