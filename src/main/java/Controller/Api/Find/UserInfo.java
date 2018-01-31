package Controller.Api.Find;


import Bean.UserBean;
import Service.UserService;
import Service.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfo {

    @RequestMapping("/getMyInfo")
    public  void getMyInfo(HttpServletRequest request , HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        UserService userService=new UserServiceImpl();
        UserBean user= userService.findUserById(UserBean.userid);

        Map<String ,Object> userMap=new HashMap<String ,Object>();

        userMap.put("state",200);
        userMap.put("msg","成功");
        userMap.put("code",1);
        userMap.put("user",user);


        String jsonText= JSONArray.toJSONString(userMap,true);


        PrintWriter writer=response.getWriter();
        writer.print(jsonText);
        writer.close();



    }



}
