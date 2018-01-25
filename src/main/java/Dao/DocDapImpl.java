package Dao;

import Bean.DocBean;
import Bean.DocGroupBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DocDapImpl implements DocDao {


    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public DocDapImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<DocBean> findFileByUserId(String userid) {
        String statement = "docMapper.findFileByUserId";
        List<DocBean> file = session.selectList(statement, userid);
        return file;
    }


    public List<DocBean> findAllFile() {

        String statement = "docMapper.findAllFile";
        List<DocBean> file = session.selectList(statement);


        return file;
    }

    @Override
    public List<DocBean> findFileByDocGroupid(int groupid) {
        String find="docMapper.findFileByDocGroupid";
        List<DocBean> file = session.selectList(find,groupid);

        return file;

    }

    public void addFile(DocBean file) {
        String statement = "docMapper.addFile";
        session.insert(statement, file);
        session.commit();  //一定要记得commit
    }


//    public void addFileToCenter(DocBean file) {
//
//        String statement = "docMapper.addFileToCenter";
//        session.insert(statement, file);
//        session.commit();
//
//    }


    public void delFileByObjId(int objectid) {
        String statement = "docMapper.delFileByObjId";
        session.delete(statement,objectid);
        session.commit();

    }

    @Override
    public List<DocGroupBean> findAllDocGroup() {

        String find="docMapper.findAllDocGroup";
        List<DocGroupBean> list=   session.selectList(find);

        return list;
    }

    @Override
    public void addDocGroup(DocGroupBean docGroupBean) {
        String add="docMapper.addDocGroup";
        session.insert(add,docGroupBean);
        session.commit();

    }

    @Override
    public void delDocGroupById(int objectid) {
        String del="docMapper.delDocGroupById";
        session.delete(del,objectid);
        session.commit();

    }


//    public void delCenterFileByObjId(String objectid) {
//        String statement = "docMapper.delCenterFileByObjId";
//        session.delete(statement,objectid);
//        session.commit();
//
//    }


}
