package tp6;

import claseUtiles.ListaOrdenadaDinamica;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class Sistema implements Serializable {

    private ListaOrdenadaDinamica lineas;


    public Sistema(){

        lineas = new ListaOrdenadaDinamica();

    }


    public void addLine(Linea l){

        if (!isTheLine(l)) {
            lineas.insert(l);
        }
        else System.out.println("The line is already added.");


    }

    public void deleteLine(Linea l){

        if (isTheLine(l)){

            Linea linea = (Linea)lineas.showWindow();


            while (linea.compareTo(l) != 0 ){
                lineas.next();
                linea = (Linea) lineas.showWindow();
            }

            lineas.delete();
        }
        else System.out.println("The line do NOT exist.");




    }


    public void addBus(Colectivo c){

         Linea lineToCompare = new Linea();
         lineToCompare.setNumeroDeLinea(c.getNumeroDeLinea());

        if (c.getNumeroDeInterno() != 0 && c.getNumeroDeLinea() !=0){

            if (isTheLine(lineToCompare) && !isTheBus(c)){

                //Crea una objeto linea para poder comparar con la lista de Lineas.
                Linea lineaDelColectivoParaAgregar = new Linea();
                lineaDelColectivoParaAgregar.setNumeroDeLinea(c.getNumeroDeLinea());

                Linea linea = (Linea) lineas.showWindow();

                while (linea.compareTo(lineaDelColectivoParaAgregar) !=0){
                    lineas.next();
                    linea = (Linea)lineas.showWindow();
                }

                Linea lineaFinalParaAgregar = (Linea)lineas.showWindow();
                lineaFinalParaAgregar.agregarColectivo(c);


                lineas.modify(lineaFinalParaAgregar);
            }
            else System.out.println("The line do not exist, or the bus is already in the line.");
        }
        else System.out.println("Number of line or number of internal NOT valid.");





    }

    public void deleteBus(Colectivo colectivoAQuitar){

        if (colectivoAQuitar.getNumeroDeInterno() != 0 && colectivoAQuitar.getNumeroDeLinea() != 0){

            if (isTheBus(colectivoAQuitar)){

                Linea lineaColectivoParaQuitar = new Linea();
                lineaColectivoParaQuitar.setNumeroDeLinea(colectivoAQuitar.getNumeroDeLinea());

                Linea linea = (Linea) lineas.showWindow();

                while (linea.compareTo(lineaColectivoParaQuitar)!= 0){
                    lineas.next();
                    linea = (Linea) lineas.showWindow();
                }

                Linea lineaActualizada = (Linea) lineas.showWindow();
                lineaActualizada.eliminarColectivo(colectivoAQuitar);
                lineas.modify(lineaActualizada);
            }
            else System.out.println("The bus do NOT exist.");

        }
        else System.out.println("Number of line or number of internal NOT valid.");




    }


    public void save(String fileName){

        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(this);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sistema load(String fileName){

        Sistema gestionDeColectivos =new Sistema();

        try {
            FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream os = new ObjectInputStream(fileStream);
             gestionDeColectivos = (Sistema) os.readObject();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return gestionDeColectivos;
    }

    public void setSystemToTry(){

        Colectivo [] colectivosLinea251 = new Colectivo[30];
        Colectivo [] colectivosLinea510 = new Colectivo[30];

        ListaOrdenadaDinamica listaDeColectivosLinea251 = new ListaOrdenadaDinamica();
        ListaOrdenadaDinamica listaDeColectivosLinea510 = new ListaOrdenadaDinamica();

        for (int i = 0; i <colectivosLinea251.length ;i++){
            colectivosLinea251[i] = new Colectivo();
            colectivosLinea251[i].setAptoParaDiscapasitados(false);
            colectivosLinea251[i].setCantidadDeAsientos(40);
            colectivosLinea251[i].setNumeroDeInterno(i+1);
            colectivosLinea251[i].setNumeroDeLinea(251);

            listaDeColectivosLinea251.insert(colectivosLinea251[i]);


        }

        for (int i = 0; i <colectivosLinea510.length ;i++){
            colectivosLinea510[i] = new Colectivo();
            colectivosLinea510[i].setAptoParaDiscapasitados(false);
            colectivosLinea510[i].setCantidadDeAsientos(40);
            colectivosLinea510[i].setNumeroDeInterno(i+1);
            colectivosLinea510[i].setNumeroDeLinea(251);

            listaDeColectivosLinea510.insert(colectivosLinea510[i]);
        }





        Linea linea251 = new Linea();
        Linea linea510 = new Linea();

        linea251.setNumeroDeLinea(251);
        linea510.setNumeroDeLinea(510);

        linea251.agregarListaDeColectivos(listaDeColectivosLinea251);
        linea510.agregarListaDeColectivos(listaDeColectivosLinea510);

        lineas.insert(linea251);
        lineas.insert(linea510);
    }

    public void printReport(){
        int count = 0;
        int cantidadColectivosAptoDiscapacitadosPorLinea = 0;
        int cantidadColectivoConMasDe27AsientosPorLinea = 0;



        System.out.println("Lineas de colectivos: \n");

        while (lineas.length()>count){

            lineas.goTo(count);
            Linea lineaActual = (Linea)lineas.showWindow();
            System.out.println("");
            System.out.println("*Linea " + lineaActual.getNumeroDeLinea());
            int count2 = 0;

            ListaOrdenadaDinamica listaDeColectivos = lineaActual.getColectivos();

            while (listaDeColectivos.length()> count2){

                listaDeColectivos.goTo(count2);
                Colectivo colectivoActual = (Colectivo)listaDeColectivos.showWindow();

                System.out.println("Colectivo numero de interno: " + colectivoActual.getNumeroDeInterno() );

                if (colectivoActual.isAptoParaDiscapasitados()){
                    cantidadColectivosAptoDiscapacitadosPorLinea++;
                }
                if (colectivoActual.getCantidadDeAsientos()>27){
                    cantidadColectivoConMasDe27AsientosPorLinea ++;
                }
                count2++;
            }

            System.out.println("Cantidad de colectivos aptos para discapacitados: " + cantidadColectivosAptoDiscapacitadosPorLinea);
            System.out.println("Cantidad de colectivos con mas de 27 asientos: " + cantidadColectivoConMasDe27AsientosPorLinea);
            cantidadColectivosAptoDiscapacitadosPorLinea = 0;
            cantidadColectivoConMasDe27AsientosPorLinea = 0;
            count++;
        }

    }


    public void printCantidadDeLineas(){

        System.out.println(lineas.length());

    }


    private boolean isTheLine(Linea linea){

        int count = 0;

        while (lineas.length()>count){
            lineas.goTo(count);
            Linea lineToCompare = (Linea) lineas.showWindow();

            if (lineToCompare.compareTo(linea) == 0){
                return true;
            }
            count++;

        }

        return false;
    }

    private boolean isTheBus(Colectivo colectivo){

        Linea lineToCompare = new Linea();
        lineToCompare.setNumeroDeLinea(colectivo.getNumeroDeLinea());
        int count = 0;
        int count2 = 0;

        if (isTheLine(lineToCompare)){

            while (lineas.length()>count){
                lineas.goTo(count);
                Linea linea = (Linea) lineas.showWindow();
                ListaOrdenadaDinamica listOfBus = linea.getColectivos();

                while (listOfBus.length()>count2){
                    listOfBus.goTo(count2);
                    Colectivo busToCompare = (Colectivo) listOfBus.showWindow();

                    if (busToCompare.compareTo(colectivo) == 0){
                        return true;
                    }

                    count2++;
                }

                count++;
            }
        }

        return false;
    }




}
