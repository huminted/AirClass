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
import java.util.List;

@Controller
public class Doc {


    @RequestMapping(value = "/doc")
    public void getDoc(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DocService service =new DocServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        List<DocBean> list=service.findFileByUserId("1");


        if (list.isEmpty()){


            String jsonText = JSONArray.toJSONString(list, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);
            print.close();


        }

        else {


            String jsonText= JSONArray.toJSONString(list,true);

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

        String jsonText= JSONArray.toJSONString(list,true);
        PrintWriter writer=response.getWriter();
        writer.print(jsonText);
        writer.close();






    }


}
