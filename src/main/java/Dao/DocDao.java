package Dao;

import Bean.DocBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocDao {


     List<DocBean> findFileByUserId(String userid); //查询
     List<DocBean> findAllFile();

     void addFile(DocBean file); //添加
//     void addFileToCenter(DocBean file);

     void delFileByObjId(int objectid);
//     void delCenterFileByObjId(String objectid);

}