package cabrera.lab02jsp.Controllers;

import cabrera.lab02jsp.mesmodels.Evaluation;
import cabrera.lab02jsp.mesmodels.EvaluationDbContext;
import cabrera.lab02jsp.mesmodels.EvaluationViewModel;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationController {

    private EvaluationDbContext dc = new EvaluationDbContext();
    public EvaluationController(){}

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
    public String ajouter(@ModelAttribute(name = "FormAjouter")EvaluationViewModel evaluationViewModel){
        //insérer votre code
        Evaluation e = evaluationViewModel.mapper();
        dc.Ajouter(e);



        return "redirect:/Accueil/accueil";
    }

    //Methode Modifier
    @RequestMapping(value = "/evaluation/modifier/{numero}", method = RequestMethod.GET)
    public ModelAndView modifier(@PathVariable(name = "numero") int numero){
        Evaluation evaluation = dc.rechercher(numero);
        return new ModelAndView("modifier", "evaluation", evaluation);
    }

    @RequestMapping(value = "/evaluation/modifier", method = RequestMethod.POST)
    public String modifier(@ModelAttribute(name = "FormModifier")EvaluationViewModel evaluationViewModel){
        //insérer votre code
        Evaluation e = evaluationViewModel.mapper();
        dc.Modifier(e);

        return "redirect:/evaluation/liste";
    }

    @RequestMapping(value = "/evaluation/supprimer/{numero}", method = RequestMethod.GET)
    public String supprimer(@PathVariable(name = "numero") int numero){
        dc.Supprimer(numero);
        return "redirect:/evaluation/liste";
    }
}
