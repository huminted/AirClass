package Service;

import Bean.DocBean;

import java.util.List;


public interface DocService {


    List<DocBean> findFileByUserId(String userid);
    List<DocBean> findAllFile();

    void addFile(DocBean file);
//    void addFileToCenter(DocBean file);

    void delFileByObjId(int objectid);
//    void delCenterFileByObjId(String objectid);

}