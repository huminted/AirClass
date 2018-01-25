package Controller.Api.Find;

import Bean.ScoreBean;
import Service.ScoreService;
import Service.ScoreServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

        List<ScoreBean> list =scoreService.findScoreById("1");

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
