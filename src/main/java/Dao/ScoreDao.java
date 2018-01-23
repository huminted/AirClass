package Dao;

import Bean.DocBean;
import Bean.ScoreBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreDao {

     List<ScoreBean> findAllScore();
     List<ScoreBean> findScoreById(String userid);
     List<ScoreBean> findScoreByPaperId(int paperid);



}