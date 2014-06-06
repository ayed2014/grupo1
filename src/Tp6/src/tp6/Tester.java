package tp6;

import claseUtiles.ListaOrdenadaDinamica;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class Tester {

    public static void main(String[] args) {

        ListaOrdenadaDinamica lista = new ListaOrdenadaDinamica();

        lista.insert(3);
        lista.insert(2);
        lista.insert(5);
        lista.insert(10);
        lista.insert(35);

        System.out.println(lista.length());

        System.out.println(lista.showWindow());

    }
}
