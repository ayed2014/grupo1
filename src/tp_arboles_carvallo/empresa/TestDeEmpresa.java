package empresa;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 26/04/14
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class TestDeEmpresa {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        Lampara lamparaBajoConsumo = new Lampara();
        lamparaBajoConsumo.setCodigo("lamBC");
        lamparaBajoConsumo.setCantidad(100);
        lamparaBajoConsumo.setTipoDeLampara("Lampara BC");
        lamparaBajoConsumo.setWatts(25);

        Lampara lamparaAltoConsumo = new Lampara();
        lamparaAltoConsumo.setCodigo("lamAC");
        lamparaAltoConsumo.setCantidad(25);
        lamparaAltoConsumo.setTipoDeLampara("Lampara AC");
        lamparaAltoConsumo.setWatts(80);

        Lampara lamparaColor = new Lampara();
        lamparaColor.setCodigo("lamCL");
        lamparaColor.setCantidad(10);
        lamparaColor.setTipoDeLampara("Lampara CL");
        lamparaColor.setWatts(50);

        arrayList.add(lamparaBajoConsumo);
        arrayList.add(lamparaAltoConsumo);
        arrayList.add(lamparaColor);

        Aplicacion aplicacion = new Aplicacion();
        aplicacion.crearArbol(arrayList);

        aplicacion.informe();




    }
}
