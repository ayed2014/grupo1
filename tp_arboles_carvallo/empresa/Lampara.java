package empresa;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 26/04/14
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class Lampara implements Comparable {

    String codigo;
    int watts;
    String tipoDeLampara;
    int cantidad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public String getTipoDeLampara() {
        return tipoDeLampara;
    }

    public void setTipoDeLampara(String tipoDeLampara) {
        this.tipoDeLampara = tipoDeLampara;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }

    @Override
    public int compareTo(Object o) {
        Lampara lampara = (Lampara)o;
        if(codigo.compareTo(lampara.getCodigo()) == 0){
            return 0;
        }
        else if(codigo.compareTo(lampara.getCodigo()) > 0){
            return 1;
        }
        else {
            return -1;
        }

    }
}
