package Controller.Api.Find;


import Bean.CodeBean;
import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;
import Service.QuestionsService;
import Service.QuestionsServiceImpl;
import com.alibaba.fastjson.JSONArray;
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
public class Questions {



    @RequestMapping(value = "/getScByPaperId")
    public void findSc(HttpServletRequest request, HttpServletResponse response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        QuestionsService service =new QuestionsServiceImpl();

        List<SingleChoice>  list= service.findScById(CodeBean.paperId);


        if (list.isEmpty()){

            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("scs","null");

            String jsonText = JSONArray.toJSONString(fileMap, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }

        else {


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","成功");
            fileMap.put("code",1);
            fileMap.put("total",list.size());
            fileMap.put("scs",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }




    }
    @RequestMapping(value = "/getFbByPaperId")
    public void findFb(HttpServletRequest request, HttpServletResponse  response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        QuestionsService service =new QuestionsServiceImpl();

        List<FillBlank>  list= service.findFbById(CodeBean.paperId);

        if (list.isEmpty()){

            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("fbs","null");

            String jsonText = JSONArray.toJSONString(fileMap, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }

        else {


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","成功");
            fileMap.put("code",1);
            fileMap.put("total",list.size());
            fileMap.put("fbs",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }





    }


    @RequestMapping(value = "/getTofByPaperId")
    public void findTof(HttpServletRequest request, HttpServletResponse  response)  throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        QuestionsService service =new QuestionsServiceImpl();
        List<Tof>  list= service.findTofById(CodeBean.paperId);

        if (list.isEmpty()){

            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("tofs","null");

            String jsonText = JSONArray.toJSONString(fileMap, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }

        else {


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","成功");
            fileMap.put("code",1);
            fileMap.put("total",list.size());
            fileMap.put("tofs",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }



    }


}
