package ArBin;

import com.sun.javafx.collections.transformation.SortedList;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: alumnosfi
 * Date: 26/03/14
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */
public class ArBinApi {
    public int peso(ArBin a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return 1 + peso(a.getRight()) + peso(a.getLeft());
        }
    }

    public int hojas(ArBin a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        } else {
            return hojas(a.getLeft()) + hojas(a.getRight());
        }
    }

    public int vecesElemento(ArBin anArBin, Object anObject) {

        int veces = 0;
        if (anObject == null) {
            return 0;
        }
        if (anObject.equals(anArBin.getRoot())) {
            veces++;
        }
        if (!anArBin.getLeft().isEmpty()) {
            veces+=vecesElemento(anArBin.getLeft(), anObject);

        }
        if (!anArBin.getRight().isEmpty()) {
            veces+=vecesElemento(anArBin.getRight(), anObject);
        }
        return veces;
    }

    public int cantidadDeElementosEnNivel(ArBin arBin, int level) {
        if (level <= -1 || arBin.isEmpty()) {
            return 0;
        }
        else if (level == 0 ) {
            return 1;
        }

    return cantidadDeElementosEnNivel(arBin.getLeft(),level-1) + cantidadDeElementosEnNivel(arBin.getLeft(),level-1);
    }

    public int altura(ArBin arBin) {
        return arBin.isEmpty() ? -1 : arBin.getRight().isEmpty() && arBin.getLeft().isEmpty() ? 0 : 1 + Math.max(altura(arBin.getRight()), altura(arBin.getLeft()));
    }

    public int sumaElementos(ArBin arBin) {
        return arBin.isEmpty() ? 0 : (Integer) arBin.getRoot() + sumaElementos(arBin.getRight()) + sumaElementos(arBin.getLeft());

    }

    public int sumaElementoMultiplosDe(ArBin arBin, int multiplo) {
        int suma = 0;
        if (arBin.isEmpty()) {
            return 0;
        }
        if ((Integer) arBin.getRoot() % multiplo == 0) {
            suma += (Integer) arBin.getRoot();
        }
        suma += sumaElementoMultiplosDe(arBin.getLeft(), multiplo);
        suma += sumaElementoMultiplosDe(arBin.getRight(), multiplo);
        return suma;

    }

    public boolean iguales(ArBin a, ArBin b) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        return a.getRoot().equals(b.getRoot()) && iguales(a.getLeft(), b.getLeft()) && iguales(a.getRight(), b.getRight());
    }

    public boolean isomorfos(ArBin a, ArBin b) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        return isomorfos(a.getRight(), b.getRight()) && isomorfos(a.getLeft(), b.getLeft());
    }

    public boolean semejantes(ArBin a, ArBin b) {
        if (peso(a)!= peso(b) ) {
            return false;
        }
        else {
            return semejantes2(a, b);
        }

    }
    private boolean semejantes2(ArBin a, ArBin b) {
        if (a.isEmpty()){
            return true;
        }
        if (vecesElemento(b,a.getRoot())==1){
            return semejantes2(a.getRight(),b) && semejantes2(a.getLeft(),b);
        }
        else {
            return false;
        }
    }

    public boolean esCompleto(ArBin a) {
        if (a.isEmpty()) return true;
        if (a.getRight().isEmpty() && !a.getLeft().isEmpty() || !a.getRight().isEmpty() && a.getLeft().isEmpty())
            return false;
        return esCompleto(a.getLeft()) && esCompleto(a.getRight());
    }

    public boolean esLleno(ArBin a) {
        int level = altura(a);
        return esCompleto(a) && hojas(a) == Math.pow(2, level);
    }

    public boolean esEstable(ArBin a) {
        if (a.isEmpty() || (a.getLeft().isEmpty() && a.getRight().isEmpty())) return true;
        return ((Comparable) (a.getRoot()) ).compareTo(a.getLeft().getRoot()) > 0 &&
                ((Comparable) (a.getRoot())).compareTo(a.getRight().getRoot()) > 0 && esEstable(a.getRight()) && esEstable(a.getLeft());
    }

    public boolean ocurreArBin(ArBin a, ArBin b) { // Si b ocurre en a;
        return iguales(a,b) || ocurreArBin(a.getLeft(),b) || ocurreArBin(a.getRight(),b);
    }

    public ArrayList frontera(ArBin a) {
        ArrayList frontera = new ArrayList();
        if (a.isEmpty()) {
            return frontera;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            frontera.add(a.getRoot());
            return frontera;
        } else {
            frontera.addAll(frontera(a.getRight()));
            frontera.addAll(frontera(a.getLeft()));
            return frontera;
        }

    }

    public void preOrden(ArBin arBin) {
        if (!arBin.isEmpty()) {
            System.out.println(arBin.getRoot());
            preOrden(arBin.getLeft());
            preOrden(arBin.getRight());
        }
    }

    public void postOrden(ArBin arBin) {
        if (!arBin.isEmpty()) {
            postOrden(arBin.getLeft());
            postOrden(arBin.getRight());
            System.out.println(arBin.getRoot());
        }

    }

    public void enOrden(ArBin arBin) {
        if (!arBin.isEmpty()) {
            enOrden(arBin.getLeft());
            System.out.println(arBin.getRoot());
            enOrden(arBin.getRight());
        }
    }

    public void porNiveles(ArBin arBin) {
        Stack pila, pilaAux; //DEFINICIÓN DE 2 VARIABLES DE TIPO Queue

        NodoDoble aux; //DEFINICIÓN AUX DE TIPO NODO

        if (!arBin.isEmpty()) //SI EL ÁRBOL CONTIENE NODOS...
        {
            pila = new Stack(); //SE INSTANCIA EL OBJETO pila
            pilaAux = new Stack(); //SE INSTANCIA EL OBJETO COLAAUX
            pila.push(arBin.getRaiz()); //SE INSERTA EL NODO RAIZ COMO PRIMER NODO EN LA Pila
            while (!pila.isEmpty()) //MIENTRAS HAYAN ELEMENTOS EN LA Pila...
            {
                pilaAux.push(aux = (NodoDoble) pila.pop()); /*EL ELEMENTO EXTRAIDO DE LA Pila PRINCIPAL ES ASIGNADO
A AUX Y A SU VEZ INSERTADO EN LA Pila AUXILIAR*/
                if (aux.izq != null) //SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                {
                    pila.push(aux.izq); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA Pila
                }
                if (aux.der != null) //SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                {
                    pila.push(aux.der); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA Pila
                }
            }
            for (Object o : pilaAux) {

                System.out.println(((NodoDoble) o).element.toString());
            }

        }
    }

    public void store(ArBin arBin, String name) throws IOException {
        try {
            FileOutputStream fs = new FileOutputStream(name+".ser");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            os.writeObject(arBin);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.close();//Hay que cerrar siempre el archivo
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArBin load(String name) {
        ArBin arBin = null;
        try {
            FileInputStream fis = new FileInputStream(name+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arBin = (ArBin) ois.readObject();//El método readObject() recupera el objeto
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arBin;


    }

    public int cantidadDeVecesElementoEnNivel(ArBin arBin, int level, Object object) {
        if (arBin.isEmpty()){
            return 0;
        }
        if (level == 0){
            if (object.equals(arBin.getRoot())){
                return 1;
            }
            else return 0;
        }
        return cantidadDeVecesElementoEnNivel(arBin,level-1,object);
    }

}



