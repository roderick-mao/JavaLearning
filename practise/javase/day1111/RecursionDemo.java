package javase.day1111;

class RecursionDemo {
    public static long NRecursion(long n){
        if (n == 1){
            return 1;
        }else {
           return  (n * RecursionDemo.NRecursion(n - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(RecursionDemo.NRecursion(20));
    }
}
