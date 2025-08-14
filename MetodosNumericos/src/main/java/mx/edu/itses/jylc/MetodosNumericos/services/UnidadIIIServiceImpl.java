
package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.EliminacionGaussiana;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaCramer;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UnidadIIIServiceImpl implements UnidadIIIService {

   
    @Override
    public ArrayList<EliminacionGaussiana> AlgoritmoEliminacionGaussiana(EliminacionGaussiana eliminaciongaussiana) {
        int n = eliminaciongaussiana.getN();
        double[][] matriz = eliminaciongaussiana.getMatriz();
        ArrayList<EliminacionGaussiana> pasos = new ArrayList<>();

        // Guardar estado inicial
        pasos.add(clonarMatriz(eliminaciongaussiana, matriz));

        // Eliminación Gaussiana hacia adelante
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = matriz[i][k] / matriz[k][k];
                for (int j = k; j <= n; j++) {
                    matriz[i][j] -= factor * matriz[k][j];
                }
            }
            pasos.add(clonarMatriz(eliminaciongaussiana, matriz)); // Guardar paso
        }

        // Sustitución hacia atrás
        double[] resultados = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                suma -= matriz[i][j] * resultados[j];
            }
            resultados[i] = suma / matriz[i][i];
        }

        // Guardar resultados finales
        EliminacionGaussiana finalStep = clonarMatriz(eliminaciongaussiana, matriz);
        finalStep.setResultados(resultados);
        pasos.add(finalStep);

        return pasos;
    }

    // Método auxiliar para clonar el estado de la matriz
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

    

   
}