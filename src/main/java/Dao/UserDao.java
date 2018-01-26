package Dao;

import Bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  {

    public UserBean findUserById(int userid); //查询
    public void addUser(UserBean user); //添加
    public void updateUser(UserBean user); //修改

}

