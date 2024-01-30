package Service;

import pojo.User;



public interface userService {

    public int saveUser(User user);

    public int getUserById(String userId);

    public User getUserByIdByPass(String userId,String password);
}
