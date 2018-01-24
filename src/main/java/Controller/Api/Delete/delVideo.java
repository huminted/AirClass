package Controller.Api.Delete;

import Model.ShowResponse;
import Service.VideoService;
import Service.VideoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class delVideo {

    @RequestMapping(value = "/delvideo")
    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

        VideoService service =new VideoServiceImpl();
        service.delVideo(Integer.parseInt(request.getParameter("objectid")));


        ShowResponse show=new ShowResponse();
        show.show(response,request);
    }
}
