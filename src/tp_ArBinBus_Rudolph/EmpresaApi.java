package tp_ArBinBus_Rudolph;

import lista.DinamicList;

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

    public static ArBinBus modify(ArBinBus a, Lampara lamp){
        Lampara aux= (Lampara)a.search(lamp);



    }
}
