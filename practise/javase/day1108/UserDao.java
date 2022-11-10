package javase.day1108;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> list;

    private static UserDao userDao;

    private UserDao(){
        list = new ArrayList<User>();
    }

    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public User selectOne(String name, String passwd){
        if(name!=null && passwd!=null && name!="" && passwd!=""){
            for (User u:
                 list) {
                if (u!=null && name.equals(u.getName()) && passwd.equals(u.getPasswd())){
                    return u;
                }
            }
        }
        return null;
    }

    public boolean insert(User user){
        if (user != null){
            list.add(user);
            return true;
        }
        return false;
    }
}
