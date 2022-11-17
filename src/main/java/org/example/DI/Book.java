package org.example.DI;

@MyAnnotation
public class Book {
    private String a = "a";

    private static String b = "Book";

    private static final String c = "Book";
    public String d = "d";

    protected String e = "E";

    public Book(){
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f(){
        System.out.println("F");
    }

    public void g(){
        System.out.println("g");
    }

    public Integer h(){
        return 100;
    }


}
