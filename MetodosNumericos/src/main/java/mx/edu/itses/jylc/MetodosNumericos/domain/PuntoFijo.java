package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class PuntoFijo {

    private String GX;
    private double XL;              
    private double FXL;             
    private double Ea;              
    private int IteracionesMaximas; 
    private int iteracion;  
}
