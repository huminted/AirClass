package Dao;

import Bean.DocBean;
import Bean.DocGroupBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocDao {


     List<DocBean> findFileByUserId(String userid); //查询
     List<DocBean> findAllFile();

     List<DocBean> findFileByDocGroupid(int groupid);

     void addFile(DocBean file); //添加
//     void addFileToCenter(DocBean file);

     void delFileByObjId(int objectid);
//     void delCenterFileByObjId(String objectid);



     List<DocGroupBean> findAllDocGroup();
     void addDocGroup(DocGroupBean docGroupBean);
     void delDocGroupById(int objectid);

}