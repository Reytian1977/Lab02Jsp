package cabrera.lab02jsp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {
    @RequestMapping(value = "/Accueil/accueil")
    public ModelAndView accueil(){ return new ModelAndView("index");
    }

    @RequestMapping(value = "/Accueil/contact")
    public ModelAndView contact(){
        return new ModelAndView("contact");
    }
}
