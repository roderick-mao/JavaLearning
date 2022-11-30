package javase.day1129.jdk_DynProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynaProxyBankService {
    //目标对象
    private IService target;

    public DynaProxyBankService(IService target){this.target = target;}

    public IService getProxy(){
        //代理对象
        IService proxy = null;

        //类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //实现接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //执行处理器
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获得目标方法的名称
                String name = method.getName();
                System.out.println("日志开始追踪： The Method "+name+" begin with "+ Arrays.toString(args));
                Object result = method.invoke(target,args);
                System.out.println("日志追踪结束");
                return result;
            }
        };
        proxy = (IService) Proxy.newProxyInstance(classLoader,interfaces,handler);
        return proxy;
    }
}
