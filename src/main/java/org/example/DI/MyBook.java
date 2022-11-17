package org.example.DI;

//MyBook이 Book을 상속 받고 있고 Book에서 에노테이션을 받고 있음으로,
//MyBook에서도 Book에 붙은 호출이 가능하다.
public class MyBook extends Book implements MyInterface {
}
