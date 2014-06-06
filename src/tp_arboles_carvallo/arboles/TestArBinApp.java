package arboles;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 26/04/14
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public class TestArBinApp {

    public static void main(String[] args) {
        //Crea un arbol binario.
        ArBin arBinIzq = new ArBin(2);
        ArBin arBinDer = new ArBin(3);
        ArBin arBin = new ArBin(1,arBinIzq,arBinDer);

        //Crea la aplicacion ArBinApp
        ArBinApp arBinApp = new ArBinApp();

        //Imprime varios datos sobre el mismo arbol.

        System.out.println("Peso: " + arBinApp.peso(arBin));
        System.out.println("Altura: " + arBinApp.altura(arBin));
        System.out.println("Es completo: " + arBinApp.esCompleto(arBin));
        System.out.println("Es estable: " + arBinApp.esEstable(arBin));
        System.out.println("Es lleno: " + arBinApp.esLleno(arBin));
        System.out.println("Lo imprime en InOrden: ");
        arBinApp.imprimirInorden(arBin);
        System.out.println();
        System.out.println("Lo imprime en PostOrden: ");
        arBinApp.imprimirPostOrden(arBin);
        System.out.println();
        System.out.println("Lo imprime en PreOrden: ");
        arBinApp.imprimirPreOrden(arBin);
        System.out.println();
        System.out.println("Lo imprime por niveles: ");
        arBinApp.imprimirPorNiveles(arBin);
        System.out.println();

        //Guarda el arbol.
        arBinApp.saveArBin(arBin, "MyFirstArBinSave.UA");

        //Carga el arbol y lo imprime en PreOrden.
        ArBin arBinLoad = arBinApp.loadArBin("MyFirstArBinSave.UA");
        System.out.println("PreOrden: ");
        arBinApp.imprimirPreOrden(arBinLoad);


    }
}
