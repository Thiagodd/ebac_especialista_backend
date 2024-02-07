package br.com.thiagodd.singleton;

public class DemoSingletonPropertiesThread {
    public static void main(String[] args) {

        Thread foo = new Thread(new ThreadFoo());
        Thread bar = new Thread(new ThreadBar());

        foo.start();
        bar.start();
    }

    static class ThreadFoo implements Runnable{

        @Override
        public void run(){

            SingletonProperties singletonProperties = SingletonProperties.getInstance("FOO");
            System.out.println(singletonProperties.getValue());
        }

    }

    static class ThreadBar implements Runnable{

        @Override
        public void run(){

            SingletonProperties singletonProperties = SingletonProperties.getInstance("BAR");
            System.out.println(singletonProperties.getValue());
        }

    }
}
