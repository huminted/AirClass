package Controller.Api.Find;


import Bean.Questions.SingleChoice;
import Service.QuestionsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Questions {


    @RequestMapping(value = "/sc")
    public  void findSc(){

        QuestionsServiceImpl service =new QuestionsServiceImpl();


        List<SingleChoice>  list= service.findScById(1);

        String json= JSONArray.toJSONString(list,true);
        System.out.println(json);


    }

}
