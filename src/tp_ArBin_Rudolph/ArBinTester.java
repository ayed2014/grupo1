package tp_ArBin_Rudolph;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 26/03/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class ArBinTester {
    public static void main(String[] args) {

        ArBin a= new ArBin(4,new ArBin(2), new ArBin());
        ArBin b= new ArBin(3,new ArBin(6), new ArBin(5));
        ArBin arbol1= new ArBin(1,a,b);

        ArBin c= new ArBin(4,new ArBin(2), new ArBin());
        ArBin d= new ArBin(3,new ArBin(6), new ArBin(5));
        ArBin arbol2= new ArBin(1,d,c);

        ArBin g= new ArBin(4,new ArBin(2), new ArBin(4));
        ArBin f= new ArBin(3,new ArBin(7), new ArBin(5));
        ArBin arbol3= new ArBin(1,g,f);

        ArBin h= new ArBin(4);
        ArBin i= new ArBin(3,new ArBin(6), new ArBin(5));
        ArBin arbol4= new ArBin(1,h,i);

        ArBin j= new ArBin(4);
        ArBin k= new ArBin(6,new ArBin(3), new ArBin(5));
        ArBin arbol5= new ArBin(10,j,k);

        ArBin m= new ArBin(4,new ArBin(3), new ArBin());
        ArBin n= new ArBin(3,new ArBin(7), new ArBin(5));
        ArBin arbol6= new ArBin(1,m,n);


        System.out.println("Peso del árblo 1: "+ArBinApi.weight(arbol1));
        System.out.println("Cantidad de hojas del árbol 2: "+ArBinApi.leaves(arbol2));
        System.out.println("Cantidad de veces que se repite el elemento '4' en el árbol 3: "+ArBinApi.elemRepeat(arbol3,4));
        System.out.println("Cantidad de elementos en el nivel 2 del árbol 2: "+ArBinApi.elemLevelAmount(arbol2,2));
        System.out.println("Altura del árbol 3: "+ArBinApi.high(arbol3));

        System.out.println("----");
        System.out.println("¿Son iguales los arboles 2 y 3? "+ArBinApi.areEquals(arbol2,arbol3));
        System.out.println("¿Son isomorfos los arboles 1 y 6? "+ArBinApi.isomorf(arbol1,arbol6));
        System.out.println("¿Son isomorfos los arboles 1 y 3? "+ArBinApi.isomorf(arbol1,arbol3));
        System.out.println("¿Son similares los arboles 1 y 2? "+ArBinApi.alike(arbol1,arbol2));
        System.out.println("¿Son similares los arboles 1 y 3? "+ArBinApi.alike(arbol1,arbol3));
        System.out.println("¿Es completo el árbol 4? "+ArBinApi.complete(arbol4));
        System.out.println("¿Es completo el árbol 2? "+ArBinApi.complete(arbol2));
        System.out.println("¿Es el árbol 3 lleno? "+ArBinApi.full(arbol3));
        System.out.println("¿Es el árbol 1 lleno? "+ArBinApi.full(arbol1));
        System.out.println("¿El árbol 1 es estable? "+ArBinApi.stableTree(arbol1));
        System.out.println("¿El árbol 5 es estable? "+ArBinApi.stableTree(arbol5));
        System.out.println("¿El árbol 'a' ocurre en arbol1? "+ ArBinApi.ocurrsIn(arbol1,a));
        System.out.println("¿El árbol 'a' ocurre en arbol5? "+ ArBinApi.ocurrsIn(arbol5,a));
        System.out.println("Mostrar frontera del arbol2.");
        ArBinApi.showBorder(arbol2);
        ArrayList border3=ArBinApi.border(arbol3);
        System.out.println("\nFrontera del arbol3");
        for (int x =0;x<border3.size();x++){
            System.out.print(border3.get(x)+" ");
        }



        try {
            ArBinApi.store(arbol3,"arbol3");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
