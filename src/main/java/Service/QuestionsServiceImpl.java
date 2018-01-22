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
    public List<FillBlank> findFbById(int paperid) {
        return questionsDao.findFbById(paperid);
    }

    @Override
    public void delFbById(int objectid) {
        questionsDao.delFbById(objectid);

    }

    @Override
    public List<Tof> findTofById(int paperid) {
        return questionsDao.findTofById(paperid);
    }

    @Override
    public void delTofById(int objectid) {

        questionsDao.delTofById(objectid);

    }
}
