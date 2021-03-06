package reglafalsa;

import java.util.Scanner;

/**
 *
 * @author Ariel AB
 */
public class ReglaFalsa {

    Scanner teclado = new Scanner(System.in);

    private void reglaFalsa(double limIzq, double limDer, double error) {
        double xI = limIzq;
        double xD = limDer;
        double eMax = error;
        double fxI = f(xI);
        double fxD = f(xD);
        double xM = xMedia(xI, xD, fxI, fxD);
        double fxM = f(xM);

        double eAprox = 1;                                                      //Usados Para error aproximado
        double xMedAnterior = 0;

        short contador = 0;

        if ((fxI > 0 && fxD > 0) || ((fxI < 0 && fxD < 0))) {                    //Verifica si existe raiz entre xi y xd
            System.out.println("Sin raíces en este intervalo");
            return;
        }

        System.out.println("Valores iniciales: X izq= " + xI + "  X der= " + xD
                + " Error: " + eMax);

        while (Math.abs(eAprox) >= eMax) {
            System.out.println("\n\nIteracion #" + contador);
            System.out.print("X media= ");
            System.out.printf("%06f", xM);
            System.out.print("\nF(X) izquierda= ");
            System.out.printf("%06f", fxI);
            System.out.print("\nF(X) derecha= ");
            System.out.printf("%06f", fxD);
            System.out.print("\nF(X) media= ");
            System.out.printf("%06f", fxM);

            if (fxM * fxI > 0) {
                xI = xM;
                xMedAnterior = xI;

            } else {
                xD = xM;
                xMedAnterior = xD;
            }

            fxI = f(xI);
            fxD = f(xD);
            xM = xMedia(xI, xD, fxI, fxD);
            fxM = f(xM);

            eAprox = ((xM - xMedAnterior) / xM) * 100;                          //Calcular error aproximado

            contador++;
            System.out.print("\nNueva X izq= ");
            System.out.printf("%06f", xI);
            System.out.print("\nNueva X der= ");
            System.out.printf("%06f", xD);

        }
        System.out.println("\n\nIteracion #" + contador);
        System.out.print("X media= ");
        System.out.printf("%06f", xM);
        System.out.print("\nF(X) izquierda= ");
        System.out.printf("%06f", fxI);
        System.out.print("\nF(X) derecha= ");
        System.out.printf("%06f", fxD);
        System.out.print("\nF(X) media= ");
        System.out.printf("%06f", fxM);
        System.out.print("\n\nRaiz: ");
        System.out.printf("%06f", xM);
        System.out.print("\nF(X) media= ");
        System.out.printf("%06f", fxM);
        System.out.println();

    }

    private double f(double x) {
        double fx;
      //fx = (double) (-12 * (Math.pow(x, 5))) - (6.4 * (Math.pow(x, 3))) + 12; //metodo para calcular F(x)
        fx = (double) (1 - (0.6 * x)) / x;                                      //Updated
        return fx;
    }

    private double xMedia(double xI, double xD, double fxI, double fxD) {       //metodo para calcular xM (en biseccion)
        return (((xI * fxD) - (xD * fxI)) / (fxD - fxI));
    }

    public void main() {
        double limIzq;
        double limDer;
        double error;
        System.out.println("Ingrese el limite izquierdo:");
        limIzq = teclado.nextDouble();
        System.out.println("Ingrese el limite derecho:");
        limDer = teclado.nextDouble();
        System.out.println("Ingrese el error máximo:");
        error = teclado.nextDouble();
        reglaFalsa(limIzq, limDer, error);
    }
}
