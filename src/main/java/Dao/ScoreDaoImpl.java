package Dao;


import Bean.DocBean;
import Bean.PaperBean;
import Bean.ScoreBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ScoreDaoImpl implements ScoreDao {




    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public ScoreDaoImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<ScoreBean> findAllScore() {
        String statement = "scoreMapper.findAllScore";
        List<ScoreBean> score = session.selectList(statement);
        return score;
    }

    @Override
    public List<ScoreBean> findScoreById(int userid) {

        String statement = "scoreMapper.findScoreById";
        List<ScoreBean> score = session.selectList(statement,userid);
        return score;
    }




    @Override
    public List<ScoreBean> findScoreByPaperId(int paperid) {
        String statement = "scoreMapper.findScoreByPaperId";
        List<ScoreBean> score = session.selectList(statement,paperid);
        return score;


    }


}
