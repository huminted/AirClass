package Service;


import Bean.PaperBean;

import java.util.List;

public interface    PaperService {

    List<PaperBean> findAllPaper();
    PaperBean findPaperById(int objectid);
    PaperBean findPaperByCode(String code);

    void addPaper(PaperBean paper);

}
