package Controller.Api.Add;

import Bean.CodeBean;
import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;
import Model.ShowResponse;
import Service.QuestionsService;
import Service.QuestionsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class addQuestions {


    @RequestMapping(value = "/addsc")
    public void addSc(HttpServletRequest request, HttpServletResponse response) throws IOException {

        QuestionsService service =new QuestionsServiceImpl();
        SingleChoice singleChoice =new SingleChoice();
        singleChoice.setPaperid(CodeBean.paperId);
        singleChoice.setScore("2");
        singleChoice.setQuestion(request.getParameter("scquestion"));
        singleChoice.setAnswer1(request.getParameter("scanswer1"));
        singleChoice.setAnswer2(request.getParameter("scanswer2"));
        singleChoice.setAnswer3(request.getParameter("scanswer3"));
        singleChoice.setAnswer4(request.getParameter("scanswer4"));
        singleChoice.setRightanswer(request.getParameter("scrightanswer"));

        service.addSingleChoice(singleChoice);

        ShowResponse show=new ShowResponse();
        show.show(response,request);
    }


    @RequestMapping(value = "/addfb")
    public void addFb(HttpServletRequest request,HttpServletResponse response) throws IOException {

        QuestionsService service=new QuestionsServiceImpl();
        FillBlank fillBlank =new FillBlank();
        fillBlank.setPaperid(CodeBean.paperId);
        fillBlank.setScore("2");
        fillBlank.setQuestion(request.getParameter("fbquestion"));
        fillBlank.setRightanswer(request.getParameter("fbanswer"));
        service.addFillBlank(fillBlank);


        ShowResponse show=new ShowResponse();
        show.show(response,request);

    }


    @RequestMapping(value = "/addtof")
    public void addTof(HttpServletRequest request,HttpServletResponse response) throws IOException {

        QuestionsService service =new QuestionsServiceImpl();
        Tof tof=new Tof();
        tof.setPaperid(CodeBean.paperId);
        tof.setScore("2");
        tof.setQuestion(request.getParameter("tofquestion"));
        tof.setRightanswer(request.getParameter("tofanswer"));
        service.addTof(tof);


        ShowResponse show=new ShowResponse();
        show.show(response,request);

    }

}
