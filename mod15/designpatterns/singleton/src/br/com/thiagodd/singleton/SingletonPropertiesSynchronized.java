package br.com.thiagodd.singleton;

public final class SingletonPropertiesSynchronized {

    private static SingletonPropertiesSynchronized singleton;

    private String value;

    private SingletonPropertiesSynchronized(String value) {
        this.value = value;
    }

    public static synchronized SingletonPropertiesSynchronized getInstance(String value){
        if (singleton == null) {
            singleton = new SingletonPropertiesSynchronized(value);
        }

        return singleton;
    }

    public String getValue() {
        return value;
    }
}
