
package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class SecanteModificado {
    private String FX;
    private double X;           // Valor inicial
    private double Ea;          // Error aproximado deseado
    private int IteracionesMaximas;

    private double FX1;
    private double FX2;
    private double Xsig;   // xi+1
}