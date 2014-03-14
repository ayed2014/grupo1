package busqueda;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 10/03/14
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class SeSoMe {
    /*
    El metdo sequentialSearch() recibe un arreglo a[] y un dato q del mismo tipo que el arreglo. Aplicando el metodo de busqueda
    secuencial se fija si el dato a esta en el arreglo. Si encuentra una coincidencia el metodo devuelve la posicion de
     donde se encuentra la coincidencio, sino devuelve un -1.
    El metodo esta implementado para enteros, doubles, String y objetos Comparable.
     */
    //Busqueda secuencial   int
    public int sequentialSearch (int[] a, int q){
        for (int i =0; i<a.length;i++)
            if (a[i]==q) return i;
        return -1;
    }
    //Busqueda secuencial   double
    public int sequentialSearch (double[] a, double q){
        for (int i =0; i<a.length;i++)
            if (a[i]==q) return i;
        return -1;
    }
    //Busqueda secuencial   String
    public int sequentialSearch (String[] a, String q){
        for (int i =0; i<a.length;i++)
            if (a[i].equals(q)) return i;
        return -1;
    }
    //Busqueda secuencial con interfaz Comparable
    public int sequentialSearch (Comparable[] a, Comparable q){
        for (int i =0; i<a.length;i++)
            if (a[i].compareTo(q)==0) return i;
        return -1;
    }

    /*
    El metodo binarySearch()recibe un arreglo a[] y un dato q del mismo tipo que el arreglo. Aplicando el metodo de
    busqueda binaria se fija si encuentra una coincidencia entre el dato y el arreglo. si encuentra una coincidencia
    devuelve el indice donde se produjo la coincidencia, sino devuelve un -1.
    El metodo esta implementado para enteros, doubles, Strings y objetos Comparable.
     */
    //Buesqueda binaria para enteros
    public int binarySearch(int []a, int q){
        int min= 0;
        int max= a.length-1;
        int medio= (max+min)/2;
        while ((max-min)>=0) {
            if (q== a[medio]){
                return medio;
            } else if (q<a[medio]){
                max= medio-1;
            } else min= medio+1;

            medio= (min+max)/2;
        }
        return -1;
    }
    //Busqueda binaria double
    public int binarySearch(double []a, double q){
        int min= 0;
        int max= a.length-1;
        int medio= (max+min)/2;
        while ((max-min)>=0) {
            if (q== a[medio]){
                return medio;
            } else if (q<a[medio]){
                max= medio-1;
            } else min= medio+1;

            medio= (min+max)/2;
        }
        return -1;
    }
    //Busqueda binaria para Strings
    public int binarySearch(String []a, String q){
        int min= 0;
        int max= a.length-1;
        int medio= (max+min)/2;
        while ((max-min)>=0) {
            if (q.compareTo(a[medio])==0){
                return medio;
            } else if (q.compareTo(a[medio])<0){
                max= medio-1;
            } else min= medio+1;

            medio= (min+max)/2;
        }
        return -1;
    }
    // busqueda binaria con interfaz comparable
    public int binarySearch(Comparable a[], Comparable q){
        int min= 0;
        int max= a.length-1;
        int medio= (max+min)/2;
        while ((max-min)>=0) {
            if (q.compareTo(a[medio])==0){
                return medio;
            } else if (q.compareTo(a[medio])<0){
                max= medio-1;
            } else min= medio+1;

            medio= (min+max)/2;
        }
        return -1;
    }


    /*
    El metoro randomIntArray() genera un arreglo de enteros de longuitud maxima de n elementos(n es un entero qeu se le pasa al metodo)
    , y lo rellena con numeros aleatorios entre 0 y 5000.
     */
    public  int[] randomIntArray(int N){
        int[]intArray= new int[N];
        for (int i =0; i <N;i++){
            intArray[i]= (int)(Math.random()*5000);
        }
        return intArray;
    }

    /*
    El metodo selectionSort recibe un arreglo de elementos desordenados, y devuelve el mismo arreglo ordenado aplicando
    el metodo de Selección. el metodo de Selección consiste en buscar en un arreglo desde una posicion i hata el final
    el minimo y luego intercambiarlo con la posicion i.
    El metodo esta implementado para recibir arreglos de enteros, Strings y objetos que implementen la interfaz
    Comparable.
     */
    //Selection Sort para arreglos de enteros.
    public int [] selectionSort(int [] a){
        for (int i = 0; i<a.length;i++){
            int indexMin= i;
            for (int j =i;j<a.length;j++){
                if (a[indexMin]>(a[j]))
                    indexMin=j;
            }
            a=intercambiar(a,indexMin,i);
        }
        return a;
    }
    //Selection Sort para arreglos de Strings.
    public String [] selectionSort(String [] a){
        for (int i = 0; i<a.length;i++){
            int indexMin= i;
            for (int j =i;j<a.length;j++){
                if (a[indexMin].compareTo(a[j])>0)
                    indexMin=j;
            }
            a=intercambiar(a,indexMin,i);
        }
        return a;
    }
    //Selection Sort para arreglos de objetos que implementan la interfaz Comparable.
    public Comparable [] selectionSort(Comparable [] a){
        for (int i = 0; i<a.length;i++){
            int indexMin= i;
            for (int j =i;j<a.length;j++){
                if (a[indexMin].compareTo(a[j])>0)
                    indexMin=j;
            }
            a=intercambiar(a,indexMin,i);
        }
        return a;
    }

    /*
    Version recursiva del metodo Selection Sort, recive un arreglo y un indice inicial sobre el cual se empieza el
    ordenamiento.
    El metodo esta implementado para recivir arreglos de enteros, String y objetos Comparable.
     */
    // Selection Sort recursivo para enteros.
    public int[] selectionSortRecursive(int[]a, int indiceInicial){
        if (indiceInicial>=a.length-1)
            return a;
        int min= indiceInicial;
        for(int i = indiceInicial+1;i<a.length;i++){
            if (a[i]<a[min])
                min=i;
        }
        a=intercambiar(a,min, indiceInicial);
        selectionSortRecursive(a,indiceInicial+1);

        return a;
    }
    // Selection Sort recursivo para String.
    public String[] selectionSortRecursive(String[]a, int indiceInicial){
        if (indiceInicial>=a.length-1)
            return a;
        int min= indiceInicial;
        for(int i = indiceInicial+1;i<a.length;i++){
            if (a[i].compareTo(a[min])<0)
                min=i;
        }
        a=intercambiar(a,min, indiceInicial);
        selectionSortRecursive(a,indiceInicial+1);
        return a;
    }
    // Selection Sort recursivo para objetos Comparable.
    public Comparable[] selectionSortRecursive(Comparable[]a, int indiceInicial){
        if (indiceInicial>=a.length-1)
            return a;
        int min= indiceInicial;
        for(int i = indiceInicial+1;i<a.length;i++){
            if (a[i].compareTo(a[min])<0)
                min=i;
        }
        a=intercambiar(a,min, indiceInicial);
        selectionSortRecursive(a,indiceInicial+1);
        return a;
    }

    /*
    El metodo insertionnSort recibe un arreglo de elementos desordenados, y devuelve el mismo arreglo ordenado aplicando
    el metodo de inserción. El metodo de inserción consiste en tomar un elemento del arreglo e ir comparando hacia atras
    con el resto de los elementos hasta encontrar el lugar donde pertenece. Este proceso se repite hasta que se llega al
    ultimo elemento del arreglo.
    El metodo esta implementado para recibir arreglos de enteros, Strings y objetos que implementen la interfaz
    Comparable.
     */
    //insertion sort para arreglos de int
    public int[] insertionSort(int[]a){
        if (a[0]>a[1]) a= intercambiar(a,0,1);
        for (int i = 2;i<a.length-1;i++){
            int temporal= a[i];
            int j=i-1;
            while((j>=0)&&(temporal<a[j])){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temporal;

        }
        return a;
    }
    //insertion sort para arreglos de Strings
    public String[] insertionSort(String[]a){
        if (a[0].compareTo(a[1])>0) a= intercambiar(a,0,1);
        for (int i = 2;i<a.length-1;i++){
            String temporal= a[i];
            int j=i-1;
            while((j>=0)&&(temporal.compareTo(a[j])<0)){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temporal;

        }
        return a;
    }
    //Insertion Sort para arreglos de objetos que implementan la interfaz Comparable
    public Comparable[] insertionSort(Comparable[] a){
        if (a[0].compareTo(a[1])>0) a= intercambiar(a,0,1);
        for (int i = 2;i<a.length-1;i++){
            Comparable temporal= a[i];
            int j=i-1;
            while((j>=0)&&(temporal.compareTo(a[j])<0)){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temporal;

        }
        return a;
    }

    /*
    El metodo bubbleSort recibe un arreglo de elementos desordenados, y devuelve el mismo arreglo ordenado aplicando
    el metodo de Burbujeo. El metodo de burbujeo consiste en ir comparando dos elementos seguidos de un arreglo e
    intercambiarlos si estan desordenados.
    El metodo esta implementado para recibir arreglos de enteros, Strings y objetos que implementen
     la interfaz Comparable.
     */
    //Bubble Sort para arreglos de int
    public int[]bubbleSort(int[]a){
        boolean cambiado = true;
        int j = 0;
        while (cambiado) {
            cambiado = false;
            j++;
            for (int i = 0; i < a.length - j; i++) {
                if (a[i] > a[i + 1]) {
                    a=intercambiar(a,i,i+1);
                    cambiado = true;
                }
            }
        }

        return a;
    }
    //Bubble Sort para arreglos de String
    public String[]bubbleSort(String[]a){
        boolean cambiado = true;
        int j = 0;
        while (cambiado) {
            cambiado = false;
            j++;
            for (int i = 0; i < a.length - j; i++) {
                if (a[i].compareTo(a[i + 1])>0) {
                    a=intercambiar(a,i,i+1);
                    cambiado = true;
                }
            }
        }

        return a;
    }
    //Bubble Sort para arreglos de objetos que implementan la interfaz Comparable
    public Comparable[] bubbleSort(Comparable[] a){
        boolean cambiado = true;
        int j = 0;
        while (cambiado) {
            cambiado = false;
            j++;
            for (int i = 0; i < a.length - j; i++) {
                if (a[i].compareTo(a[i + 1])>0) {
                    a=intercambiar(a,i,i+1);
                    cambiado = true;
                }
            }
        }

        return a;
    }

    /*
    El metodo intercambiar() recibe un arreglo y dos indices del arreglo, e intercambia de lugar los elementos que
    corresponden a los indices dados.
    El metodo esta implementado para recibir un arreglo de enteros, Strings y de objetos que implementan la interfaz
    Comparable.
     */
    //Metodo para cambiar de lugar dos elementos de un arreglo de int
    private int[] intercambiar(int[] a, int index1, int index2){
        int guardarElemento= a[index2];
        a[index2]=a[index1];
        a[index1]=guardarElemento;
        return a;
    }
    //Metodo para cambiar de lugar dos elementos de un arreglo de Strings
    private String[] intercambiar(String[] a, int index1, int index2){
        String guardarElemento= a[index2];
        a[index2]=a[index1];
        a[index1]=guardarElemento;
        return a;
    }
    //Metodo para cambiar de lugar dos elementos de un arreglo de elementos que implementan Comparable
    private Comparable[] intercambiar(Comparable[] a, int index1, int index2){
        Comparable guardarElemento= a[index2];
        a[index2]=a[index1];
        a[index1]=guardarElemento;
        return a;
    }

    /*
    El metodo merge() recibe dos arreglos ordenados, y devuelve un arreglo ordenado en el cual estan los elementos
    que le fueron pasados al metodo.
    El metodo esta implementado para recibir arreglos e enteros y de objetos que implementen la interfaz Comparable.
     */
    //Metodo merge para enteros.
    public Comparable[] merge(Comparable[] a, Comparable[]b){
        Comparable[]c= new Comparable[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        boolean masChicoCompleto=false;
        while (!masChicoCompleto){
            if (a[i].compareTo(b[j])<0){
                c[k]=a[i];
                i++;
            } else{
                c[k]=b[j];
                j++;
            }
            k++;
            if ((i==a.length)||(j==b.length)||(k==c.length)){
                break;
            }
        }
        if ((i==a.length)&&(k<c.length)){
            for (int x=k;x<c.length;x++){
                c[x]=b[j];
                j++;
            }
        } else if ((j==b.length)&&(k<c.length)){
            for (int x=k;x<c.length;x++){
                c[x]=a[i];
                i++;
            }
        }

        return c;
    }

}
