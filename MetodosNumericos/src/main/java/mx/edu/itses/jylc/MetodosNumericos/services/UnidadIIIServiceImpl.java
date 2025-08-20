
package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.EliminacionGaussiana;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussJordan;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussSeidel;
import mx.edu.itses.jylc.MetodosNumericos.domain.Jacobi;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UnidadIIIServiceImpl implements UnidadIIIService {

   
    @Override
    public ArrayList<EliminacionGaussiana> AlgoritmoEliminacionGaussiana(EliminacionGaussiana eliminaciongaussiana) {
        int n = eliminaciongaussiana.getN();
        double[][] matriz = eliminaciongaussiana.getMatriz();
        ArrayList<EliminacionGaussiana> pasos = new ArrayList<>();

        pasos.add(clonarMatriz(eliminaciongaussiana, matriz));

        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = matriz[i][k] / matriz[k][k];
                for (int j = k; j <= n; j++) {
                    matriz[i][j] -= factor * matriz[k][j];
                }
            }
            pasos.add(clonarMatriz(eliminaciongaussiana, matriz));
        }

        double[] resultados = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                suma -= matriz[i][j] * resultados[j];
            }
            resultados[i] = suma / matriz[i][i];
        }

        EliminacionGaussiana finalStep = clonarMatriz(eliminaciongaussiana, matriz);
        finalStep.setResultados(resultados);
        pasos.add(finalStep);

        return pasos;
    }

    private EliminacionGaussiana clonarMatriz(EliminacionGaussiana model, double[][] matrizOriginal) {
        int n = model.getN();
        double[][] copia = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrizOriginal[i], 0, copia[i], 0, n + 1);
        }
        EliminacionGaussiana paso = new EliminacionGaussiana();
        paso.setN(n);
        paso.setMatriz(copia);
        return paso;
    }

    @Override
public ArrayList<GaussJordan> AlgoritmoGaussJordan(GaussJordan gaussJordan) {
    int n = gaussJordan.getN();
    double[][] matriz = gaussJordan.getMatriz();
    ArrayList<GaussJordan> pasos = new ArrayList<>();

    pasos.add(clonarMatriz(gaussJordan, matriz));

    for (int k = 0; k < n; k++) {
        double pivote = matriz[k][k];
        for (int j = 0; j <= n; j++) {
            matriz[k][j] /= pivote;
        }

        for (int i = 0; i < n; i++) {
            if (i != k) {
                double factor = matriz[i][k];
                for (int j = 0; j <= n; j++) {
                    matriz[i][j] -= factor * matriz[k][j];
                }
            }
        }

        pasos.add(clonarMatriz(gaussJordan, matriz)); 
    }

    double[] resultados = new double[n];
    for (int i = 0; i < n; i++) {
        resultados[i] = matriz[i][n];
    }

    GaussJordan finalStep = clonarMatriz(gaussJordan, matriz);
    finalStep.setResultados(resultados);
    pasos.add(finalStep);

    return pasos;
}

private GaussJordan clonarMatriz(GaussJordan model, double[][] matrizOriginal) {
    int n = model.getN();
    double[][] copia = new double[n][n + 1];
    for (int i = 0; i < n; i++) {
        System.arraycopy(matrizOriginal[i], 0, copia[i], 0, n + 1);
    }
    GaussJordan paso = new GaussJordan();
    paso.setN(n);
    paso.setMatriz(copia);
    return paso;
}

@Override
public ArrayList<Jacobi> AlgoritmoJacobi(Jacobi jacobi) {
    int n = jacobi.getN();
    double[][] matriz = jacobi.getMatriz(); 
    double[] x = jacobi.getX0().clone();    
    double[] xNuevo = new double[n];

    int maxIter = jacobi.getIteracionesMax();
    double tol = jacobi.getTol();

    ArrayList<Jacobi> pasos = new ArrayList<>();

    for (int k = 0; k < maxIter; k++) {
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    suma += matriz[i][j] * x[j];
                }
            }
            xNuevo[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        Jacobi paso = new Jacobi();
        paso.setN(n);
        paso.setMatriz(clonarMatriz(matriz, n));
        paso.setX0(xNuevo.clone()); 
        pasos.add(paso);

        double error = 0;
        for (int i = 0; i < n; i++) {
            error += Math.abs(xNuevo[i] - x[i]);
        }
        if (error < tol) {
            break;
        }

        x = xNuevo.clone();
    }

    Jacobi finalStep = new Jacobi();
    finalStep.setN(n);
    finalStep.setMatriz(clonarMatriz(matriz, n));
    finalStep.setResultados(xNuevo.clone());
    pasos.add(finalStep);

    return pasos;
}

private double[][] clonarMatriz(double[][] original, int n) {
    double[][] copia = new double[n][n + 1];
    for (int i = 0; i < n; i++) {
        System.arraycopy(original[i], 0, copia[i], 0, n + 1);
    }
    return copia;
}

@Override
public ArrayList<GaussSeidel> AlgoritmoGaussSeidel(GaussSeidel gaussSeidel) {
    int n = gaussSeidel.getN();
    double[][] matriz = gaussSeidel.getMatriz();  
    double[] x = gaussSeidel.getX0().clone();      

    int maxIter = gaussSeidel.getIteraciones();
    double tol = gaussSeidel.getTolerancia();

    ArrayList<GaussSeidel> pasos = new ArrayList<>();

    for (int k = 0; k < maxIter; k++) {
        double[] xAnterior = x.clone();

        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    suma += matriz[i][j] * x[j]; 
                }
            }
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        GaussSeidel paso = new GaussSeidel();
        paso.setN(n);
        paso.setMatriz(clonarMatriz(matriz, n));
        paso.setX0(x.clone());
        pasos.add(paso);

        double error = 0;
        for (int i = 0; i < n; i++) {
            error += Math.abs(x[i] - xAnterior[i]);
        }
        if (error < tol) break;
    }

    GaussSeidel finalStep = new GaussSeidel();
    finalStep.setN(n);
    finalStep.setMatriz(clonarMatriz(matriz, n));
    finalStep.setX0(x.clone()); 
    pasos.add(finalStep);

    return pasos;
}


   
}