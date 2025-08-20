package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class Jacobi {
    private int n;                    
    private double[][] matriz;         
    private double[] x0;              
    private double tol;              
    private int iteracionesMax;        
    private double[] resultados;       
}
