package Dao;

import Bean.PaperBean;


import java.util.List;

public interface PaperDao {

    List<PaperBean> findAllPaper();
    PaperBean findPaperById(int objectid);
    PaperBean findPaperByCode(String code);

    void addPaper(PaperBean paper);

    void delPaperById(int objectid);



}
