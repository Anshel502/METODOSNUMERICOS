/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.services;

import mx.edu.itses.jylc.MetodosNumericos.domain.DDNewtony;
import mx.edu.itses.jylc.MetodosNumericos.domain.Lagrange;

/**
 *
 * @author josue
 */
public interface UnidadIVService {

    public DDNewtony AlgoritmoDDNewton(DDNewtony model);
    
    
    public Lagrange AlgoritmoLagrange(Lagrange model);
}