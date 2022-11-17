package org.example.DI;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    //<T> T Type은 generic method 선언, 리턴할때 Object로 나오는게 아닌,
    //메소드에 파라미터로 넘겨주는 클레스 타입으로 리턴을 하고 싶을때 메소드를 선언
/*
    public static <T> T getObject(Class<T> classType){
        return createInstance(classType);
    }

 */

    public static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    //class Type에 들어 있는 field들을 살펴봄
    // 각각의 필드에서 붙어 있는 에노테이션 찾아봄

    public static <T> T getObject(Class<T> classType){
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f->{
            Inject annotation = f.getAnnotation(Inject.class);
            if (f.getAnnotation(Inject.class) != null){
                Object instance1 = createInstance(f.getType());// 필드의 타입은 BookRepository
                f.setAccessible(true);
                try {
                    f.set(instance, instance1);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instance;
    }

}
