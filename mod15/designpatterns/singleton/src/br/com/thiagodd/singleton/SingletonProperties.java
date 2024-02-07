package br.com.thiagodd.singleton;

public final class SingletonProperties {

    private static SingletonProperties singleton;

    private String value;

    private SingletonProperties(String value) {
        this.value = value;
    }

    public static SingletonProperties getInstance(String value){
        if (singleton == null) {
            singleton = new SingletonProperties(value);
        }

        return singleton;
    }

    public String getValue() {
        return value;
    }
}
