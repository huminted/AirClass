package Controller.Api.Find;

import Bean.CodeBean;
import Bean.ScoreBean;
import Bean.UserBean;
import Model.CookieUtils;
import Service.ScoreService;
import Service.ScoreServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class Score {



    @RequestMapping(value = "/allscore")
    public void getAllScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");
        ScoreService scoreService=new ScoreServiceImpl();


        List<ScoreBean> list= scoreService.findAllScore();

        String jsonText= JSONArray.toJSONString(list,true);

        PrintWriter writer=response.getWriter();
        writer.print(jsonText);
        writer.close();


    }


    @RequestMapping(value = "/getscorebyid")
    public void getScoreById(HttpServletRequest request ,HttpServletResponse response) throws IOException{
        ScoreService scoreService=new ScoreServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        CookieUtils cookieUtils=new CookieUtils();
        Cookie cookiename=cookieUtils.getCookieByName(request,"username");
        Cookie cookieid=cookieUtils.getCookieByName(request,"userid");

        List<ScoreBean> list =scoreService.findScoreById(Integer.parseInt(cookieid.getValue()));

        String jsonText= JSONArray.toJSONString(list,true);

        PrintWriter writer=response.getWriter();
        writer.print(jsonText);
        writer.close();


    }


    @RequestMapping(value = "/getscorebypaperid")
    public void getScoreByPaperId(HttpServletRequest request ,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");
        ScoreService scoreService=new ScoreServiceImpl();
        List<ScoreBean> list =scoreService.findScoreByPaperId(Integer.parseInt(request.getParameter("paperid")));

        String jsonText= JSONArray.toJSONString(list,true);

        PrintWriter writer=response.getWriter();
        writer.print(jsonText);
        writer.close();


    }

}
