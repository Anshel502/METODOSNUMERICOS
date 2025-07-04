package mx.edu.itses.jylc.MetodosNumericos.services;

import static java.lang.Math.abs;
import org.mariuszgromada.math.mxparser.*;

public class Funciones {

    public static double Ecuacion(String f1, double x) {

        double f;
        Function funcion = new Function(f1);
        Expression evaluacion = new Expression("f(" + x + ")", funcion);
        f = evaluacion.calculate();

        return f;
    }
    
    public static double EvaluarG(String Gx, double x) {
        double g;
        Function funcion = new Function(Gx);
        Expression evaluacion = new Expression("G(" + x + ")", funcion);
        g = evaluacion.calculate();
        return g;
    }
    
    public static double ErrorRelativo(double ValorNuevo, double ValorAnterior) {
        return abs((ValorNuevo - ValorAnterior) / ValorNuevo * 100);
    }

 public static double DerivadaNumerica(String f1, double x) {
        double h = 1e-5;
        double fMas = Ecuacion(f1, x + h);
        double fMenos = Ecuacion(f1, x - h);
        return (fMas - fMenos) / (2 * h);
    }
 
 public static double SegundaDerivadaNumerica(String f1, double x) {
    double h = 1e-5;
    double fMas = Ecuacion(f1, x + h);
    double f = Ecuacion(f1, x);
    double fMenos = Ecuacion(f1, x - h);
    return (fMas - 2 * f + fMenos) / (h * h);
}

}
