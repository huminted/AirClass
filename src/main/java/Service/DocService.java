package Service;

import Bean.DocBean;
import Bean.DocGroupBean;

import java.util.HashMap;
import java.util.List;


public interface DocService {


    List<DocBean> findFileByUserId(int userid);
    List<DocBean> findAllFile();
    List<DocBean> findFileByDocGroupid(int groupid);

    List<DocBean> findFileByUserIdAndGroupId(HashMap map);

    void addFile(DocBean file);
//    void addFileToCenter(DocBean file);

    void delFileByObjId(int objectid);
//    void delCenterFileByObjId(String objectid);



    List<DocGroupBean> findAllDocGroup();
    void addDocGroup(DocGroupBean docGroupBean);
    void delDocGroupById(int objectid);

}