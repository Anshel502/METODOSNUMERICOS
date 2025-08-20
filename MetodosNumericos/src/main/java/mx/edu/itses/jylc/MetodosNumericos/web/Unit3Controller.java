/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussJordan;
import mx.edu.itses.jylc.MetodosNumericos.domain.GaussSeidel;
import mx.edu.itses.jylc.MetodosNumericos.domain.Jacobi;
import mx.edu.itses.jylc.MetodosNumericos.domain.ReglaCramer;
import mx.edu.itses.jylc.MetodosNumericos.services.UnidadIIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class Unit3Controller {
    
    
    @Autowired
    private UnidadIIIService unidadIIIsrv;
    
    @GetMapping("/unit3")
    public String index(Model model){
    return "unit3/index";
    }
    
    @GetMapping("/unit3/formcramer")
    public String formCramer(Model model){
    ReglaCramer modelCramer=new ReglaCramer();
    model.addAttribute("modelCramer", modelCramer);
    return "unit3/cramer/formcramer";
    }
    
    
    @PostMapping("/unit3/solvecramer")
    public String solveCramer(ReglaCramer modelCramer,Errors errores,Model model){
    log.info("OBJECTOS"+ modelCramer.getMatrizA());
       // ArrayList<Double> A=modelCramer.getMatrizA();
    
        
        return "unit3/cramer/formcramer";
    }
    
@GetMapping("/unit3/formgaussjordan")
public String formGaussJordan(Model model) {
    GaussJordan gaussjordan = new GaussJordan();
    model.addAttribute("gaussjordan", gaussjordan);
    return "/unit3/gaussjordan/formgaussjordan";
}

@PostMapping("/unit3/solvegaussjordan")
public String solveGaussJordan(GaussJordan gaussjordan, Model model) {
    var solveGaussJordan = unidadIIIsrv.AlgoritmoGaussJordan(gaussjordan);

    log.info("Resultado Gauss-Jordan: " + solveGaussJordan);
    model.addAttribute("pasos", solveGaussJordan);

    return "/unit3/gaussjordan/solvegaussjordan";
}

@GetMapping("/unit3/formjacobi")
public String formJacobi(Model model) {
    Jacobi jacobi = new Jacobi();
    model.addAttribute("jacobi", jacobi);
    return "/unit3/jacobi/formjacobi";
}

@PostMapping("/unit3/solvejacobi")
public String solveJacobi(Jacobi jacobi, Model model) {
    var solveJacobi = unidadIIIsrv.AlgoritmoJacobi(jacobi);

    log.info("Resultado Jacobi: " + solveJacobi);
    model.addAttribute("pasos", solveJacobi);
    model.addAttribute("n", jacobi.getN());

    return "/unit3/jacobi/solvejacobi";
}

@GetMapping("/unit3/formseidel")
public String formSeidel(Model model) {
    GaussSeidel gaussSeidel = new GaussSeidel();
    model.addAttribute("gaussSeidel", gaussSeidel);
    return "/unit3/seidel/formseidel";
}

@PostMapping("/unit3/solveseidel")
public String solveSeidel(GaussSeidel gaussSeidel, Model model) {
    var solveSeidel = unidadIIIsrv.AlgoritmoGaussSeidel(gaussSeidel);

    log.info("Resultado Gauss-Seidel: " + solveSeidel);
    model.addAttribute("pasos", solveSeidel);

    return "/unit3/seidel/solveseidel";
}

}
