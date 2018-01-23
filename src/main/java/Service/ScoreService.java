package Service;

import Bean.ScoreBean;

import java.util.List;

public interface ScoreService {


    List<ScoreBean> findAllScore();
    List<ScoreBean> findScoreById(String userid);
    List<ScoreBean> findScoreByPaperId(int paperid);

}
