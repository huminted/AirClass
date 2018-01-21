package Service;

import Bean.Questions.FillBlank;
import Bean.Questions.SingleChoice;
import Bean.Questions.Tof;

import java.util.List;

public interface QuestionsService   {

    List<SingleChoice> findScById(int paperid );
    void delScById(int objectid);

    List<FillBlank> findFbById(int paperid);
    void delFbById(int objectid);

    List<Tof> findTofById(int paperid);
    void delTofById(int objectid);






}
