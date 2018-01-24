package Service;

import Bean.DocBean;
import Dao.DocDao;
import Dao.DocDapImpl;

import java.util.List;

public class DocServiceImpl implements DocService {

    private DocDao docDao;
    public DocServiceImpl() {

        docDao =new DocDapImpl();

    }


    public List<DocBean> findFileByUserId(String userid) {


        return docDao.findFileByUserId(userid);
    }


    public List<DocBean> findAllFile() {

        return docDao.findAllFile();
    }


    public void addFile(DocBean file) {

        docDao.addFile(file);

    }


//    public void addFileToCenter(DocBean file) {
//       fileDao.addFileToCenter(file);
//    }


    public void delFileByObjId(int objectid) {

        docDao.delFileByObjId(objectid);
    }

//    @Override
//    public void delCenterFileByObjId(String objectid) {
//        fileDao.delCenterFileByObjId(objectid);
//    }
}



