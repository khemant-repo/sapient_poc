package demo;

public class Application {

    public static void main(String[] args) {
        int a = 5;
        int  b = 6;
        AddNumbers result = (i,j)-> {return a+b;};
        System.out.println(result.addNumbers(a,b));
    }

}