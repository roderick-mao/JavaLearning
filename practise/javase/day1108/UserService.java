package javase.day1108;

import javax.swing.*;

public class UserService {
    private UserDao userDao = UserDao.getInstance();

    public boolean register(User user){
        boolean flag = userDao.insert(user);
        return  flag;
    }

    public User login(String username, String passwd){
        User user = userDao.selectOne(username,passwd);
        if (user==null) {
            JOptionPane.showMessageDialog(null,"账号或密码不正确！");
            return null;
        }
        return user;
    }
}
