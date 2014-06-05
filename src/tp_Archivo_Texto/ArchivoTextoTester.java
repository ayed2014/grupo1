package tp_Archivo_Texto;

/**
 * Created by rudolpha on 04/06/2014.
 */
public class ArchivoTextoTester {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        System.out.println(ArchivoTextoApi.ejercicio1("l", "miArchivo"));
        System.out.println(ArchivoTextoApi.ejercicio1("c","miArchivo"));

        System.out.println("Ejercicio 2");
        System.out.println(ArchivoTextoApi.ejercicio2("a","miArchivo"));

        System.out.println("Ejercicio 3");
        System.out.println(ArchivoTextoApi.ejercicio3(true,"miArchivo","archivoMayuscula"));
        System.out.println(ArchivoTextoApi.ejercicio3(false,"miArchivo","archivoMinuscula"));

        System.out.println("Ejercicio 4");
        System.out.println(ArchivoTextoApi.ejercicio4("miArchivo","pobMayor","pobMenor"));

        System.out.println("Ejercicio 5");
        System.out.println(ArchivoTextoApi.ejercicio5("miArchivo","pobMayorPOB","pobMenorPOB",20,"POB"));
        System.out.println(ArchivoTextoApi.ejercicio5("miArchivo","pobMayorPBI","pobMenorPBI",20,"PBI"));
        System.out.println(ArchivoTextoApi.ejercicio5("miArchivo","pobMayor2","pobMenor2",20,null));
    }
}
