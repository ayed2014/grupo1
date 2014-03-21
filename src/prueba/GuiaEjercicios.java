package prueba;

import pila.Pila;
import pila.PilaE;
import tipo_abstracto_de_datos.Estudiante;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 20/03/14
 * Time: 19:34
 * To change this template use File | Settings | File Templates.
 */
public class GuiaEjercicios {
    public Pila[] ejercicio3(Pila p){
        PilaE par= new PilaE();
        PilaE impar= new PilaE();
        while (!p.esVacia()){
            int tope= (Integer)p.verTope();
            if (tope%2==0){
                par.apilar(tope);
            } else impar.apilar(tope);
            p.desapilar();
        }
        Pila[] separado={par, impar};
        return separado;

    }

    public Pila[] ejercicio4(Pila p){
        PilaE a=new PilaE();
        PilaE b= new PilaE();
        PilaE c= new PilaE();

        while (!p.esVacia()){
            Estudiante tope= (Estudiante)p.verTope();
            int comision= tope.getComision();
            switch (comision){
                case 1:
                    a.apilar(tope);
                    break;
                case 2:
                    b.apilar(tope);
                    break;
                case 3:
                    c.apilar(tope);
                    break;
            }
            p.desapilar();
        }
        Pila[]separados={a,b,c};
        return separados;
    }



}
