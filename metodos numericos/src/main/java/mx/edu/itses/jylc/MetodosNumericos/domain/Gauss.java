
package mx.edu.itses.jylc.MetodosNumericos.domain;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author josue
 */
@Data
public class Gauss {
      private Integer MN;                     
    private ArrayList<Double> matrizA;        
    private ArrayList<Double> vectorB;       
    private ArrayList<Double> vectorX; 
    private ArrayList<String> pasos;  
    private ArrayList<Double> matrizUEscalonada; 
    private boolean singular;      
    private String mensaje;   
}
