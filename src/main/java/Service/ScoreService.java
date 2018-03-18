package Service;

import Bean.ScoreBean;

import java.util.HashMap;
import java.util.List;

public interface ScoreService {


    List<ScoreBean> findAllScore();
    List<ScoreBean> findScoreById(int userid);
    List<ScoreBean> findScoreByPaperId(int paperid);

    ScoreBean findScoreByUserIdAndPaperId(HashMap map);

    void addScore(ScoreBean scoreBean);

}
