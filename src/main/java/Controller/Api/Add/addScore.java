package Controller.Api.Add;


import Bean.CodeBean;
import Bean.ScoreBean;
import Bean.UserBean;
import Model.CookieUtils;
import Service.ScoreService;
import Service.ScoreServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Controller
public class addScore {


    @RequestMapping(value = "/addScore")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");

        String jsonText=request.getParameter("scoretext");
        ScoreService service =new ScoreServiceImpl();

        CookieUtils cookieUtils =new CookieUtils();
        Cookie cookiename=cookieUtils.getCookieByName(request,"username");
        Cookie cookieid=cookieUtils.getCookieByName(request,"userid");




        JSONObject jsonObject= (JSONObject) JSONObject.parse(jsonText);

        String score=jsonObject.get("score").toString();

        JSONArray detialArray=jsonObject.getJSONArray("detial");

        JSONObject detialObj=detialArray.getJSONObject(0);

        HashMap <String ,Integer>hashMap=new HashMap<String ,Integer>();
        hashMap.put("userid",Integer.parseInt(cookieid.getValue()));
        hashMap.put("paperid",Integer.parseInt(detialObj.getString("paperid")));


        if (service.findScoreByUserIdAndPaperId(hashMap)==null){

            ScoreBean scoreBean=new ScoreBean();
            scoreBean.setPaperid(Integer.parseInt(detialObj.getString("paperid")));
            scoreBean.setPapertitle(detialObj.getString("papertitle"));
            scoreBean.setUserid(Integer.parseInt(cookieid.getValue()));
            scoreBean.setUsername( cookiename.getValue());

            scoreBean.setScore(score);
            scoreBean.setSinglechoice(String.valueOf(detialObj.getInteger("singlechoice")));
            scoreBean.setFillblank(String.valueOf(detialObj.getInteger("fillblank")));
            scoreBean.setTof(String.valueOf(detialObj.getInteger("tof")));

            service.addScore(scoreBean);



            PrintWriter writer=response.getWriter();
            writer.print("{ \"state\":\"new\"}");
            writer.close();



        }else {

            PrintWriter writer=response.getWriter();
            writer.print("{ \"state\":\"done\"}");
            writer.close();

        }





    }


}
