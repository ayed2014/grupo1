package busqueda;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 11/03/14
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public class Avion implements Comparable {
    String compania;
    int numeroDeAvion;

    public Avion(String compania, int numeroDeAvion){
        this.compania= compania;
        this.numeroDeAvion=numeroDeAvion;
    }
    public String getCompania(){
        return compania;
    }
    public int getNumeroDeAvion(){
        return numeroDeAvion;
    }

    @Override
    public int compareTo(Object o) {
        Avion avion2 = (Avion)o;
        if (compania.compareTo(avion2.getCompania())<0){
            return -1;
        } if (compania.compareTo(avion2.getCompania())>0){
            return 1;
        } else if (numeroDeAvion<avion2.getNumeroDeAvion()){
            return -1;
        } else if (numeroDeAvion>avion2.getNumeroDeAvion()){
            return 1;
        } else return 0;
    }
}
