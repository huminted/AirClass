package Controller;


import Bean.UserBean;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckAccount {


    @RequestMapping(value = "/home")
    public String Check(ModelMap modelMap, HttpServletRequest request, UserBean User){

        UserService service = new UserServiceImpl();


        String InputUserID= (request.getParameter("username"));
        String InputUserPW= request.getParameter("password");


        if (service.findUserById(InputUserID)!=null){

            User=service.findUserById(InputUserID);




            String ID=User.getUserid();
            String PW=User.getPassword();

            if (InputUserID.equals(ID) && InputUserPW.equals(PW)){

                System.out.println("登陆成功");


//                LoadData loadData =new LoadData();
//                loadData.Load(modelMap);
//
//                LoadFiles loadFiles =new LoadFiles();
//                request.setAttribute("Userfilesmap", loadFiles.loadUser());
//                request.setAttribute("Centerfilesmap",loadFiles.loadCenter());
//                request.setAttribute("permission",UserModel.permission);
//                request.setAttribute("setmap",loadFiles.loadSet());


                return "index";

            }

            else {

                System.out.println("用户名错误1"+User.getPassword());

                return "login";

            }

        }
        else{


            System.out.println("未输入");

            request.setAttribute("toast","fail");
            return "login";
        }




    }









}
