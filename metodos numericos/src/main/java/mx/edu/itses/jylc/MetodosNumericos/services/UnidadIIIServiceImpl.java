package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaCramer;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UnidadIIIServiceImpl implements UnidadIIIService {

    @Override
    public ReglaCramer AlgoritmoReglaCramer(ReglaCramer modelCramer) {
        //Almacenamos los determinantes de las matrices
        ArrayList<Double> determinantes = new ArrayList<>();
        
        ArrayList<Double> vectorX = new ArrayList<>();
        switch (modelCramer.getMN()) {
            case 2 -> {
                ArrayList<Double> A = modelCramer.getMatrizA();
                ArrayList<Double> b = modelCramer.getVectorB();

                double[][] MatrizA = {
                    {A.get(0), A.get(1)},
                    {A.get(2), A.get(3)}
                };

                determinantes.add(Det2(MatrizA));
                log.info("Det A: " + determinantes.get(0));
                double[][] MatrizX1 = {
                    {b.get(0), A.get(1)},
                    {b.get(1), A.get(3)}
                };
                determinantes.add(Det2(MatrizX1));
                log.info("Det X1: " + determinantes.get(1));
                
                double[][] MatrizX2 = {
                    {A.get(0), b.get(0)},
                    {A.get(2), b.get(1)}
                };
                determinantes.add(Det2(MatrizX2));
                log.info("Det X2: " + determinantes.get(2));
                
                vectorX.add(determinantes.get(1)/determinantes.get(0));
                vectorX.add(determinantes.get(2)/determinantes.get(0));
            }
            case 3 -> {
                ArrayList<Double> A = modelCramer.getMatrizA();
                ArrayList<Double> b = modelCramer.getVectorB();
               double[][] MatrizA = new double[modelCramer.getMN()][modelCramer.getMN()];
               int index = 0;
                for (int i = 0; i < modelCramer.getMN(); i++) {
                    for (int j = 0; j < modelCramer.getMN(); j++) { 
                        MatrizA[i][j] = A.get(index);
                        index++;
                    }
                }
                 double[][] MatrizX1 = {
                    {b.get(0), A.get(1), A.get(2)},
                    {b.get(1), A.get(4), A.get(5)},
                    {b.get(2), A.get(7), A.get(8)}
                };
                 double[][] MatrizX2 = {
                    {A.get(0), b.get(0), A.get(2)},
                    {A.get(3), b.get(1), A.get(5)},
                    {A.get(6), b.get(2), A.get(8)}
                };
                 double[][] MatrizX3 = {
                    {A.get(0), A.get(1), b.get(0)},
                    {A.get(3), A.get(4), b.get(1)},
                    {A.get(6), A.get(7), b.get(2)}
                };

                determinantes.add(Det3(MatrizA));
                determinantes.add(Det3(MatrizX1));
                determinantes.add(Det3(MatrizX2));
                determinantes.add(Det3(MatrizX3));
                
                 // Resolucion de las variables
                vectorX.add(determinantes.get(1)/determinantes.get(0));
                vectorX.add(determinantes.get(2)/determinantes.get(0));
                vectorX.add(determinantes.get(3)/determinantes.get(0));
            }
        }
        modelCramer.setVectorX(vectorX);
        modelCramer.setDeterminantes(determinantes);
        return modelCramer;
    }

    private double Det2(double[][] A) {
        return A[0][0] * A[1][1] - A[0][1] * A[1][0];
    }
    private double Det3(double[][] A) {
       double D = A[0][0]*Det2(new double[][]{
           {A[1][1], A[1][2]},
           {A[2][1], A[2][2]}
       }) 
          -  A[0][1]*Det2(new double[][]{
           {A[1][0], A[1][2]},
           {A[2][0], A[2][2]}
       }) + A[0][2]*Det2(new double[][]{
           {A[1][0], A[1][1]},
           {A[2][0], A[2][1]}
       });
        
        return D;
    }

}
