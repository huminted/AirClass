package Controller.Find;


import Bean.VideoBean;
import Service.VideoService;
import Service.VideoServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class Video {

    @RequestMapping(value = "/video" )

    public void getVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        VideoService service =new VideoServiceImpl();


        List<VideoBean> list=service.findAllFile();
        for (int i = 0; i <list.size(); i++) {


            VideoBean video =new VideoBean();

            video.setTitle(list.get(i).getTitle());
            video.setUrl(list.get(i).getUrl());
            video.setContent(list.get(i).getTitle());


        }

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        String jsonText= JSONArray.toJSONString(list,true);


        PrintWriter out = response.getWriter();
        out.print(jsonText);
        out.close();


    }

}
