package javase.day1129.jdk_DynProxy;

import java.util.concurrent.TimeUnit;

public class BankService implements IService{
    @Override
    public void login(Long id, String pwd) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (id.equals(1L) && pwd.equals("123")){
            System.out.println("登录成功");
            return;
        }
        System.out.println("登录失败");
    }

    @Override
    public void register(Long id, String name, String pwd) {
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("注册成功： id = "+id+"， name = "+name+", pwd = "+pwd);
    }
}
