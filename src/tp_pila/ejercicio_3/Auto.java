package tp_pila.ejercicio_3;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 18/03/14
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class Auto implements Comparable {
    private String patente;

    public Auto(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
        @Override
    public int compareTo(Object o) {
        Auto auto2=(Auto)o;
        if (patente.compareTo(auto2.getPatente())==0)
            return 0;
        return 1;
    }

}