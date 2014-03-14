package tipo_abstracto_de_datos;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 12/03/14
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 */
public class NumeroComplejo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplejo(double parteReal, double parteImaginaria){
        this.parteReal=parteReal;
        this.parteImaginaria= parteImaginaria;
    }
    public void keyboardRead (){
        //parteReal= Scanner.getDouble("Ingrese la parte real del numero complejo\n");
        //parteImaginaria= Scanner.getDouble("Ingrese la parte imaginara del numero complejo\n");
    }
    public void imprimirPantalla(){
        System.out.println(parteReal+"+"+parteImaginaria+"i" );
    }

    public NumeroComplejo suma(NumeroComplejo complejo2){
        return new NumeroComplejo(complejo2.parteReal()+parteReal, parteImaginaria+complejo2.parteImaginaria());
    }
    public NumeroComplejo resta(NumeroComplejo complejo2){
        return new NumeroComplejo(parteReal-complejo2.parteReal(), parteImaginaria-complejo2.parteImaginaria());
    }
    public NumeroComplejo producto(NumeroComplejo complejo2){
        double realProd=(parteReal*complejo2.parteReal())-(parteImaginaria*complejo2.parteImaginaria());
        double imagProd=(parteReal*complejo2.parteReal())+(parteImaginaria*complejo2.parteImaginaria());
        return new NumeroComplejo(realProd,imagProd) ;
    }
    public NumeroComplejo cociente(NumeroComplejo complejo2){
        double cocienteReal = (parteReal*complejo2.parteReal() + parteImaginaria*complejo2.parteImaginaria())
                /((complejo2.parteReal()*complejo2.parteReal()) + (complejo2.parteImaginaria()*complejo2.parteImaginaria()));
        double cocienteImag = ((parteImaginaria*complejo2.parteReal()) - parteImaginaria*complejo2.parteImaginaria())
                /((complejo2.parteReal()*complejo2.parteReal()) + (complejo2.parteImaginaria()*complejo2.parteImaginaria()));
        return new NumeroComplejo(cocienteReal,cocienteImag);
    }
    public double modulo(){
        double modulo = Math.sqrt(parteReal*parteReal+parteImaginaria*parteImaginaria);
        return modulo;
    }
    public double parteReal(){
        return parteReal;
    }
    public double parteImaginaria(){
        return parteImaginaria;
    }

}
