package Service;

import Bean.UserBean;

public interface UserService {


    public UserBean findUserById(String id);
    public void addUser(UserBean user);
    public void updateUser(UserBean user);

}