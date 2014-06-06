package empresa;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 26/04/14
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class Aplicacion {

    private ArBinBus arBinBus;


    public void crearArbol(ArrayList lista){
        if(lista.size()==0){
            System.out.println("Lista Vacia.");

        }
        else {
            ArBinBus arBin = new ArBinBus();

            for (int i = 0; i< lista.size(); i++){
                Lampara lampara = (Lampara)lista.get(i);
                arBin.insertar(lampara);
            }
            arBinBus = arBin;
        }

    }

    public void añadirLampara(Lampara lampara) {
        arBinBus.insertar(lampara);
    }

    public void quitarLampara(String codigoDeLampara){
        Lampara lamparaAQuitar = new Lampara();
        lamparaAQuitar.setCodigo(codigoDeLampara);
        arBinBus.eliminar(lamparaAQuitar);
    }

    public void modificarStock(String codigoDeLampara, int stock){

        Lampara lampara = new Lampara();
        lampara.setCodigo(codigoDeLampara);

        Lampara lamparaDelArbol = (Lampara)arBinBus.buscar(lampara);
        arBinBus.eliminar(lampara);

        lamparaDelArbol.setCantidad(stock);

        arBinBus.insertar(lamparaDelArbol);

    }

    public void informe (){
       imprimirInOrden(arBinBus);
    }

    private void imprimirInOrden(ArBinBus arBin){
        if(arBin.esVacio()){

        }
        else {
            imprimirInOrden(arBin.hijoIzq());
            Lampara lampara = (Lampara)arBin.getRaiz();
            System.out.println("Codigo de lampara: " + lampara.getCodigo());
            System.out.println("Watts: " + lampara.getWatts());
            System.out.println("Tipo de lampara: " + lampara.getTipoDeLampara());
            System.out.println("Stock: " + lampara.getCantidad());
            imprimirInOrden(arBin.hijoDer());
        }

    }





}
