package javase.day1128.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Book(value = "testBookName1",author = {"a1","a2"})
public class BookStore {
    @Book(value = "java",author = {"c1","c3"})
    private String name;

    @Book(value = "bookName2",price = 80,author = {"b1","b2"})
    public void purchase(){}



}

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Book{

    String value();

    double price() default 100;

    String[] author();

}

class Demo{
    public static void main(String[] args) throws NoSuchFieldException {
        Class<BookStore> clazz = BookStore.class;
        Field nameField = clazz.getDeclaredField("name");
        if (nameField.isAnnotationPresent(Book.class)) {
            Book book = nameField.getAnnotation(Book.class);
            System.out.println(book.value());
            System.out.println(book.price());
            System.out.println(book.author());
        }



    }
}


