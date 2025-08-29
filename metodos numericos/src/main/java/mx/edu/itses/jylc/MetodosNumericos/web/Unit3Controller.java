package mx.edu.itses.jylc.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.jylc.MetodosNumericos.domain.Gauss;
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
    private UnidadIIIService unidadIIIService;

    @GetMapping("/unit3")
    public String index(Model model) {
        return "unit3/index";
    }

    @GetMapping("/unit3/formreglacramer")
    public String formReglaCramer(Model model) {
        ReglaCramer modelCramer = new ReglaCramer();
        model.addAttribute("modelCramer", modelCramer);
        return "unit3/reglacramer/formreglacramer";
    }

    @PostMapping("/unit3/solvecramer")
    public String solveCramer(ReglaCramer modelCramer, Errors error, Model model) {
        var solveCramer = unidadIIIService.AlgoritmoReglaCramer(modelCramer);
        model.addAttribute("solveCramer", solveCramer);
        return "unit3/reglacramer/solvecramer";
    }

    @GetMapping("/unit3/formgauss")
    public String formGauss(Model model) {
        Gauss modelGauss = new Gauss();

        model.addAttribute("modelGauss", modelGauss);
        return "unit3/gauss/formgauss";
    }

    @PostMapping("/unit3/solvegauss")
    public String solveGauss(Gauss modelGauss, Errors errores, Model model) {
        var solveGauss = unidadIIIService.AlgoritmoGauss(modelGauss);
        model.addAttribute("solveGauss", solveGauss);
        return "unit3/gauss/solvegauss";
    }

    @GetMapping("/unit3/formgaussjordan")
    public String formGaussJordan(Model model) {
        GaussJordan modelGaussJordan = new GaussJordan();
        model.addAttribute("modelGaussJordan", modelGaussJordan);
        return "unit3/gaussjordan/formgaussjordan";
    }

    @GetMapping("/unit3/formjacobi")
    public String formJacobi(Model model) {
        Jacobi modelJacobi = new Jacobi();
        model.addAttribute("solvejacobi", modelJacobi);
        return "unit3/jacobi/formjacobi";
    }

    @PostMapping("/unit3/solvejacobi")
    public String solveJacobi(Jacobi modelJacobi, Errors errores, Model model) {
        var solveJacobi = unidadIIIService.AlgoritmoJacobi(modelJacobi);
        model.addAttribute("solveJacobi", solveJacobi);
        return "unit3/jacobi/solvejacobi";
    }

    @GetMapping("/unit3/formseidel")
    public String formSeidel(Model model) {
        GaussSeidel modelGaussSeidel = new GaussSeidel();
        model.addAttribute("modelGaussSeidel", modelGaussSeidel);
        return "unit3/gaussseidel/formseidel";
    }

    @PostMapping("/unit3/solveseidel")
    public String solveSeidel(GaussSeidel modelGaussSeidel,Errors errores,Model model) {
        var solveGaussSeidel = unidadIIIService.AlgoritmoGaussSeidel(modelGaussSeidel);
        model.addAttribute("solveGaussSeidel", solveGaussSeidel);
        return "unit3/gaussseidel/solveseidel";
    }

    @PostMapping("/unit3/solvegaussjordan")
    public String solveGaussJordan(GaussJordan modelGaussJordan, Errors errores, Model model) {
        var solveGJ = unidadIIIService.AlgoritmoGaussJordan(modelGaussJordan);
        model.addAttribute("solveGJ", solveGJ);
        return "unit3/gaussjordan/solvegaussjordan";
    }
}
