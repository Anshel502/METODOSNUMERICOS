/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.EliminacionGaussiana;
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
    
    
@GetMapping("/unit3/formeliminaciongaussiana")
public String formEliminacionGaussiana(Model model) {
    EliminacionGaussiana eliminaciongaussiana = new EliminacionGaussiana();
    model.addAttribute("eliminaciongaussiana", eliminaciongaussiana);
    return "/unit3/eliminaciongaussiana/formeliminaciongaussiana";
}

@PostMapping("/unit3/solveeliminaciongaussiana")
public String solveEliminacionGaussiana(EliminacionGaussiana eliminaciongaussiana, Model model) {
    var solveEliminacionGaussiana = unidadIIIsrv.AlgoritmoEliminacionGaussiana(eliminaciongaussiana);

    log.info("Resultado Eliminación Gaussiana: " + solveEliminacionGaussiana);
    model.addAttribute("solveEliminacionGaussiana", solveEliminacionGaussiana);

    return "/unit3/eliminaciongaussiana/solveeliminaciongaussiana";
}

}
