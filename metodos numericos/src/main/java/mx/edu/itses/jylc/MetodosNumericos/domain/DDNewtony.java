/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.domain;

import java.util.ArrayList;
import lombok.Data;

@Data

public class DDNewtony {
        private Integer orden;
    private ArrayList<Double> xs;   
    private ArrayList<Double> ys;   
    private Double xEval;
    private ArrayList<Double> coeficientes;        
    private ArrayList<Double> tablaAplanada;     
    private Double yEval;  
}
