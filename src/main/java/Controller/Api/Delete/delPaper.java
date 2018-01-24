package Controller.Api.Delete;

import Model.ShowResponse;
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
import java.util.Map;

@Controller
public class delPaper {

    @RequestMapping(value = "/delpaper")
    public void delPaperById(HttpServletRequest request , HttpServletResponse response) throws IOException {

        PaperService service=new PaperServiceImpl();
        service.delPaperById(Integer.parseInt(request.getParameter("objectid")));


        ShowResponse show=new ShowResponse();
        show.show(response,request);


    }

}
