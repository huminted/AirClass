package Controller;



import Bean.UserBean;
import Model.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RouterController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(HttpServletRequest request , ModelMap modelMap, HttpServletResponse response){
        CookieUtils cookieUtils=new CookieUtils();
        Cookie cookiename=cookieUtils.getCookieByName(request,"username");
        Cookie cookieid=cookieUtils.getCookieByName(request,"userid");

        if (cookiename==null){


            return "login";
        }else {


            return "index";
        }

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
