package mx.edu.itses.jylc.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.jylc.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.jylc.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaFalsa;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UnidadIIServiceImpl implements UnidadIIService {

    @Override
    public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion) {
        ArrayList<Biseccion> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = biseccion.getXL();
        XU = biseccion.getXU();
        XRa = 0;
        Ea = 100;
        // Verificamos que en el intervalo definido haya un cambio de signo
        FXL = Funciones.Ecuacion(biseccion.getFX(), XL);
        FXU = Funciones.Ecuacion(biseccion.getFX(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= biseccion.getIteracionesMaximas(); i++) {
                XRn = (XL + XU) / 2;
                FXL = Funciones.Ecuacion(biseccion.getFX(), XL);
                FXU = Funciones.Ecuacion(biseccion.getFX(), XU);
                FXR = Funciones.Ecuacion(biseccion.getFX(), XRn);
                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }
                Biseccion renglon = new Biseccion();
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);
                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else if (FXL * FXR == 0) {
                    break;
                }
                XRa = XRn;
                respuesta.add(renglon);
                if (Ea <= biseccion.getEa()) {
                    break;
                }
            }
        } else {
            Biseccion renglon = new Biseccion();
            // renglon.setIntervaloInvalido(true);
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override
    public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa) {
        ArrayList<ReglaFalsa> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = reglafalsa.getXL();
        XU = reglafalsa.getXU();
        XRa = 0;
        Ea = 100;
        // Verificamos que en el intervalo definido haya un cambio de signo
        FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
        FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= reglafalsa.getIteracionesMaximas(); i++) {
                XRn = XU - (((FXU) * (XL - XU)) / (FXL - FXU));
                FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
                FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
                FXR = Funciones.Ecuacion(reglafalsa.getFX(), XRn);
                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }
                ReglaFalsa renglon = new ReglaFalsa();
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);
                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else if (FXL * FXR == 0) {
                    break;
                }
                XRa = XRn;
                respuesta.add(renglon);
                if (Ea <= reglafalsa.getEa()) {
                    break;
                }
            }
        } else {
            ReglaFalsa renglon = new ReglaFalsa();
            // renglon.setIntervaloInvalido(true);
            respuesta.add(renglon);
        }

        return respuesta;
    }
    
@Override
    public ArrayList<PuntoFijo> AlgoritmoPuntoFijo(PuntoFijo puntofijo) {
        ArrayList<PuntoFijo> respuesta = new ArrayList<>();
        double XL, XR, Ea;
        double errorAprox = 100;
        int iterMax = puntofijo.getIteracionesMaximas();

        XL = puntofijo.getXL();
        Ea = puntofijo.getEa();

        for (int i = 1; i <= iterMax; i++) {
            XR = Funciones.EvaluarG(puntofijo.getGX(), XL);  

            if (i != 1) {
                errorAprox = Funciones.ErrorRelativo(XR, XL);
                if (Double.isNaN(errorAprox)) {
                    log.error("Error relativo inválido en iteración {}. XL={}, XR={}", i, XL, XR);
                    break;
                }
            }

            PuntoFijo renglon = new PuntoFijo();
            renglon.setXL(XL);
            renglon.setXR(XR);
            renglon.setEa(errorAprox);
            renglon.setGX(puntofijo.getGX());
            renglon.setIteracionesMaximas(iterMax);
            respuesta.add(renglon);

            if (errorAprox <= Ea) {
                break;
            }

            XL = XR;
        }

        return respuesta;
    }

    @Override
    public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphson(NewtonRaphson newtonraphson) {
        ArrayList<NewtonRaphson> respuesta = new ArrayList<>();

        double XL = newtonraphson.getXL(); 
        double XR ;                   
        double errorAprox = 100;          
        double tolerancia = newtonraphson.getEa();
        int iterMax = newtonraphson.getIteracionesMaximas();
        String funcion = newtonraphson.getFX();

        for (int i = 1; i <= iterMax; i++) {
            double fx = Funciones.Ecuacion(funcion, XL);
            double derivada = Funciones.DerivadaNumerica(funcion, XL);

            if (derivada == 0) {
                log.error("Derivada igual a cero en iteración {}. XL = {}", i, XL);
                break;
            }

            XR = XL - (fx / derivada);


            NewtonRaphson renglon = new NewtonRaphson();
            renglon.setXL(XL);
            renglon.setXR(XR);
            renglon.setEa(errorAprox);
            renglon.setIteracionesMaximas(iterMax);
            respuesta.add(renglon);

            
            if (errorAprox <= tolerancia) {
                break;
            }

            XL = XR; 
        }

        return respuesta;
    }




        
        
        
}


