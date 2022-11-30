package javase.day1129.jdk_DynProxy;

public class Test {
    public static void main(String[] args) {
        IService target = new BankService();
        IService proxy = new DynaProxyBankService(target).getProxy();
        proxy.login(1L,"123");
    }
}
