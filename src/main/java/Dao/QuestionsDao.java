package Dao;

import Bean.PaperBean;
import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;

import java.util.List;

public interface QuestionsDao {

    List<SingleChoice> findScById(int paperid );
    void delScById(int objectid);
    void addSingleChoice(SingleChoice singleChoice);

    List<FillBlank> findFbById(int paperid);
    void delFbById(int objectid);
    void addFillBlank(FillBlank fillBlank);


    List<Tof> findTofById(int paperid);
    void delTofById(int objectid);
    void addTof(Tof tof);



}
