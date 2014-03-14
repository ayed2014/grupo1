package busqueda;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 05/03/14
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class test {
    public static void main(String[] args) {

        SeSoMe seSoMe= new SeSoMe();
        //test para ejercicio1
        int[]sequencial={2,5,3,7,9,8,1,11};
        int[]binaria=sequencial.clone();
        binaria=seSoMe.bubbleSort(binaria);
        System.out.println("El numero a buscar es 5");
        System.out.println("Por busqueda sequencial el numero esta en el indice: "+ seSoMe.sequentialSearch(sequencial,5));
        System.out.println("Por busqueda binaria el numero esta en el indice: "+ seSoMe.sequentialSearch(binaria,5));


        //test para ejercicio 2
        int[]a=seSoMe.randomIntArray(1000);
        int[]b=a.clone();
        int[]c= a.clone();
        int[]d=a.clone();


        for(int i = 0; i<a.length;i++)
            System.out.print(a[i]+" - ");
        System.out.println("");
        double timeSeletion1= System.nanoTime();
        a=seSoMe.selectionSort(a);
        double timeSelection2= System.nanoTime();
        System.out.println("Ordenado por metodo selection sort");
        for(int i = 0; i<a.length;i++)
            System.out.print(a[i]+" - ");
        seSoMe.selectionSortRecursive(b, 0);
        System.out.println("\nOrdenado por metodo selection sort recursivo");
        for(int i = 0; i<b.length;i++)
            System.out.print(b[i]+" - ");

        System.out.println("\nOrdenado por metodo incertion sort");
        double timeIncertion1= System.nanoTime();
        c=seSoMe.insertionSort(c);
        double timeIncertion2= System.nanoTime();
        for(int i = 0; i<c.length;i++)
            System.out.print(c[i]+" - ");

        System.out.println("\nOrdenado por metodo incertion sort");
        double timeBubble1= System.nanoTime();
        d=seSoMe.insertionSort(d);
        double timeBubble2= System.nanoTime();
        for(int i = 0; i<d.length;i++)
            System.out.print(d[i]+" - ");


        System.out.println("\ntiempo de ejecucion de: Selection: "+(timeSelection2-timeSeletion1)+"  Incercion: "
        +(timeIncertion2-timeIncertion1)+"  Burbujeo: " +(timeBubble2-timeBubble1) + "  en nanosegundos \n"  );

        //test para ejercico 3
        Comparable[]merge1={1,4,5,7,9};
        Comparable[]merge2={2,3,6,10,11,14};
        Comparable[]merge=seSoMe.merge(merge1,merge2);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i]+" - ");
        }
    }
}
