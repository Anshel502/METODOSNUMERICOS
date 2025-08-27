package mx.edu.itses.jylc.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.jylc.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.jylc.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.jylc.MetodosNumericos.domain.Secante;
import mx.edu.itses.jylc.MetodosNumericos.domain.SecanteModificada;
import mx.edu.itses.jylc.MetodosNumericos.services.UnidadIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class Unit2Controller {
   @Autowired
    private UnidadIIService unidadIIservice;
    
    
    
    @GetMapping("/unit2")
    public String index(Model model){
        return "unit2/index";
    }
    
    
    @GetMapping("/unit2/formbisection")
    public String formBisection(Model model) {

        Biseccion bisection = new Biseccion();

        model.addAttribute("bisection", bisection);

        return "unit2/bisection/formbisection";
    }

    @PostMapping("/unit2/solvebisection")
    public String solvebisection(Biseccion bisection, Model model) {

  
        var solveBisection = unidadIIservice.AlgoritmoBiseccion(bisection);

        model.addAttribute("solveBisection", solveBisection);
        return "/unit2/bisection/solvebisection";
        // return "index";
    }



    @GetMapping("/unit2/formpuntofijo")
    public String formPuntoFijo(Model model) {
        PuntoFijo puntofijo = new PuntoFijo();

        model.addAttribute("puntofijo", puntofijo);

        return "unit2/puntofijo/formpuntofijo";
    }

    @PostMapping("/unit2/solvepuntofijo")
    public String solvepuntofijo(PuntoFijo puntofijo, Model model) {
        var solvePuntoFijo = unidadIIservice.AlgoritmoPuntoFijo(puntofijo);

        model.addAttribute("solvePuntoFijo", solvePuntoFijo);
        return "/unit2/puntofijo/solvepuntofijo";
    }
    
        @GetMapping("/unit2/formreglafalsa")
    public String formReglaFalsa(Model model) {

        ReglaFalsa reglafalsa = new ReglaFalsa();

        model.addAttribute("reglafalsa", reglafalsa);

        return "unit2/reglafalsa/formreglafalsa";
    }

    @PostMapping("/unit2/solvereglafalsa")
    public String solvereglafalsa(ReglaFalsa reglafalsa, Model model) {

        var solveReglaFalsa = unidadIIservice.AlgoritmoReglaFalsa(reglafalsa);

        model.addAttribute("solveReglaFalsa", solveReglaFalsa);
        return "/unit2/reglafalsa/solvereglafalsa";
    }

    @GetMapping("/unit2/formnewtonraphson")
    public String formNewtonRaphson(Model model) {
        NewtonRaphson newtonraphson = new NewtonRaphson();

        model.addAttribute("newtonraphson", newtonraphson);

        return "unit2/newtonraphson/formnewtonraphson";
    }

    @PostMapping("/unit2/solvenewtonraphson")
    public String solvenewtonraphson(NewtonRaphson newtonraphson, Model model) {
        var solveNewtonRaphson = unidadIIservice.AlgoritmoNewtonRaphon(newtonraphson);
        model.addAttribute("solveNewtonRaphson", solveNewtonRaphson);
        return "/unit2/newtonraphson/solvenewtonraphson";
    }
    
    @GetMapping("/unit2/formsecant")
    public String formSecant(Model model){
        Secante secant = new Secante();
        model.addAttribute("secant", secant);
        return "unit2/secante/formsecant";
    }
    
    @PostMapping("/unit2/solvesecant")
    public String solvesecant(Secante secant, Model model){
        var solveSecant = unidadIIservice.AlgoritmoSecante(secant);
        model.addAttribute("solveSecant", solveSecant);
        return "/unit2/secante/solvesecant";
    }
    
    @GetMapping("/unit2/formmodsecant")
    public String formModSecant(Model model){
        SecanteModificada modsecant = new SecanteModificada();
        model.addAttribute("modsecant", modsecant);
        return "unit2/secantemodificado/formmodsecant";
    }
    
    @PostMapping("/unit2/solvemodsecant")
    public String solvemodsecant(SecanteModificada modsecant, Model model){
        var solveModSecant = unidadIIservice.AlgoritmoSecanteModificado(modsecant);
        model.addAttribute("solveModSecant", solveModSecant);
        return "/unit2/secantemodificado/solvemodsecant";
    }

}
