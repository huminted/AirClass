package Service;

import Bean.PaperBean;
import Dao.PaperDao;
import Dao.PaperDaoImpl;

import java.util.List;

public class PaperServiceImpl implements PaperService {


    private PaperDao paperDao;
    public PaperServiceImpl() {

        paperDao =new PaperDaoImpl();

    }



    public List<PaperBean> findAllPaper() {
        return paperDao.findAllPaper();
    }

    @Override
    public PaperBean findPaperById(int objectid) {
        return paperDao.findPaperById(objectid);
    }

    @Override
    public PaperBean findPaperByCode(String code) {
        return  paperDao.findPaperByCode(code);
    }

    @Override
    public void addPaper(PaperBean paper) {

        paperDao.addPaper(paper);
    }

    @Override
    public void delPaperById(int objectid) {
        paperDao.delPaperById(objectid);
    }


}
