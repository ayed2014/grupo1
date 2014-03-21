package tp_pila.ejercicio_2;

import tp_pila.PilaE;

import java.io.*;

/**
 * Created by Nash on 20/03/14.
 */
public class Ej2 {
    public static boolean analizador(File fileToRead){
        PilaE simbolos = new PilaE();
        char[] chars;
        String linea;
        char aux;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            while ((linea = reader.readLine()) != null) {
                chars = linea.toCharArray();
                for (char ch : chars) {
                    switch (ch){
                        case '{':
                            simbolos.apilar('{');
                            break;
                        case '}':
                            if (simbolos.esVacia()){
                                return false;
                            }
                            aux = (char) simbolos.verTope();
                            if (aux != '{') {
                                return false;
                            }

                            else {
                                simbolos.desapilar();
                            }
                            break;
                        case '[':
                            simbolos.apilar('[');
                            break;
                        case ']':
                            if (simbolos.esVacia()){
                                return false;
                            }
                            aux = (char) simbolos.verTope();
                            if (aux != '[') {
                                return false;
                            }

                            else {
                                simbolos.desapilar();
                            }
                            break;
                        case '(':
                            simbolos.apilar('(');
                            break;
                        case ')':
                            if (simbolos.esVacia()){
                                return false;
                            }
                            aux = (char) simbolos.verTope();
                            if (aux != '(') {
                                return false;
                            }

                            else {
                                simbolos.desapilar();
                            }
                            break;
                    }
                }
            }
        } catch (IOException  h) {
            h.printStackTrace();

        }
        return true;

    }
}
