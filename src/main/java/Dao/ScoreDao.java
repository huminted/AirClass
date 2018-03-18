package Dao;

import Bean.DocBean;
import Bean.ScoreBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ScoreDao {

     List<ScoreBean> findAllScore();
     List<ScoreBean> findScoreById(int userid);
     List<ScoreBean> findScoreByPaperId(int paperid);
     ScoreBean findScoreByUserIdAndPaperId(HashMap map);

     void addScore(ScoreBean scoreBean);



}