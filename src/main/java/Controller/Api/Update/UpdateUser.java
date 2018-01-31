package Controller.Api.Update;

import Bean.UserBean;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UpdateUser {

    @RequestMapping("/updateUser")
    public  void updateUser(HttpServletRequest request,HttpServletResponse response) throws IOException{

        request.setCharacterEncoding("UTF-8");

        UserService service=new UserServiceImpl();
        UserBean userBean=new UserBean();
        userBean.setUsername(request.getParameter("name"));
        userBean.setUserid(UserBean.userid);
        userBean.setSchool(request.getParameter("school"));
        userBean.setMajor(request.getParameter("major"));
        userBean.setPassword(request.getParameter("password"));




        service.updateUser(userBean);





    }



}
