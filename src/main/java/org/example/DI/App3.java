package org.example.DI;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
        //조회가 안됨 => 기본적을 에노테이션은 코멘트와 같은 개념이다. (정보가 기본적으로 source랑 class까지는 남는다.)
        //ByteCode를 로딩했을때 남지 않는다.

        //RunTime까지도 에노테이션 유지하고 싶을때는 MyAnnotation에 @Retention(RetentionPolicy.CLASS)
        //code를 컴파일 하고 바이트코드를 열어보면 그 안에는 들어 있다.
        //Retention으로 변환 했기 때문에 어떤 정보가 붙어있는지 조회가 가능하다.


        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        //클레스에만 붙어 있는 에노테이션을 갖고 오고 싶다.
        //MyBook에 붙어 있는 에노테이션만 갖고옴
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        //Book에 붙은 에노티이션을 찾아 낼 수 있다.
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        });

        //에노테이션에 붙은 정보들을 꺼내서 사용 할 수 있다.
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(MyBook.class.getAnnotations()).forEach(a->{
                if (a instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());

                    //필드에 들어 있는 에노테이션 정보 조회
                }
            });
        });

    }
}
