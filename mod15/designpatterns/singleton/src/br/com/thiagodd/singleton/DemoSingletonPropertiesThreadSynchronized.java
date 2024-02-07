package br.com.thiagodd.singleton;

public class DemoSingletonPropertiesThreadSynchronized {
    public static void main(String[] args) {

        Thread foo = new Thread(new ThreadFoo());
        Thread bar = new Thread(new ThreadBar());

        foo.start();
        bar.start();
    }

    static class ThreadFoo implements Runnable{

        @Override
        public void run(){

            SingletonPropertiesSynchronized singletonProperties = SingletonPropertiesSynchronized.getInstance("FOO");
            System.out.println(singletonProperties.getValue());
        }

    }

    static class ThreadBar implements Runnable{

        @Override
        public void run(){

            SingletonPropertiesSynchronized singletonProperties = SingletonPropertiesSynchronized.getInstance("BAR");
            System.out.println(singletonProperties.getValue());
        }

    }
}
