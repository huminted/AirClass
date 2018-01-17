package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Bean.UserBean;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public UserBean findUserById(String id) {
        return userDao.findUserById(id);
    }
    public void addUser(UserBean user){
        userDao.addUser(user);
    }

    public void updateUser(UserBean user) {
        userDao.updateUser(user);
    }
}

