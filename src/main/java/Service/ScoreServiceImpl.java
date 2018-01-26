package Service;

import Bean.ScoreBean;
import Dao.ScoreDao;
import Dao.ScoreDaoImpl;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {

    private ScoreDao scoreDao;
    public ScoreServiceImpl() {

        scoreDao =new ScoreDaoImpl();

    }


    @Override
    public List<ScoreBean> findAllScore() {
        return scoreDao.findAllScore();
    }

    @Override
    public List<ScoreBean> findScoreById(int userid) {
        return scoreDao.findScoreById(userid);
    }

    @Override
    public List<ScoreBean> findScoreByPaperId(int paperid) {
        return scoreDao.findScoreByPaperId(paperid);
    }


}
