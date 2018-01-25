package Service;

import Bean.DocBean;
import Bean.DocGroupBean;

import java.util.List;


public interface DocService {


    List<DocBean> findFileByUserId(String userid);
    List<DocBean> findAllFile();
    List<DocBean> findFileByDocGroupid(int groupid);

    void addFile(DocBean file);
//    void addFileToCenter(DocBean file);

    void delFileByObjId(int objectid);
//    void delCenterFileByObjId(String objectid);



    List<DocGroupBean> findAllDocGroup();
    void addDocGroup(DocGroupBean docGroupBean);
    void delDocGroupById(int objectid);

}