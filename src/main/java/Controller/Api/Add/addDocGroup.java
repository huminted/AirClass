package Controller.Api.Add;

import Bean.DocGroupBean;
import Model.ShowResponse;
import Service.DocService;
import Service.DocServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class addDocGroup {
    @RequestMapping("/adddocgroup")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DocService docService=new DocServiceImpl();
        DocGroupBean docGroupBean=new DocGroupBean();
        docGroupBean.setGroupname(request.getParameter("docgroupname"));
        docGroupBean.setNotification(request.getParameter("notification"));


        docService.addDocGroup(docGroupBean);

        ShowResponse showResponse =new ShowResponse();
        showResponse.show(response,request);





    }

}
