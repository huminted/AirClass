package Controller.Find;

import Bean.PaperBean;
import Bean.VideoBean;
import Service.PaperService;
import Service.PaperServiceImpl;
import Service.VideoService;
import Service.VideoServiceImpl;
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

        List<PaperBean> list=service.findAllPaper();


        if (list.isEmpty()){

//            Map<String ,Object> fileMap=new HashMap<String ,Object>();
//            fileMap.put("state",200);
//            fileMap.put("msg","未找到文件");
//            fileMap.put("code",0);

            String jsonText = JSONArray.toJSONString(list, true);
            PrintWriter print=response.getWriter();
            print.print(jsonText);


        }

        else {


//            Map<String ,Object> fileMap=new HashMap<String ,Object>();
//            fileMap.put("state",200);
//            fileMap.put("msg","成功");
//            fileMap.put("code",1);
//            fileMap.put("result",list);
            String jsonText= JSONArray.toJSONString(list,true);

            PrintWriter print=response.getWriter();
            print.print(jsonText);

        }









    }

}
