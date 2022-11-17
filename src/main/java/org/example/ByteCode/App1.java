package org.example.ByteCode;

import org.example.DI.Book;
import org.example.DI.MyBook;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;//클레스 로딩이 끝나면 클레스타입의 인스턴스를 만들어서 Heap에다가 넣어준다.

        //App에 어떤 클레스의 인스턴스가 있음
        //인스턴스를 통할때느 getClass, 타입을 통할 때는 .class
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        //문자열만 알고 있을 경우 (FQCN)
        //Class.forName => 문자열만 있지만 문자열을 갖고, class 타입의 인스턴스를 구할 수 있음
        Class<?> aClass1 = Class.forName("org.example.DI.Book"); // <= 이런식으로 참조가 된다.

        //클레스 인스턴스에 접근 했다.
        //  Field[] field = bookClass.getField(); //정의되어 있는 field 들을 갖고 오고 싶다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        //왜 정의된 field중 d만 나온 이유는 이 메소든 public만 리턴한다.

        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println); // 모든 필드들 다 출력 public private 관계 없이

        //field가 있는데 거기에 있는 값을 가져오고 싶을때는 인스턴스가 있어야 한다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s", f, f.get(book)); //field랑 get 한거
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        //field에 있는 값을 가져오려고 하는 것 접근이 불가능한것에 접근 하려면 Error
        //f.setAccessible(true); => 하면 모든 것에 접근이 가능하다.

        //각각의 인터페이스는 다양한 기능들 갖고 있음 예를 들어 메서드나 필드의 경우
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f-> {
            int modifiers = f.getModifiers();
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));

            //Modifier을 갖고, static 메소드를 활용하면 -> private, public인지 static인지 확인 가능 하다.

        });

        //Method 출력만
        //Object에서 상속받은 부분도 출력 가능
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //생성자랑 상위클레스 인터페이스 가져오기
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        //상위 클레스 가져오기
        //Superclass의 경우 리스트 X => 상속 하나만 받음 따라서 stream에 넣을 수 없다.
        System.out.println(MyBook.class.getSuperclass());

        //인터페이스 호출
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        //reflextion APi를 활용해서 어떤 정보를 참조하는지 알아봄



    }
}

