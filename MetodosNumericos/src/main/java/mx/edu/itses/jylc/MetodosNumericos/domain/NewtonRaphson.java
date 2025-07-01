
package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class NewtonRaphson {
     private String FX; //Funcion a Evaluar
    private double XL;
    private double XR;
     private double Ea;
    private int IteracionesMaximas;
}
