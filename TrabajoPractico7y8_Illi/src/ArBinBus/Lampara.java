package ArBinBus;

/**
 * Created by Nash on 28/04/14.
 */
public class Lampara implements Comparable {
    private final String CLAVE;
    int watts;
    String tipo;
    int cantidad;

    public Lampara(String clave1) {
        CLAVE = clave1;
    }

    @Override
    public int compareTo(Object o) {
        return CLAVE.compareTo(o.toString());
    }

    @Override
    public String toString() {
        return CLAVE;
    }

    public void setCantidad(int cantidad) {
        this.cantidad+= cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }
    public void print(){
        System.out.println("\nClave: " + CLAVE +"\nCantidad: " + cantidad +"\nWatts: "+ watts +"\n Tipo: " + tipo);
    }
}
