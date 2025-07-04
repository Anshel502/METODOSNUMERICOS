package mx.edu.itses.jylc.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.jylc.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.jylc.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.jylc.MetodosNumericos.domain.Secante;
import mx.edu.itses.jylc.MetodosNumericos.domain.SecanteModificado;
import mx.edu.itses.jylc.MetodosNumericos.services.UnidadIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Unit2Controller {

    @Autowired
    private UnidadIIService UnidadService;
   

    @GetMapping("/unit2")
    public String index(Model model){
    return "unit2/index";
    }
    
    @GetMapping("unit2/formbisection")
    public String formBisecccion(Model model) {
        Biseccion bisection = new Biseccion();

        model.addAttribute("bisection", bisection);
        return "unit2/bisection/formbisection";
    }
    @GetMapping("unit2/formsecante")
    public String formSecante(Model model) {
        Secante secante = new Secante();

        model.addAttribute("secante", secante);
        return "unit2/secante/formsecante";
    }
    @GetMapping("unit2/formsecantemodificado")
    public String formSecanteModificado(Model model) {
        SecanteModificado secantemodificado = new SecanteModificado();

        model.addAttribute("secantemodificado", secantemodificado);
        return "unit2/secantemodificado/formsecantemodificado";
    }

    @GetMapping("unit2/formreglafalsa")
    public String formReglaFalsa(Model model) {
        ReglaFalsa reglafalsa = new ReglaFalsa();

        model.addAttribute("reglafalsa", reglafalsa);
        return "unit2/reglafalsa/formreglafalsa";
    }

    @GetMapping("unit2/formpuntofijo")
    public String formPuntoFijo(Model model) {
        PuntoFijo puntofijo = new PuntoFijo();

        model.addAttribute("puntofijo", puntofijo);
        return "unit2/puntofijo/formpuntofijo";
    }

    @GetMapping("unit2/formnewtonrapshon")
    public String formNewtonRaphson(Model model) {
        NewtonRaphson newtonraphson = new NewtonRaphson();
        model.addAttribute("newtonraphson", newtonraphson);
        return "/unit2/newtonraphson/formnewtonrapshon";
    }

    @PostMapping("/unit2/solvebisection")
    public String solvebisection(Biseccion bisection, Model model) {
        //  double valorFX=Funciones.Ecuacion(bisection.getFx(), bisection.getXl());
        //  log.info("Valor de Fx:"+valorFX);
        var solveBisection = UnidadService.AlgoritmoBiseccion(bisection);

        log.info("Arreglo" + solveBisection);
        model.addAttribute("solveBisection", solveBisection);

        return "/unit2/bisection/solvebisection";
    }

    @PostMapping("/unit2/solvereglafalsa")
    public String solvereglafalsa(ReglaFalsa reglafalsa, Model model) {
        var solveReglaFalsa = UnidadService.AlgoritmoReglaFalsa(reglafalsa);

        log.info("Arreglo" + solveReglaFalsa);
        model.addAttribute("solveReglaFalsa", solveReglaFalsa);

        return "/unit2/reglafalsa/solvereglafalsa";
    }
    @PostMapping("/unit2/solvesecante")
    public String solvesecante(Secante secante, Model model) {
        var solveSecante = UnidadService.AlgoritmoSecante(secante);

        log.info("Arreglo" + solveSecante);
        model.addAttribute("solveSecante", solveSecante);

        return "/unit2/secante/solvesecante";
    }
    @PostMapping("/unit2/solvesecantemodificado")
    public String solvesecantemodificado(SecanteModificado secantemodificado, Model model) {
        var solveSecanteModificado = UnidadService.AlgoritmoSecanteModificado(secantemodificado);

        log.info("Arreglo" + solveSecanteModificado);
        model.addAttribute("solveSecanteModificado", solveSecanteModificado);

        return "/unit2/secantemodificado/solvesecantemodificado";
    }

    @PostMapping("/unit2/solvepuntofijo")
    public String solvepuntofijo(PuntoFijo puntofijo, Model model) {
        var solvePuntoFijo = UnidadService.AlgoritmoPuntoFijo(puntofijo);

        log.info("Arreglo" + solvePuntoFijo);
        model.addAttribute("solvePuntoFijo", solvePuntoFijo);

        return "/unit2/puntofijo/solvepuntofijo";
    }

    @PostMapping("/unit2/solvenewtonraphson")
    public String solvenewtonraphson(NewtonRaphson newtonraphson, Model model) {
        var solveNewtonRaphson = UnidadService.AlgoritmoNewtonRaphson(newtonraphson);

        log.info("Arreglo" + solveNewtonRaphson);
        model.addAttribute("solveNewtonRaphson", solveNewtonRaphson);

        return "/unit2/newtonraphson/solvenewtonraphson";
    }
    
    
}
