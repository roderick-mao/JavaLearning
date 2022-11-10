package javase.day1109;

import java.util.function.Supplier;

class SupplierDemo {

    public static Integer max(Supplier<Integer> fun){
        return fun.get();
    }

    public static void main(String[] args) {
        int[] iList = {5,3,2,6,4};
        int maxInt = max(()-> {
                    int m = iList[0];
                    for (int a : iList) {
                        if(m<a){
                            m = a;
                        }
                    }
                    return m;
                });
        System.out.println("最大值："+maxInt);
    }
}
