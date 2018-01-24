package Controller.Api.Find;

import Bean.DocBean;
import Service.DocService;
import Service.DocServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
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
public class Doc {


    @RequestMapping(value = "/doc")
    public void getDoc(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DocService service =new DocServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        List<DocBean> list=service.findFileByUserId("1");


        if (list.isEmpty()){


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("doc","null");


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
            fileMap.put("doc",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();
        }

    }


    @RequestMapping(value = "/alldoc")
    public void getAllDoc(HttpServletRequest request,HttpServletResponse response) throws  IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        DocService service =new DocServiceImpl();
        List<DocBean> list =service.findAllFile();


        if (list.isEmpty()){


            Map<String ,Object> fileMap=new HashMap<String ,Object>();
            fileMap.put("state",200);
            fileMap.put("msg","未找到文件");
            fileMap.put("code",0);
            fileMap.put("total",list.size());
            fileMap.put("doc","null");


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
            fileMap.put("doc",list);


            String jsonText= JSONArray.toJSONString(fileMap,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();
        }







    }


}
