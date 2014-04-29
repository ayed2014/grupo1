package tp_ArBinBus_Rudolph;

import lista.DinamicList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 24/04/14
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class Tester {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        DinamicList list= new DinamicList();
        Lampara lamp1=new Lampara("nrtes", 60, "hola", 6);
        Lampara lamp2=new Lampara("nrte3", 70, "mesa", 2);
        list.addNext(lamp1);
        for (int i =0;i <3;i++){
            System.out.println("Agregar el codigo de la lampara: ");
            String code=br.readLine();
            System.out.println("Agregar el tipo de la lampara: ");
            String type=br.readLine();
            System.out.println("insertar la cantidad de lamparas de este tipo: ");
            int amount=Integer.parseInt(br.readLine());
            System.out.println("Ingrese la cantidad de Watts de la lampara: ");
            int watts=Integer.parseInt(br.readLine());
            list.addNext(new Lampara(code,watts,type,amount));
        }

        ArBinBus lampTree= new ArBinBus();
        lampTree=EmpresaApi.transformToArBinBus(list);

        lampTree.remove(lamp1);
        lampTree.insert(lamp2);

        lampTree=EmpresaApi.modify(lampTree, lamp2);
        EmpresaApi.printInorder(lampTree);
    }
}
