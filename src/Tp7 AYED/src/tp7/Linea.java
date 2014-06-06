package tp7;

import claseUtiles.ListaOrdenadaDinamica;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class Linea implements Comparable, Serializable {

    private ListaOrdenadaDinamica colectivos;
    private int numeroDeLinea;
    private int cantidadDeColectivos;



    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    public ListaOrdenadaDinamica getColectivos() {
        return colectivos;
    }

    public void agregarColectivo(Colectivo c){
        colectivos.insert(c);
        cantidadDeColectivos++;
    }

    public void agregarListaDeColectivos(ListaOrdenadaDinamica colectivos) {
        this.colectivos = colectivos;
        cantidadDeColectivos += colectivos.length();
    }

    public void eliminarColectivo(Colectivo colectivoAEliminar){

        Colectivo colectivoEnLaLista = (Colectivo) colectivos.showWindow();

        while (colectivoEnLaLista.compareTo(colectivoAEliminar)!= 0){
            colectivos.next();
            colectivoEnLaLista = (Colectivo)colectivos.showWindow();

        }
        colectivos.delete();
        cantidadDeColectivos --;

    }

    public int getCantidadDeColectivos() {
        return cantidadDeColectivos;
    }

    @Override
    public int compareTo(Object o) {

            Linea lineaAComparar = (Linea) o;
            if(numeroDeLinea>lineaAComparar.getNumeroDeLinea()){
                return 1;
            }
            else if(numeroDeLinea<lineaAComparar.getNumeroDeLinea()){
                return -1;
            }
            else {
                return 0;

            }

    }


}