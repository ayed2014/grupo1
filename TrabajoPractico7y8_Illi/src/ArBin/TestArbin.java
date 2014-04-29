package ArBin;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nash on 20/04/14.
 */
public class TestArbin {
    public static void main(String[] args) {
        ArBinApi arBinApi = new ArBinApi();
        ArBin arBin1 = new ArBin(1,new ArBin(55,new ArBin(4),new ArBin(100)),new ArBin(1)); // Igual a arBin2, peso = 5
        ArBin arBin2 = new ArBin(1,new ArBin(55,new ArBin(4),new ArBin(100)),new ArBin(1)); // Igual a arBin1
        ArBin arBin3 = new ArBin(10,new ArBin(5),new ArBin(11));
        ArBin arBin4 = new ArBin("A",new ArBin("B",new ArBin("C"),new ArBin("D")),new ArBin("E")); // Isomorfo con arbin1 y arbin2
        ArBin arBin5 = new ArBin(100, new ArBin(1,new ArBin(55), new ArBin(4, new ArBin(1), new ArBin())), new ArBin());
        ArBin arBin6 = new ArBin("a", new ArBin(1,new ArBin(new ArBin(1,new ArBin(4,new ArBin(4),new ArBin(4)),new ArBin(4))),new ArBin(55)),new ArBin("!y"));
        ArBin arBin7 = new ArBin(100,new ArBin(50,new ArBin(30),new ArBin(35)),new ArBin(11));
        ArBin arBin8 = new ArBin(10,new ArBin(5,new ArBin(30),new ArBin(35)),new ArBin(11));
        int cinco = arBinApi.peso(arBin1);
        int tres = arBinApi.hojas(arBin2);
        int dos = arBinApi.vecesElemento(arBin1,1);
        int uno = arBinApi.vecesElemento(arBin1,55);
        int zero = arBinApi.vecesElemento(arBin1,5055);

        int highDos = arBinApi.altura(arBin1);

        int suma161 = arBinApi.sumaElementos(arBin1);

        int suma155 = arBinApi.sumaElementoMultiplosDe(arBin1,5);

        boolean equalsTrue = arBinApi.iguales(arBin1,arBin2);
        boolean equalsFalse = arBinApi.iguales(arBin1,new ArBin());
        boolean equalsFalse2 = arBinApi.iguales(arBin2,arBin3);

        boolean isomorfoTrue = arBinApi.isomorfos(arBin1,arBin4);
        boolean isomorfoTrue2 = arBinApi.isomorfos(arBin1,arBin2);
        boolean isomorfoFalse = arBinApi.isomorfos(arBin4,arBin3);

       // boolean semejantesTrues = arBinApi.semejantes(arBin1,arBin5);

        boolean esCompletoTrue = arBinApi.esCompleto(arBin6);
        boolean esCompletoFlase = arBinApi.esCompleto(arBin5);

       boolean esLlenoTrue = arBinApi.esLleno(arBin3);
       boolean esLlenoFalse = arBinApi.esLleno(arBin6);

        boolean esEstableFalse = arBinApi.esEstable(arBin1);
        boolean esEstableTrue = arBinApi.esEstable(arBin7);

       //boolean ocurreTrue = arBinApi.ocurreArBin(arBin8,arBin3);

        ArrayList frontera = arBinApi.frontera(arBin8);
        System.out.println("Recorrido de arbin8");
        System.out.println("PostOrden");
        arBinApi.postOrden(arBin8);
        System.out.println("--------------------------------");
        System.out.println("PostOrden con Load");
        arBinApi.postOrden(arBinApi.load("arbin8"));
        System.out.println("--------------------------------");
        System.out.println("PreOrden");
        arBinApi.preOrden(arBin8);
        System.out.println("--------------------------------");
        System.out.println("EnOrden");
        arBinApi.enOrden(arBin8);
        System.out.println("--------------------------------");
        System.out.println("PorNiveles");
        arBinApi.porNiveles(arBin8);
        try {
            arBinApi.store(arBin8,"arbin8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
