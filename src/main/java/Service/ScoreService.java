package Service;

import Bean.ScoreBean;

import java.util.List;

public interface ScoreService {


    List<ScoreBean> findAllScore();
    List<ScoreBean> findScoreById(int userid);
    List<ScoreBean> findScoreByPaperId(int paperid);

}
