package Controller;



import Bean.CodeBean;
import Bean.UserBean;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginAndRegisterController {



    @RequestMapping(value = "/login")
    public String Login(HttpSession session, HttpServletRequest request){



        return "login";
    }




    @RequestMapping(value = "/register")
    public String Register(){
        return "register";
    }




    @RequestMapping(value = "/regist")
    public String Regist( ModelMap modelMap,HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        UserService service = new UserServiceImpl();


        UserBean user=new UserBean();
        user.setUsername( request.getParameter("username"));
        user.setUserid(Integer.parseInt(request.getParameter("userid")));
        user.setPassword( request.getParameter("password"));
        user.setSchool(request.getParameter("school"));
        user.setMajor(request.getParameter("major"));
        user.setClasses(request.getParameter("classes"));

        service.addUser(user);





        return "redirect:index";
    }







}
