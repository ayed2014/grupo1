package tp_ArBin_Rudolph.arbol;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 26/03/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class ArBinTester {
    public static void main(String[] args) {

        ArBin a= new ArBin(4,new ArBin(2), new ArBin());
        ArBin b= new ArBin(3,new ArBin(6), new ArBin(5));
        ArBin arbol1= new ArBin(1,a,b);

        ArBin c= new ArBin(4,new ArBin(2), new ArBin());
        ArBin d= new ArBin(3,new ArBin(7), new ArBin(5));
        ArBin arbol2= new ArBin(1,d,c);

        System.out.println(ArBinApi.alike(arbol1,arbol2));


    }
}
