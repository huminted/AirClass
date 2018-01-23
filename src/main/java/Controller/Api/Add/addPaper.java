package Controller.Api.Add;

import Bean.ObjectidBean;
import Bean.PaperBean;
import Service.PaperService;
import Service.PaperServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class addPaper {



    @RequestMapping(value = "/addpaper")
    public void addPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PaperService service =new PaperServiceImpl();
        PaperBean paperBean =new PaperBean();
        String code=String.valueOf(System.currentTimeMillis());

        paperBean.setTitle(request.getParameter("papertitle"));
        paperBean.setContent(request.getParameter("papercontent"));
        paperBean.setCode(code);
        paperBean.setFillblank(1);
        paperBean.setSinglechoice(1);
        paperBean.setTof(1);
        service.addPaper(paperBean);


        paperBean=service.findPaperByCode(code);
        ObjectidBean.objectid=paperBean.objectid;






    }
}
