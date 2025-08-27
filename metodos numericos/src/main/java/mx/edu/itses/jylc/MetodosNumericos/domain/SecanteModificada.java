/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.domain;

import lombok.Data;

/**
 *
 * @author StarC
 */
@Data
public class SecanteModificada {
    private String FX; // Función a evaluar
    private double Sigma, XI, XII, FXIS, FXI, Ea; 
    private int IteracionesMaximas;
}
