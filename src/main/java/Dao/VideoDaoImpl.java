package Dao;


import Bean.VideoBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class VideoDaoImpl  implements  VideoDao{




    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public VideoDaoImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<VideoBean> findAllFile() {
        String statement = "videoMapper.findAllVideo";
        List<VideoBean> videos = session.selectList(statement);


        return videos;
    }
}
