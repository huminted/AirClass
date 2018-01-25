package Controller.Api.Delete;

import Model.ShowResponse;
import Service.DocService;
import Service.DocServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class delDoc {
    @RequestMapping(value = "/deldoc")
    public void del(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");


        DocService service =new DocServiceImpl();

        service.delFileByObjId(Integer.parseInt(request.getParameter("objectid")));

        ShowResponse showResponse =new ShowResponse();
        showResponse.show(response,request);



    }

    @RequestMapping(value = "/deldocgroup")
    public void delDocGroup(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");


        DocService service =new DocServiceImpl();

        service.delDocGroupById(Integer.parseInt(request.getParameter("objectid")));

        ShowResponse showResponse =new ShowResponse();
        showResponse.show(response,request);



    }



}
