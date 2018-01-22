package Controller.Api.Find;


import Bean.PaperBean;
import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;
import Service.PaperService;
import Service.PaperServiceImpl;
import Service.QuestionsService;
import Service.QuestionsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class PaperAndQuestions {

    private QuestionsService service =new QuestionsServiceImpl();
    private PaperService paperService=new PaperServiceImpl();

    @RequestMapping(value = "/getOnePaper")

    public void getOnePaper(HttpServletRequest request, HttpServletResponse  response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        Map<String ,Object> jsonmap=new HashMap<>();

        PaperBean paperList=paperService.findPaperById(Integer.parseInt(request.getParameter("paperid")));


        jsonmap.put("msg","成功");

        jsonmap.put("paper",paperList);


        if (paperList.getSinglechoice()==1){
            jsonmap.put("sc",findSc(request,response));
            jsonmap.put("scTotal",findSc(request,response).size());

        } if (paperList.getFillblank()==1){
            jsonmap.put("fb",findFb(request,response));
            jsonmap.put("fbTotal",findFb(request,response).size());
        }  if (paperList.getTof()==1){
            jsonmap.put("tof",findTof(request,response));
            jsonmap.put("tofTotal",findTof(request,response).size());
        }




        String json= JSONArray.toJSONString(jsonmap,true);
        PrintWriter writer =response.getWriter();
        writer.print(json);

    }





    @RequestMapping(value = "/getSc")
    public List findSc(HttpServletRequest request, HttpServletResponse  response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        List<SingleChoice>  list= service.findScById(Integer.parseInt(request.getParameter("paperid")));




//        String json= JSONArray.toJSONString(list,true);
//        PrintWriter writer =response.getWriter();
//        writer.print(json);


        return list;


    }

    @RequestMapping(value = "/delSc")
    public void delSc(HttpServletRequest request, HttpServletResponse  response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        service.delScById(Integer.parseInt(request.getParameter("objectid")));



    }


    @RequestMapping(value = "/getFb")
    public List findFb(HttpServletRequest request, HttpServletResponse  response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        List<FillBlank>  list= service.findFbById(Integer.parseInt(request.getParameter("paperid")));



        return list;



    }

    @RequestMapping(value = "/delFb")
    public void delFb(HttpServletRequest request, HttpServletResponse  response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        service.delFbById(Integer.parseInt(request.getParameter("objectid")));


    }


    @RequestMapping(value = "/getTof")
    public List findTof(HttpServletRequest request, HttpServletResponse  response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        List<Tof>  list= service.findTofById(Integer.parseInt(request.getParameter("paperid")));

        return list;



    }

    @RequestMapping(value = "/delTof")
    public void delTof(HttpServletRequest request, HttpServletResponse  response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        service.delTofById(Integer.parseInt(request.getParameter("objectid")));



    }



}