package mx.edu.itses.jylc.MetodosNumericos.services;

//ArrayList
import mx.edu.itses.jylc.MetodosNumericos.domain.Gauss;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussJordan;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussSeidel;
import mx.edu.itses.jylc.MetodosNumericos.domain.Jacobi;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaCramer;

public interface UnidadIIIService {
    
    public ReglaCramer AlgoritmoReglaCramer (ReglaCramer modelCramer);
    
    public GaussJordan AlgoritmoGaussJordan(GaussJordan modelGaussJordan);
    
    public Gauss AlgoritmoGauss(Gauss modelGauss);
    
     public Jacobi AlgoritmoJacobi(Jacobi modelJacobi);
    
    public GaussSeidel AlgoritmoGaussSeidel(GaussSeidel modelGaussSeidel);


}
