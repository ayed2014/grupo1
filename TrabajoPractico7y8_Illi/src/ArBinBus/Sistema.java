package ArBinBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nash on 28/04/14.
 */
public class Sistema {
    ArBinBus lamparas;

    public Sistema(ArrayList<Lampara> lamparas) {
        for (Lampara lampara : lamparas) {
            this.lamparas.insertar(lampara);
        }
    }
    public void alta(String clave){
        Lampara lampara = new Lampara(clave);
        lamparas.insertar(lampara);
    }
    public void baja(String clave) {
        Lampara lampara = new Lampara(clave);
        lamparas.eliminar(lampara);
    }
    public void modificar(String clave){
        Lampara lampara = new Lampara(clave);
        lampara = (Lampara)lamparas.buscar(lampara);
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Watts\n 2. Cantidad\n 3. Tipo");
        int option = scanner.nextInt();
        while (option<1 || option>3){
            System.out.println("Ingrese un número de opcion valido.");
            option = scanner.nextInt();
        }
        switch (option) {
            case 1:
                System.out.println("Ingrese la cantidad de watts.\n");
                int watts = scanner.nextInt();
                while (watts<=0){
                    System.out.println("Los watts no pueden ser negativos. Ingrese la cantidad de watts.");
                    watts = scanner.nextInt();
                }
                lampara.setWatts(watts);
                break;
            case 2:
                System.out.println("Ingrese la cantidad agregada\n");
                int cantidad = scanner.nextInt();
                while (cantidad<=0){
                    System.out.println("La cantidad no puede ser negativa. Ingrese la cantidad que se agrega o dismiuye.");
                    cantidad = scanner.nextInt();
                }
                lampara.setCantidad(cantidad);
                break;
            case 3:
                System.out.println("Ingrese el tipo.\n");
                String tipo = scanner.nextLine();
                lampara.setTipo(tipo);
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
    public void informe(ArBinBus arBinBus) {
        if (!arBinBus.isEmpty()) {
            informe(arBinBus.getLeft());
            ((Lampara)arBinBus.getRaiz()).print();
            informe(arBinBus.getRight());
        }
    }
    public void options(){
        System.out.println("¿Que accion quiere realizar?");
        System.out.println("1. Alta\n 2. Baja\n 3. Modificar\n 4. Informe");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option<1 || option>4){
            System.out.println("Ingrese un número de opcion valido.");
            option = scanner.nextInt();
        }
        String clave = "BASIC";
        if (option !=4) {
            System.out.println("Ingrese la clave de la lampara");
            clave = scanner.nextLine();
            while (clave.length() != 5) {
                System.out.println("La clave debe tener 5 caracters");
                clave = scanner.nextLine();
            }
        }

        switch (option) {
            case 1:
                alta(clave);
                break;
            case 2:
                baja(clave);
                break;
            case 3:
                modificar(clave);
                break;
            case 4:
                informe(lamparas);
            default:
                System.out.println("ERROR");
                break;
        }
    }
}
