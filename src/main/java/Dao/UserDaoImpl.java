package Dao;

import Bean.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public UserDaoImpl() {
        String resource = "mybatisconf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserBean findUserById(String id) {
        String statement = "userMapper.findUserById";
        UserBean user = (UserBean)session.selectOne(statement, id);
        return user;
    }




    public void addUser(UserBean user) {
        String statement = "userMapper.addUser";
        session.insert(statement, user);
        session.commit();  //一定要记得commit
    }

    public void updateUser(UserBean user) {
        String statement = "userMapper.updateUser";
        session.update(statement,user);
        session.commit();
    }
}

