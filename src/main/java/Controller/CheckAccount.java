package Controller;


import Bean.UserBean;
import Model.CookieUtils;
import Service.UserService;
import Service.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckAccount {


    @RequestMapping(value = "/home")
    public String Check(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, UserBean User) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");
        UserService service = new UserServiceImpl();


        int InputUserID= Integer.parseInt((request.getParameter("userid")));
        String InputUserPW= request.getParameter("password");


        if (service.findUserById(InputUserID)!=null){

            User=service.findUserById(InputUserID);


            int ID=User.getUserid();
            String PW=User.getPassword();

            if (InputUserID==ID && InputUserPW.equals(PW)){


                Map<String ,Object> userMap=new HashMap<String ,Object>();

                userMap.put("state",200);
                userMap.put("msg","成功");
                userMap.put("code",1);
                userMap.put("result",User);


                String jsonText= JSONArray.toJSONString(userMap,true);
                System.out.println("登陆成功"+jsonText);

                CookieUtils cookieUtils =new CookieUtils();
                cookieUtils.addCookie(response,"username",User.getUsername());
                cookieUtils.addCookie(response,"userid", String.valueOf(User.getUserid()));


                return "redirect:index";

            }

            else {

                Map<String ,Object> fileMap=new HashMap<String ,Object>();
                fileMap.put("state",200);
                fileMap.put("msg","密码错误");
                fileMap.put("code",1);

                String jsonText= JSONArray.toJSONString(fileMap,true);
                PrintWriter print=response.getWriter();
                print.print(jsonText);
                print.close();

                return null;

            }

        }
        else{


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未注册");
            fileMap.put("code",2);

            String jsonText= JSONArray.toJSONString(fileMap,true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();

            return null;
        }




    }









}