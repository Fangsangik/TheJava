package org.example.DI;

import javax.swing.text.Element;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD}) // 타입과 필드에만 에노터이션을 붙일 수 있다.
@Retention(RetentionPolicy.CLASS)
@Inherited // 상속이 되는 에노테이션이다.
public @interface MyAnnotation {
    //기본적인 값을 갖을수 있다.
    String name() default "상익";

    int number() default 100;

    String value() default "주연";
    // value라고 주면 값을 줄때 명시할 필요 없이 "주연" 적어주면 된다.
    // 단 속성을 여러개 설정 할때는 하나하나 값을 주어야 함.

    //기본 값을 안주면 사용한 class에 따로 붙여주어야 한다.

    //에노테이션의 경우 생성자 필드 타입에 어디든 붙일 수 있다.
}
