package lista_ordenada;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class ListaOrdenadaTester {
    public static void main(String[] args) {
        ListaOrdenadaDinamica lod= new ListaOrdenadaDinamica();
        lod.insert(2);
        lod.insert(3);
        lod.insert(1);
        lod.insert(5);
        lod.insert(6);
        lod.insert(7);
        lod.insert(11);
        lod.insert(9);
        lod.insert(10);

        while (!lod.isEmpty()){
            System.out.println(lod.showWindow());
            lod.delete();
        }
    }
}
