
package mx.edu.itses.jylc.MetodosNumericos.domain;
import lombok.Data;

@Data
public class Secante {
    private String FX;
    private double X0;
    private double X1;
    private double Ea; //Error aprox
    private int IteracionesMaximas;

}
