package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.jylc.MetodosNumericos.domain.EliminacionGaussiana;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussJordan;

public interface UnidadIIIService {

    //public ArrayList<ReglaCramer> AlgoritmoReglaCramer(ReglaCramer modelCramer);

    public ArrayList<EliminacionGaussiana> AlgoritmoEliminacionGaussiana(EliminacionGaussiana eliminaciongaussiana);
    ArrayList<GaussJordan> AlgoritmoGaussJordan(GaussJordan gaussJordan);

} 

    

