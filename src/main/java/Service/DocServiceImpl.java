package Service;

import Bean.DocBean;
import Bean.DocGroupBean;
import Dao.DocDao;
import Dao.DocDapImpl;

import java.util.HashMap;
import java.util.List;

public class DocServiceImpl implements DocService {

    private DocDao docDao;
    public DocServiceImpl() {

        docDao =new DocDapImpl();

    }


    public List<DocBean> findFileByUserId(int userid) {


        return docDao.findFileByUserId(userid);
    }


    public List<DocBean> findAllFile() {

        return docDao.findAllFile();
    }

    @Override
    public List<DocBean> findFileByDocGroupid(int groupid) {
        return docDao.findFileByDocGroupid(groupid);
    }

    @Override
    public List<DocBean> findFileByUserIdAndGroupId(HashMap map) {

        return docDao.findFileByUserIdAndGroupId(map);
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

    @Override
    public List<DocGroupBean> findAllDocGroup() {
        return docDao.findAllDocGroup();
    }

    @Override
    public void addDocGroup(DocGroupBean docGroupBean) {
        docDao.addDocGroup(docGroupBean);
    }

    @Override
    public void delDocGroupById(int objectid) {
        docDao.delDocGroupById(objectid);
    }

//    @Override
//    public void delCenterFileByObjId(String objectid) {
//        fileDao.delCenterFileByObjId(objectid);
//    }
}



