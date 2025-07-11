package com.generics;

class Register<T,S,U,V> {
    T obj ;
    S name;
    U age;
    V salary;

    public Register(T obj, S name, U age, V salary){
        this.obj = obj;
        this.name = name;
        this.age = age;
    }

    public T getObj() {
        return obj;
    }

    public S getName() {
        return name;
    }

    public U getAge() {
        return age;
    }

    public V getSalary() {
        return salary;
    }
}
class MyGeneric<T> {
    T instance;

    public MyGeneric(T instance){
        this.instance = instance;
    }

    T getInstance(){
        return instance;
    }
}
public class TestCustomGeneric {

    public static void main(String[] args) {
       // testCustomGeneric();
      //  testCustomGenericMultiParam();
        testGenericMethod();
    }

    private static void testGenericMethod() {
        genericMethod("SK");
        genericMethod(1.1);
        genericMethodMultiParam(new Dog(),"Moti",5,100);
        genericMethodMultiParam(new Cat(),"black",5,100);
        Dog d1 = new Dog();
        d1.setName("mydog");
        new Canine().move(d1);

        Cat c1 = new Cat();
        c1.setName("myCat");
        new Feline().move(c1);
        MyGeneric<Dog> dogMyGeneric = createGeneric(d1);
        MyGeneric<Cat> catMyGeneric = createGeneric(c1);
        System.out.println("generic method with return type: "+dogMyGeneric.getInstance());
        System.out.println("generic method with return type: "+catMyGeneric.getInstance());

    }

    private static <T> MyGeneric<T> createGeneric(T t) {
        return new MyGeneric<>(t);
    }

    private static <T,S,U,V> void genericMethodMultiParam(T t , S s, U u, V v) {
        Register<T,S,U,V> register = new Register(t,s,u,v);
        System.out.println("multi param generic example: "+ register.getName());
    }

    private static <T> void genericMethod(T t) {
        MyGeneric<T> myGeneric = new MyGeneric<>(t);
        System.out.println("My generic value: "+myGeneric.getInstance());
    }

    private static void testCustomGenericMultiParam() {

        Register<Dog,String,Integer,Double> register =  new Register<>(new Dog(), "gabru", 3, 10.9);
        System.out.println(register.name);

        Register<Cat,String,Integer,Double> register1 =  new Register<>(new Cat(), "billo", 3, 10.9);
        System.out.println(register1.name);
    }

    private static void testCustomGeneric() {
        MyGeneric<String> stringMyGeneric = new MyGeneric<>("Hemant");

        System.out.println("String Generic Example..."+stringMyGeneric.getInstance());


        MyGeneric<Integer> integerMyGeneric = new MyGeneric<>(1);

        System.out.println("integerMyGeneric Generic Example..."+integerMyGeneric.getInstance());
    }
}
