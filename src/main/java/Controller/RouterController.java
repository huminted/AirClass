package Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouterController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(HttpServletRequest request , ModelMap modelMap){

           return "index";


    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public  String admin(HttpServletRequest request , ModelMap modelMap){

        return "admin";


    }

    @RequestMapping(value = "/chat",method = RequestMethod.GET)
    public  String chat(HttpServletRequest request , ModelMap modelMap){

        return "chat";


    }
    @RequestMapping(value = "/text")
    public String text(){


        return "text";
    }


}
