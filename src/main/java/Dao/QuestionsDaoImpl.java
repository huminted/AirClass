package Dao;

import Bean.DocBean;
import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class QuestionsDaoImpl implements QuestionsDao {


    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public QuestionsDaoImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<SingleChoice> findScById(int paperid) {

        String statement = "questionsMapper.findScById";
        List<SingleChoice> SingleChoice = session.selectList(statement, paperid);

        return SingleChoice;
    }

    @Override
    public void delScById(int objectid) {

        String statement = "questionsMapper.delScById";
        session.delete(statement,objectid);
        session.commit();



    }

    @Override
    public List<FillBlank> findFbById(int paperid) {
        String statement = "questionsMapper.findFbById";
        List<FillBlank> fillBlanks = session.selectList(statement, paperid);

        return fillBlanks;
    }

    @Override
    public void delFbById(int objectid) {


        String statement = "questionsMapper.delFbById";
        session.delete(statement,objectid);
        session.commit();

    }

    @Override
    public List<Tof> findTofById(int paperid) {
        String statement = "questionsMapper.findTofById";
        List<Tof> Tof = session.selectList(statement, paperid);

        return Tof;
    }

    @Override
    public void delTofById(int objectid) {

        String statement = "questionsMapper.delTofById";
        session.delete(statement,objectid);
        session.commit();

    }
}
