package Controller.Api.Add;

import Bean.VideoBean;
import Model.ShowResponse;
import Service.VideoService;
import Service.VideoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class addVideo {

    @RequestMapping(value = "/addvideo")
    public  void addVideos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VideoService service=new VideoServiceImpl();

        VideoBean videoBean =new VideoBean();
        videoBean.setTitle(request.getParameter("videotitle"));
        videoBean.setContent(request.getParameter("videocontent"));
        videoBean.setUrl(request.getParameter("videourl"));

        service.addVideo(videoBean);
        ShowResponse show=new ShowResponse();
        show.show(response,request);



    }

}
