package Controller.Api.Add;


import Bean.CodeBean;
import Bean.ScoreBean;
import Bean.UserBean;
import Service.ScoreService;
import Service.ScoreServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class addScore {


    @RequestMapping(value = "/addScore")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        String jsonText=request.getParameter("scoretext");



        ScoreService service =new ScoreServiceImpl();

        if (jsonText.equals(CodeBean.jsonText)){

            PrintWriter writer=response.getWriter();
            writer.print("{ \"state\":\"r\"}");
            writer.close();
        }
        else {




        jsonText=request.getParameter("scoretext");
        System.out.println(jsonText);

        JSONObject jsonObject= (JSONObject) JSONObject.parse(jsonText);

        String score=jsonObject.get("score").toString();

        JSONArray detialArray=jsonObject.getJSONArray("detial");

        JSONObject detialObj=detialArray.getJSONObject(0);

        ScoreBean scoreBean=new ScoreBean();
        scoreBean.setPaperid(Integer.parseInt(detialObj.getString("paperid")));
        scoreBean.setPapertitle(detialObj.getString("papertitle"));
        scoreBean.setUserid(UserBean.userid);
        scoreBean.setUsername(UserBean.username);

        scoreBean.setScore(score);
        scoreBean.setSinglechoice(String.valueOf(detialObj.getInteger("singlechoice")));
        scoreBean.setFillblank(String.valueOf(detialObj.getInteger("fillblank")));
        scoreBean.setTof(String.valueOf(detialObj.getInteger("tof")));



        service.addScore(scoreBean);



        PrintWriter writer=response.getWriter();
        writer.print("{ \"state\":\"ok\"}");
        writer.close();

        CodeBean.jsonText=jsonText;

        }

    }


}
