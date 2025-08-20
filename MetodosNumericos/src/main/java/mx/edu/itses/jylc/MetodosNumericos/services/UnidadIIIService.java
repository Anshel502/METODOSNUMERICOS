package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.jylc.MetodosNumericos.domain.EliminacionGaussiana;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussJordan;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussSeidel;
import mx.edu.itses.jylc.MetodosNumericos.domain.Jacobi;

public interface UnidadIIIService {

    //public ArrayList<ReglaCramer> AlgoritmoReglaCramer(ReglaCramer modelCramer);

    public ArrayList<EliminacionGaussiana> AlgoritmoEliminacionGaussiana(EliminacionGaussiana eliminaciongaussiana);
    ArrayList<GaussJordan> AlgoritmoGaussJordan(GaussJordan gaussJordan);
    public ArrayList<Jacobi> AlgoritmoJacobi(Jacobi jacobi);
public ArrayList<GaussSeidel> AlgoritmoGaussSeidel(GaussSeidel gaussseidel);

} 

    

