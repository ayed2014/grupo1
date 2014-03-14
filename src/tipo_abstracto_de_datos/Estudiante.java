package tipo_abstracto_de_datos;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 12/03/14
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class Estudiante {
    private int matricula;
    private int comision;

    public Estudiante(int matricula, int comision){
        this.comision= comision;
        this.matricula= matricula;
    }
    public void setMatricula(int matricula){
        this.matricula=matricula;
    }
    public void setComision(int comision){
        this.comision=comision;
    }
    public int getComision(){
        return comision;
    }
    public int getMatricula(){
        return comision;
    }
}
