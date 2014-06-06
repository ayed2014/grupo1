package tp6;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class SistemaTester {

    public static void main(String[] args) {

        Sistema mySystem = new Sistema();
        mySystem.setSystemToTry();
        mySystem.printReport();
        System.out.println("");
        System.out.println("It delete a bus line. Now the report is : ");
        Linea lineaParaEliminar = new Linea();
        lineaParaEliminar.setNumeroDeLinea(510);

        mySystem.deleteLine(lineaParaEliminar);
        System.out.println("");
        mySystem.printReport();

        System.out.println("");
        System.out.println("It add a bus. Now the report is: ");
        Colectivo c = new Colectivo();
        c.setNumeroDeLinea(251);
        c.setNumeroDeInterno(35);

        mySystem.addBus(c);
        System.out.println("");
        mySystem.printReport();

        System.out.println("");
        System.out.println("Now it save the System.");
        mySystem.save("Line System.lns");

        //Use to load the saved System.
        /**
        Sistema aux = new Sistema();
        Sistema mySystem2 = aux.load("First save");
        mySystem2.printReport();
         **/







    }

}
