package Dao;


import Bean.PaperBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
public class PaperDaoImpl implements PaperDao {




    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public PaperDaoImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<PaperBean> findAllPaper() {
        String statement = "paperMapper.findAllPaper";
        List<PaperBean> paper = session.selectList(statement);



        return paper;
    }




}
