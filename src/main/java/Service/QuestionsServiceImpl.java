package Service;

import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;
import Dao.PaperDao;
import Dao.PaperDaoImpl;
import Dao.QuestionsDao;
import Dao.QuestionsDaoImpl;

import java.util.List;

public class QuestionsServiceImpl implements  QuestionsService {

    private QuestionsDao questionsDao;
    public QuestionsServiceImpl() {

        questionsDao =new QuestionsDaoImpl();

    }




    @Override
    public List<SingleChoice> findScById(int paperid) {
        return questionsDao.findScById(paperid);
    }

    @Override
    public void delScById(int objectid) {
        questionsDao.delScById(objectid);

    }

    @Override
    public void addSingleChoice(SingleChoice singleChoice) {
        questionsDao.addSingleChoice(singleChoice);

    }

    @Override
    public List<FillBlank> findFbById(int paperid) {
        return questionsDao.findFbById(paperid);
    }

    @Override
    public void delFbById(int objectid) {
        questionsDao.delFbById(objectid);

    }

    @Override
    public void addFillBlank(FillBlank fillBlank) {
        questionsDao.addFillBlank(fillBlank);
    }

    @Override
    public List<Tof> findTofById(int paperid) {
        return questionsDao.findTofById(paperid);
    }

    @Override
    public void delTofById(int objectid) {

        questionsDao.delTofById(objectid);

    }

    @Override
    public void addTof(Tof tof) {
        questionsDao.addTof(tof);
    }
}
