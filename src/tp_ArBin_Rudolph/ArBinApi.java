package tp_ArBin_Rudolph;

import cola.QueueD;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 26/03/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class ArBinApi {

    public static void printPorNivel(ArBin a) {
        QueueD queueD = new QueueD();
        ArBin aux;
        if (a.isEmpty()) return;
        queueD.enqueue(a);
        while (!queueD.isEmpty()) {
            aux = (ArBin) queueD.dequeue();
            if (!aux.isEmpty()) {
                System.out.print(aux.getRoot() + " ");
                if (aux.getLeft() != null)
                    queueD.enqueue(aux.getLeft());
                if (aux.getRight() != null)
                    queueD.enqueue(aux.getRight());
            }
        }
    }
    public static void printInorder(ArBin a) {
        if (a.isEmpty()) return;
        printInorder(a.getLeft());
        System.out.print(a.getRoot() + " ");
        printInorder(a.getRight());
    }
    public static void printPreOrden(ArBin a) {
        if (a.isEmpty()) return;
        System.out.print(a.getRoot() + " ");
        printPreOrden(a.getLeft());
        printPreOrden(a.getRight());
    }
    public static void printPostOrden(ArBin a) {
        if (a.isEmpty()) return;
        printPostOrden(a.getLeft());
        printPostOrden(a.getRight());
        System.out.print(a.getRoot() + " ");

    }


    public static int sumarElem(ArBin a){
        if (a.isEmpty())
            return 0;
        else return (Integer)a.getRoot()+sumarElem(a.getLeft())+sumarElem(a.getRight());
    }
    public static int sumarMult3(ArBin a){
        if (a.isEmpty())
            return 0;
        else if (((Integer)a.getRoot()%3)==0 )
            return (Integer)a.getRoot()+sumarMult3(a.getLeft())+sumarMult3(a.getRight());
        else return 0;
    }

    //Recibe un árbol binario y devuelve el peso del mismo
    public static int weight(ArBin a) {
        if (a.isEmpty())
            return 0;
        else
            return 1 + weight(a.getLeft()) + weight(a.getRight());
    }
    //Recibe un árbol binario y devuelve la cantidad de hojas que tiene
    public static int leaves(ArBin a) {
        if (a.isEmpty()) {
            return 0;
        } else if ((a.getLeft().isEmpty()) && (a.getRight().isEmpty())) {
            return 1;
        } else
            return leaves(a.getLeft()) + leaves(a.getRight());
    }
    //Recibe un árbol binario y un element, y devuelve la cantidad de veces que se repite el elemento en el árbol
    public static int elemRepeat(ArBin a, Object elem) {
        int times = 0;
        if (a.isEmpty()) {
            return 0;
        } else {
            if (a.getRoot().equals(elem))
                times++;
            return times + (elemRepeat(a.getLeft(), elem) + elemRepeat(a.getRight(), elem));
        }
    }
    //Recibe un árbol binario y el nivel del árbol, y devuelve la cantidad de elementos que hay en dicho nivel.
    public static int elemLevelAmount(ArBin a, int level){
        return elemLevelAmount(a,level, ArBinApi.high(a));
    }
    private static int elemLevelAmount(ArBin a, int level,int maxlevel) {
        if (level<=maxlevel){
            if (a.isEmpty()) {
                return 0;
            } else if (level == 0) {
                return 1;
            } else
                return (elemLevelAmount(a.getLeft(), level - 1, maxlevel) + elemLevelAmount(a.getRight(), level - 1, maxlevel));
        }else try {
                throw new LevelOutOfBoundsExeption();
            } catch (LevelOutOfBoundsExeption levelOutOfBoundsExeption) {
                levelOutOfBoundsExeption.printStackTrace();
            }
            return -1;
        }
    //Recibe un árbol binario y devuelve la altura del mismo.
    public static int high(ArBin a) {
        if (a.isEmpty()) {
            return -1;
        } else {
            if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
                return 0;
            } else
                return 1 + (Math.max(high(a.getRight()), high(a.getLeft())));
        }
    }

    //Recibe dos árboles binarios y devuelve un boolean indicando si son iguales
    public static boolean areEquals(ArBin a, ArBin b) {
        if ((a.isEmpty()) && (b.isEmpty()))
            return true;
        else {
            if ((a.isEmpty()) || (b.isEmpty()))
                return false;
            else {
                if (a.getRoot().equals(b.getRoot()))
                    return areEquals(a.getLeft(), b.getLeft()) && areEquals(a.getRight(), b.getRight());
                else
                    return false;
            }
        }


    }
    //Recibe dos árboles binarios y devuelve un boolean indicando si son isomorfos
    public static boolean isomorf(ArBin a, ArBin b) {
        if ((a.isEmpty() && b.isEmpty())) {
            return true;
        } else if (!a.isEmpty() && !b.isEmpty()) {
            return (isomorf(a.getLeft(), b.getLeft()) && isomorf(a.getRight(), b.getRight()));
        } else {
            return false;
        }
    }
    //Recibe dos árboles binarios y devuelve un boolean indicando si son similares
    public static boolean alike(ArBin a, ArBin b){
        if (a.isEmpty() && b.isEmpty())
            return true;
        else if (weight(a)==weight(b))
            return areAlike(a,b);
        else return false;
    }
    private static boolean areAlike(ArBin a, ArBin b){
        if (a.isEmpty()) return true;
        else if (elemRepeat(b, a.getRoot())==1)
            return areAlike(a.getLeft(),b)&& areAlike(a.getRight(),b);
        else return false;
    }
    //Recibe un árbol binario y devuelve un boolean indicando si es completo
    public static boolean complete(ArBin a) {
        if (a.isEmpty())
            return true;
        else if (!a.getLeft().isEmpty() && !a.getRight().isEmpty())
            return (complete(a.getLeft()) && complete(a.getRight()));
        else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        else return false;
    }
    //Recibe un árbol binario y devuelve un boolean indicando si es lleno
    public static boolean full(ArBin a){
        return full(a, ArBinApi.high(a), 0);
    }
    private static boolean full(ArBin a, int depth, int currentLevel){
        if (a.isEmpty()||(a.getRight().isEmpty() && a.getLeft().isEmpty())){
            if (depth==currentLevel)
                return true;
            else return false;
        } else if (!a.getLeft().isEmpty() && !a.getRight().isEmpty())
            return (full(a.getLeft(),depth,currentLevel+1)&&full(a.getRight(),depth,currentLevel+1));
        else return false;
    }
    //Recibe un árbol binario de enteros y devuelve un boolean indicando si es estable
    public static boolean stableTree(ArBin a) {
        if (a.isEmpty())
            return true;
        else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        else {
            boolean left = false;
            boolean right = false;
            if (!a.getLeft().isEmpty()) {
                if ((Integer) a.getRoot() > (Integer) a.getLeft().getRoot()) {
                    left = true;
                    stableTree(a.getLeft());
                }
            }
            if (!a.getRight().isEmpty()) {
                if ((Integer) a.getRoot() > (Integer) a.getRight().getRoot()) {
                    right = true;
                    stableTree(a.getRight());
                }
            }
            if (left == true && right == true)
                return true;
            else return false;
        }
    }
    //Recibe dos árboles binarios (a y b)y devuelve un boolean indicando si el arbol b ocurre en a
    public static boolean ocurrsIn(ArBin a, ArBin b){
        if (a.isEmpty() || b.isEmpty()){
            return false;
        }else if (a.getRoot().equals(b.getRoot()))
            return areEquals(a,b);
        else return (ocurrsIn(a.getLeft(),b) || ocurrsIn(a.getRight(),b));
    }
    //Recibe un árbol binario e imprime la frontera
    public static void showBorder(ArBin a) {
        if (a.isEmpty()) {
            System.out.println("El árbol esta vacio");
        } else if (a.getRight().isEmpty() && a.getLeft().isEmpty()) {
            System.out.print(a.getRoot()+" ");
        } else {
            if (!a.getLeft().isEmpty())
                showBorder(a.getLeft());
            if (!a.getRight().isEmpty())
                showBorder(a.getRight());
        }
    }
    //Recibe un árbol binario y devuelve la frontera
    public static ArrayList border(ArBin a) {
        return border(a, new ArrayList());
    }
    private static ArrayList border(ArBin a, ArrayList arr) {
        if (!a.isEmpty()) {
            if (a.getRight().isEmpty() && a.getLeft().isEmpty()) {
                arr.add(a.getRoot());
            } else {
                if (!a.getLeft().isEmpty())
                    border(a.getLeft(), arr);
                if (!a.getRight().isEmpty())
                    border(a.getRight(), arr);
            }
        }
        return arr;
    }

    //Se le pasa un arbol y un sting con el nombre y se guarda en disco
    public static void store(ArBin arBin, String name) throws IOException {
        try {
            FileOutputStream fs = new FileOutputStream(name+".ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(arBin);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //A partir de un nombre busca en disco y devuelve un árbol binario si existe
    public static ArBin load(String name) {
        ArBin arBin = null;
        try {
            FileInputStream fis = new FileInputStream(name+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arBin = (ArBin) ois.readObject();
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

    private static class LevelOutOfBoundsExeption extends Throwable {
    }
}