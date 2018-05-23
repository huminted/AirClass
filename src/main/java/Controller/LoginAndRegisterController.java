package Controller;



import Bean.CodeBean;
import Bean.UserBean;
import Model.ShowResponse;
import Service.UserService;
import Service.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
    public String Regist(ModelMap modelMap, HttpServletRequest request, HttpServletResponse  response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        UserService service = new UserServiceImpl();

        UserBean newuser= service.findUserById(Integer.parseInt(request.getParameter("userid")));
        if (newuser==null){
            UserBean user=new UserBean();
            user.setUsername( request.getParameter("username"));
            user.setUserid(Integer.parseInt(request.getParameter("userid")));
            user.setPassword( request.getParameter("password"));
            user.setSchool(request.getParameter("school"));
            user.setMajor(request.getParameter("major"));
            user.setClasses(request.getParameter("classes"));
            service.addUser(user);
        }


        return "redirect:index";
    }

    @RequestMapping(value = "/checkUserid")
    private void check(HttpServletRequest request,HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        UserService service = new UserServiceImpl();

        UserBean newuser= service.findUserById(Integer.parseInt(request.getParameter("userid")));
        Map<String ,Object> fileMap=new HashMap<String ,Object>();

        if (newuser==null){

            fileMap.put("state",200);
            fileMap.put("msg","不存在该用户");
            fileMap.put("code",1);
            String jsonText= JSONArray.toJSONString(fileMap,true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();
            fileMap.clear();
        }
        else {

            fileMap.put("state",200);
            fileMap.put("msg","已经存在该用户");
            fileMap.put("code",0);
            String jsonText= JSONArray.toJSONString(fileMap,true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();
            fileMap.clear();
        }




    }







}
