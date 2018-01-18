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


}
