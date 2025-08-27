package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.jylc.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.jylc.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.jylc.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.jylc.MetodosNumericos.domain.Secante;
import mx.edu.itses.jylc.MetodosNumericos.domain.SecanteModificada;

public interface UnidadIIService {
   
      public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion);
      public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa regulafalsi);
      public ArrayList<PuntoFijo> AlgoritmoPuntoFijo (PuntoFijo fixedpoint);
      public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphon (NewtonRaphson newtonraphson);
      public ArrayList<Secante> AlgoritmoSecante (Secante secant);
      public ArrayList<SecanteModificada> AlgoritmoSecanteModificado  (SecanteModificada modsecant);
      
}
