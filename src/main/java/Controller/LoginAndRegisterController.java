package Controller;



import Bean.UserBean;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginAndRegisterController {


    UserService service = new UserServiceImpl();



    @RequestMapping(value = "/login")
    public String Login( ModelMap modelMap,HttpServletRequest request){
        return "login";
    }




    @RequestMapping(value = "/register")
    public String Register(){
        return "register";
    }




    @RequestMapping(value = "/regist")
    public String Regist( ModelMap modelMap,HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");



        UserBean user=new UserBean();
        user.setUsername( request.getParameter("username"));
        user.setUserid(  request.getParameter("userid"));
        user.setPassword( request.getParameter("password"));
        user.setSchool(request.getParameter("school"));
        user.setMajor(request.getParameter("major"));
        user.setClasses(request.getParameter("classes"));

        service.addUser(user);





        return "redirect:index";
    }







}
