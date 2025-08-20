/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

@Data
public class GaussSeidel {
    private int n;                
    private double[][] matriz;   
    private double[] x0;           
    private int iteraciones;       
    private double tolerancia;     
}
