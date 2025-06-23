
package mx.edu.itses.jylc.MetodosNumericos.domain;
import lombok.Data;

@Data
public class PuntoFijo {
    private String FX; //Funcion a Evaluar
    private double XL;
    private double FXL;
    private int IteracionesMaximas;

}
