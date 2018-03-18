package Service;

import Bean.ScoreBean;
import Dao.ScoreDao;
import Dao.ScoreDaoImpl;

import java.util.HashMap;
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

    @Override
    public ScoreBean findScoreByUserIdAndPaperId(HashMap map) {
        return scoreDao.findScoreByUserIdAndPaperId(map);
    }

    @Override
    public void addScore(ScoreBean scoreBean) {
        scoreDao.addScore(scoreBean);
    }


}
