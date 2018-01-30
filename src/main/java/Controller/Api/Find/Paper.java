package Controller.Api.Find;

import Bean.CodeBean;
import Bean.PaperBean;
import Service.PaperService;
import Service.PaperServiceImpl;
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
public class Paper {


    @RequestMapping(value = "/paper" )
    public void getPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PaperService service =new PaperServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");
        PaperAndQuestions paperAndQuestions =new PaperAndQuestions();

        List<PaperBean> list=service.findAllPaper();


        if (list.isEmpty()){

            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("paper","null");

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
            fileMap.put("paper",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }



    }


    @RequestMapping(value = "/getpaperbycode")
    public void getPaperByCode(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");


    }



    @RequestMapping(value = "/getNewestPaper")
    public void getNewestPaper(HttpServletRequest request, HttpServletResponse response) throws  IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");

        PaperService service =new PaperServiceImpl();
        PaperBean paperBean =service.findPaperById(CodeBean.paperId);


        if (paperBean!=null){

            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","成功");
            fileMap.put("code",1);
            fileMap.put("paper",paperBean);

            String jsonText = JSONArray.toJSONString(fileMap, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();
        }
        else {



            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("paper","null");

            String jsonText = JSONArray.toJSONString(fileMap, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();

        }




    }


}
