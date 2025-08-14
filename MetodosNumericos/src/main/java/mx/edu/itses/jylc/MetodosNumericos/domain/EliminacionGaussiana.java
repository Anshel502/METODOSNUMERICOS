package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class EliminacionGaussiana {

     private int n;              
    private double[][] matriz;  
    private double[] resultados;
}
