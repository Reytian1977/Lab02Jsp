package cabrera.lab02jsp.Controllers;

import cabrera.lab02jsp.mesmodels.Evaluation;
import cabrera.lab02jsp.mesmodels.EvaluationDbContext;
import cabrera.lab02jsp.mesmodels.EvaluationViewModel;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import static org.springframework.web.util.HtmlUtils.htmlEscape;

@Controller
public class EvaluationController {

    private EvaluationDbContext dc = new EvaluationDbContext();
    public EvaluationController(){}

    //Mehtode Escape
    private Evaluation Escape(Evaluation e){
        e.setNom(htmlEscape(e.getNom()));
        e.setPrenom(htmlEscape(e.getPrenom()));
        e.setCourriel(htmlEscape(e.getCourriel()));
        e.setTelephone(htmlEscape(e.getTelephone()));
        e.setNote(htmlEscape(e.getNote()));
        e.setCommentaires(htmlEscape(e.getCommentaires()));

        return e;
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
    public String ajouter(@ModelAttribute(name = "FormAjouter")EvaluationViewModel evaluationViewModel){
        //insérer votre code
        Evaluation e = evaluationViewModel.mapper();

        e = Escape(e);

        //Ajouter dans la liste
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

        e = Escape(e);

        dc.Modifier(e);

        return "redirect:/evaluation/liste";
    }

    @RequestMapping(value = "/evaluation/supprimer/{numero}", method = RequestMethod.GET)
    public String supprimer(@PathVariable(name = "numero") int numero){
        dc.Supprimer(numero);
        return "redirect:/evaluation/liste";
    }
}
