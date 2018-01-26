package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Bean.UserBean;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public UserBean findUserById(int userid) {
        return userDao.findUserById(userid);
    }
    public void addUser(UserBean user){
        userDao.addUser(user);
    }

    public void updateUser(UserBean user) {
        userDao.updateUser(user);
    }
}

