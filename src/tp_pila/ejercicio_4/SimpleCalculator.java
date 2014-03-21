package tp_pila.ejercicio_4;

import tp_pila.PilaE;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 19/03/14
 * Time: 07:29
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCalculator {


    Scanner keyword = new Scanner(System.in);
    String operation;
    PilaE pila = new PilaE();

    /**
     * Calculate is a method tha calculates an operation given.
     */
    public void calculate() {
        System.out.println("Please enter the operation: (With an equal sign in the end) " + "\n");
        operation = keyword.nextLine();
        int finalResult = 0;
        for (int i = 0; i < operation.length(); i++) {
            boolean isANumber = ((int) operation.charAt(i) >= 48) && ((int) operation.charAt(i) <= 57);
            if (isANumber) {
                pila.apilar(operation.charAt(i));
            } else {
                boolean isAMultiplicationSign = (int) operation.charAt(i) == 42;
                boolean isADivisionSign = (int) operation.charAt(i) == 47;
                boolean isAPlusSign = (int) operation.charAt(i) == 43;
                boolean isAMinusSign = (int) operation.charAt(i) == 45;
                boolean isAEqualSign = (int) operation.charAt(i) == 61;
                if (isAPlusSign || isAMinusSign) {
                    pila.apilar(operation.charAt(i));
                } else if (isAMultiplicationSign || isADivisionSign) {
                    int number1 = Integer.parseInt("" + pila.verTope());
                    pila.desapilar();
                    int number2 = Integer.parseInt("" + operation.charAt(i + 1));
                    if (isAMultiplicationSign) {
                        int multiplicationResult = number1 * number2;
                        pila.apilar(multiplicationResult);
                    } else {
                        int divisionResult = number1 / number2;
                        pila.apilar(divisionResult);
                    }
                    i = i + 1;
                } else if (isAEqualSign) {
                    while (!pila.esVacia()) {
                        int number2 = Integer.parseInt("" + pila.verTope());
                        pila.desapilar();
                        boolean plusSign = pila.verTope().hashCode() == 43;
                        pila.desapilar();
                        int number1 = Integer.parseInt("" + pila.verTope());
                        pila.desapilar();
                        if (plusSign) {
                            int plusResult = number1 + number2;
                            if (!pila.esVacia()) {
                                pila.apilar(plusResult);
                            } else {
                                finalResult = plusResult;
                            }
                        } else {
                            int subtractionResult = number1 - number2;
                            if (!pila.esVacia()) {
                                pila.apilar(subtractionResult);
                            } else {
                                finalResult = subtractionResult;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The operation enter was: " + operation);
        System.out.println("Result is: " + finalResult);


    }
}
