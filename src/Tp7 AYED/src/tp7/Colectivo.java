package tp7;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
public class Colectivo implements Comparable, Serializable {

    private int numeroDeLinea;
    private int numeroDeInterno;
    private int cantidadDeAsientos;
    private boolean aptoParaDiscapasitados;

    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    public boolean isAptoParaDiscapasitados() {
        return aptoParaDiscapasitados;
    }

    public void setAptoParaDiscapasitados(boolean aptoParaDiscapasitados) {
        this.aptoParaDiscapasitados = aptoParaDiscapasitados;
    }

    public int getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }

    public void setCantidadDeAsientos(int cantidadDeAsientos) {
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public int getNumeroDeInterno() {
        return numeroDeInterno;
    }

    public void setNumeroDeInterno(int numeroDeInterno) {
        this.numeroDeInterno = numeroDeInterno;
    }

    @Override
    public int compareTo(Object o) {
        Colectivo colectivoAComparar = (Colectivo) o;
      if(numeroDeInterno >  colectivoAComparar.getNumeroDeInterno()){
          return 1;
      }
       else if(numeroDeInterno < colectivoAComparar.getNumeroDeInterno()){
          return  -1;
      }

        else {
          return 0;
      }

    }
}
