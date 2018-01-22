package Controller.Api.Find;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Text {

    @RequestMapping(value = "/text")
    public String text(){


        return "text";
    }
}
