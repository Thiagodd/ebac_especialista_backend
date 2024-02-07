package br.com.thiagodd.singleton;

public class DemoSingletonProperties {
    public static void main(String[] args) {

        SingletonProperties singletonProperties1 = SingletonProperties.getInstance("A");
        SingletonProperties singletonProperties2 = SingletonProperties.getInstance("B");
        SingletonProperties singletonProperties3 = SingletonProperties.getInstance("C");
        SingletonProperties singletonProperties4 = SingletonProperties.getInstance("D");

        System.out.println(singletonProperties1.getValue());
        System.out.println(singletonProperties2.getValue());
        System.out.println(singletonProperties3.getValue());
        System.out.println(singletonProperties4.getValue());
    }
}
