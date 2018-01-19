package Controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class Download {


    @RequestMapping(value = "/download",method= RequestMethod.GET)
    ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) throws IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("filepath"));
        System.out.println(request.getParameter("filename"));

        String filePath =  request.getParameter("filepath");
        FileSystemResource file = new FileSystemResource(filePath);




        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", request.getParameter("filename")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Type","text/html;charset=UFT-8"); //设置输出编码格式
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
