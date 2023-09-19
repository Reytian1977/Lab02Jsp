package cabrera.lab02jsp.Controllers;

import cabrera.lab02jsp.mesmodels.Evaluation;
import cabrera.lab02jsp.mesmodels.EvaluationDbContext;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationController {

    private EvaluationDbContext dc = new EvaluationDbContext();
    public EvaluationController(){}

    //Methode Index
    @RequestMapping(value = "/evaluation/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    //Methode Liste
    @RequestMapping(value = "/evaluation/liste")
    public  ModelAndView liste(){
        return new ModelAndView("liste", "listeEvaluation", dc.getListeEvalutions());
    }

    //Methode Ajouter
    @RequestMapping(value = "/evaluation/ajouter", method = RequestMethod.GET)
    public ModelAndView ajouter(){
        return new ModelAndView("ajouter");
    }

    @RequestMapping(value = "/evaluation/ajouter", method = RequestMethod.POST)
    public String ajouter(HttpServletRequest request){
        //insérer votre code
        Evaluation e = new Evaluation();
        e = e.mapper(request);
        dc.Ajouter(e);
        return "redirect:/evaluation/index";
    }

    //Methode Modifier
    @RequestMapping(value = "/evaluation/modifier/{numero}", method = RequestMethod.GET)
    public ModelAndView modifier(@PathVariable(name = "numero") int numero){
        Evaluation evaluation = dc.rechercher(numero);
        return new ModelAndView("modifier", "evaluation", evaluation);
    }

    @RequestMapping(value = "/evaluation/modifier", method = RequestMethod.POST)
    public String modifier(HttpServletRequest request){
        //insérer votre code
        Evaluation e = new Evaluation();
        e = Evaluation.mapper(request);
        dc.Modifier(e);

        return "redirect:/evaluation/liste";
    }

    @RequestMapping(value = "/evaluation/supprimer/{numero}", method = RequestMethod.GET)
    public String supprimer(@PathVariable(name = "numero") int numero){
        dc.Supprimer(numero);
        return "redirect:/evaluation/liste";
    }
}
