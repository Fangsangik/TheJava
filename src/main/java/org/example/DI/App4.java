package org.example.DI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Book2> book2Class = Book2.class;

        //직접 Book2를 참조 할 수없는 상태일때
        Class<?> aClass = Class.forName("org.example.DI.Book2");

        //Constructor를 사용하면 새로운 생성자를 만들 수 있다.
        Constructor<Book2> constructor = book2Class.getConstructor(String.class);
        // 갖고 있는 생성자 중 어떠한 파라미터를 갖고 있는 생성자를 가져오고 싶다, 이때는 생성자가 받는 파라미터이기 때문에 newInstance 부분에 그냥 호출하면 Error
        Book2 book2 = constructor.newInstance("myBook"); //=> Book2에 새로운 인스턴스 생성된다.
        System.out.println(book2);


        Field a = Book2.class.getDeclaredField("A");
        //이 필드가 특정한 인스턴스에 해당하는 필드면 인스턴스를 넘겨 줄 수 있다.
        System.out.println(a.get(null)); // 특정한 Object를 넘겨 줄 게 없다.
        //필드가 특정한 인스턴스에 해당되는 것이 아니기 때문에 class에 해당하는 것이기에 Object 자리에 null
        a.set(null, "AAAAA");
        System.out.println(a.get(null)); //=> 값이 변화 (A => AAAAA)

        //특정한 인스턴스에 해당하는 값 가져오기
        //B의 경우 특정한 인스턴스에 해당하는 필드 => 특정한 인스턴스를 거쳐서 가져와야 한다.
        //book2라는 인스턴스가 만들어져야 필드를 가져오는 거기 때문
        Field b =Book2.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book2));
        b.set(book2, "BBBBBB");
        System.out.println(b.get(book2));


        //메소드로 가져오기
        //아무것도 호출 하지 않기 때문에 값을 주지 않아도 호출 가능
        /*
        Method c =Book2.class.getDeclaredMethod("C");
        c.setAccessible(true);
        c.invoke(book2);
         */

        Method c =Book2.class.getDeclaredMethod("sum", int.class, int.class);//파라미터 타입을 가져와하 한다.
        int invoke = (int) c.invoke(book2, 1, 2);
        System.out.println(invoke);


    }
}
