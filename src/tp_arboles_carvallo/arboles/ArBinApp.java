package arboles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 23/04/14
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class ArBinApp {

    ArBin arbol = new ArBin();

    public int peso(ArBin arBin) {

        int peso = 0;

        if(arBin.esVacio()){
            peso = 0;
            return peso;
         }
        else {

            return 1 + peso(arBin.hijoIzq()) + peso(arBin.hijoDer());
        }

    }

    public int numeroDeHojas(ArBin arBin){
        int number = 0;

        if(arBin.esVacio()){
            number ++;

        }

        else {
            numeroDeHojas(arBin.hijoIzq());
            numeroDeHojas(arBin.hijoDer());

        }

        return number;


    }

    public int cantidaDeVecesQueApareceUnObjeto(ArBin arBin, Object o){

        int times = 0;

        if(arBin.getRoot()==o){
          times++;
        }
        while (arBin.hijoIzq()!= null || arBin.hijoDer()!=null){
            cantidaDeVecesQueApareceUnObjeto(arBin.hijoIzq(), o);
            cantidaDeVecesQueApareceUnObjeto(arBin.hijoDer(), o);
        }

        return times;
    }

    public int elementosEnUnNivelDado(ArBin arBin, int nivel){

        if(nivel<= altura(arBin)){

            if(arBin.esVacio()){
                return 0;
            }
            else if(nivel==0){
                return 1;
            }
            else {
                return elementosEnUnNivelDado(arBin.hijoIzq(),nivel-1) + elementosEnUnNivelDado(arBin.hijoDer(), nivel -1);
            }
        }

        else {
            return -1;
        }
    }

    public int altura (ArBin arBin){
       int altura = 0;

        if (arBin.hijoIzq().esVacio() || arBin.hijoIzq().esVacio()){
            altura = 0;
            return altura;
        }

        else {
            return 1 + altura(arBin.hijoIzq()) + altura(arBin.hijoDer());
        }

    }

    public int sumarElementos(ArBin arBin){

        if(arBin == null){
            return 0;
        }

        else {
            int numero = (Integer)arBin.getRoot();
            return numero + sumarElementos(arBin.hijoIzq()) + sumarElementos(arBin.hijoDer());
        }
    }

    public int sumarElementosMultiplosDe3(ArBin arBin){

        if(arBin == null){
            return 0;
        }
        else {

            if((Integer)arBin.getRoot()%3 == 0){
                return (Integer)arBin.getRoot() + sumarElementosMultiplosDe3(arBin.hijoIzq()) + sumarElementosMultiplosDe3(arBin.hijoDer());
            }
            else {
                return   sumarElementosMultiplosDe3(arBin.hijoIzq()) + sumarElementosMultiplosDe3(arBin.hijoDer());
            }
        }
    }

    public boolean sonIguales(ArBin arBin1, ArBin arBin2){

        if (altura(arBin1)!= altura(arBin2)){
            return false;
        }
        if (peso(arBin1)!= peso(arBin2)){
            return false;
        }

        if(arBin1.esVacio() && arBin2.esVacio()){
            return true;
        }
        else {
            if(arBin1.getRoot().equals(arBin2.getRoot())){
                return sonIguales(arBin1.hijoIzq(),arBin2.hijoIzq()) && sonIguales(arBin1.hijoDer(),arBin2.hijoDer());
            }
            else {
                return false;
            }
        }

    }

    public boolean sonIsomorfos(ArBin arBin1, ArBin arBin2){

        if(peso(arBin1) != peso(arBin2)){
            return false;
        }
        if(altura(arBin1) != altura(arBin2)){
            return false;
        }

        if(arBin1.esVacio() && arBin2.esVacio()){
            return true;
        }
        else {
            return sonIsomorfos(arBin1.hijoIzq(), arBin2.hijoIzq()) && sonIsomorfos(arBin1.hijoDer(), arBin2.hijoDer());
        }

    }

    private boolean estaElElementoEnElArBin(ArBin arBin, Object o){

        if(arBin.getRoot() == o){
            return true;
        }
        else {
            return estaElElementoEnElArBin(arBin.hijoIzq(), o) || estaElElementoEnElArBin(arBin.hijoDer(), o);
        }


    }

    public boolean sonSemejantes(ArBin arBin1, ArBin arBin2){

        int firstTime = 0;

        if(firstTime == 0){

        if(peso(arBin1) != peso(arBin2)){
            return false;
        }
        if(sumarElementos(arBin1) != sumarElementos(arBin2)){
            return false;
        }
        }

        if (arBin1.esVacio() && arBin2.esVacio()){
            firstTime =1;
            return true;
        }

        else if (estaElElementoEnElArBin(arBin1, arBin2.getRoot())){
             firstTime = 1;
            return sonSemejantes(arBin1, arBin2.hijoIzq()) && sonSemejantes(arBin1, arBin2.hijoDer());
        }
        else return false;

    }

    public boolean esCompleto(ArBin arBin){
        int firstTime = 0;

        if(firstTime==0){
            if(arBin.esVacio()){
                return false;
            }
        }

        if(arBin.hijoIzq() != null && arBin.hijoDer()!= null){
            firstTime = 1;
            return true;

        }
        if(arBin.hijoIzq() == null && arBin.hijoDer()== null){
            firstTime = 1;
            return true;
        }

        else if((arBin.hijoIzq() != null && arBin.hijoDer()== null)|| arBin.hijoIzq() == null && arBin.hijoDer()!= null){
            firstTime = 1;
            return false;
        }

        else {
            firstTime = 1;
            return esCompleto(arBin.hijoIzq()) && esCompleto(arBin.hijoDer());
        }
    }

    public boolean esLleno(ArBin arBin){

        if(!esCompleto(arBin)){
            return false;
        }

        int altura = altura(arBin);


        if (elementosEnUnNivelDado(arBin,altura(arBin)) == (int) Math.pow(2,altura)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean esEstable(ArBin arBin){

        if(peso(arBin)==1){
            return true;
        }


        if (arBin.esVacio()){
            return true;
        }

        if((Integer)arBin.getRoot()<(Integer)arBin.hijoIzq().getRoot() || (Integer)arBin.getRoot() <(Integer) arBin.hijoDer().getRoot()){

            return false;
        }

        else {
           return esEstable(arBin.hijoIzq()) && esEstable(arBin.hijoDer());


        }
    }

    public void mostrarFrontera(ArBin arBin){

        if(arBin.esVacio()){
            System.out.println("Hoja: " + arBin.getRoot());
        }

        else {
            mostrarFrontera(arBin.hijoIzq());
            mostrarFrontera(arBin.hijoDer());
        }

    }

    public ArrayList frontera(ArBin arBin){
        ArrayList <Integer> frontera = new ArrayList<Integer>();


        if(arBin.esVacio()){
            frontera.add((Integer)arBin.getRoot());
        }

       else {
            frontera(arBin.hijoIzq());
            frontera(arBin.hijoDer());
        }

        return frontera;
    }

    public void imprimirPreOrden(ArBin arBin) {

        if (arBin.esVacio()){
            return;
        }
        else {
            System.out.println(arBin.getRoot());
            imprimirPreOrden(arBin.hijoIzq());
            imprimirPreOrden(arBin.hijoDer());

        }

    }

    public void imprimirInorden(ArBin arBin){

        if(arBin.esVacio()){

        }
        else {
            imprimirInorden(arBin.hijoIzq());
            System.out.println(arBin.getRoot());
            imprimirInorden(arBin.hijoDer());


        }
    }

    public void imprimirPostOrden(ArBin arBin){

        if(arBin.esVacio()){

        }
        else {
            imprimirPostOrden(arBin.hijoIzq());
            imprimirPostOrden(arBin.hijoDer());
            System.out.println(arBin.getRoot());

        }

    }

    public void imprimirPorNiveles(ArBin arBin){

        if(arBin.esVacio()){

        }
        else {
            System.out.println(arBin.getRoot());
            imprimirPorNiveles(arBin.hijoIzq());
            imprimirPorNiveles(arBin.hijoDer());
        }


    }

    public void saveArBin(ArBin arBin, String fileName){

        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(arBin);
            os.close();
            System.out.println("Arbol guardado satisfactoriamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar.");
        }
    }

    public ArBin loadArBin(String fileName){
        ArBin arBin = new ArBin();
        try {
            FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream os = new ObjectInputStream(fileStream);
            arBin = (ArBin) os.readObject();
            os.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("El arbol no pudo ser cargado.");
        }
        return arBin;
    }


}
