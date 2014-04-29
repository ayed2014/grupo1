package tp_ArBinBus_Rudolph;

import lista.DinamicList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 23/04/14
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class EmpresaApi {

    public static ArBinBus transformToArBinBus(DinamicList list){
        ArBinBus arBinBus= new ArBinBus();
        for (int i =0; i<list.length();i++){
            list.goTo(i);
            Comparable aux= (Comparable) list.showWindow();
            arBinBus.insert(aux);
        }
        return arBinBus;
    }
    public static ArBinBus addLamp(ArBinBus a, Lampara lamp){
        a.insert(lamp);
        return a;
    }
    public static ArBinBus removeLamp(ArBinBus a, Lampara lampara){
        a.remove(lampara);
        return a;
    }
    public static void printInorder(ArBinBus a) {
        if (a.isEmpty()) return;
        printInorder(a.getLeft());
        Lampara aux= (Lampara)a.getRoot();
        System.out.println("Lamp code: "+ aux.getLampCode());
        System.out.println("Lamp type: "+ aux.getType());
        System.out.println("Watts: "+ aux.getWatts());
        System.out.println("Amount: "+aux.getAmount());
        printInorder(a.getRight());
    }

    public static ArBinBus modify(ArBinBus a, Lampara lamp) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        Lampara aux= (Lampara)a.search(lamp);
        while(true){
            System.out.println("Para modificar el tipo de lampara ("+aux.getType()+") ingrese 1");
            System.out.println("Para modificar los Watts ("+aux.getWatts()+") ingrese 2");
            System.out.println("Para modificar la cantidad ("+aux.getAmount()+") ingrese 3");
            System.out.println("Ingrese 4 para terminar la ejecución");
            System.out.println("Ingrese la opción");
            int opcion= Integer.parseInt(br.readLine()) ;
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nuevo tipo: ");
                    aux.setType(br.readLine());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo número de Watts de la lampara: ");
                    aux.setWatts(Integer.parseInt(br.readLine()));
                    break;
                case 3:
                    System.out.println("Ingrese la nueva cantidad de lamparas: ");
                    aux.setAmount(Integer.parseInt(br.readLine()));
                    break;
            }
            if (opcion==4)
                break;
        }
        return a;
    }

}
