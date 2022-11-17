package org.example.DI;

public class Book2 {
    public static String A = "a";
    public String B = "b";

    private void c (){
        System.out.println("C");
    }

    public Book2(String b) {
        B = b;
    }

    public Book2(){

    }

    public int sum(int left, int right){
    return left + right;


    }
}
