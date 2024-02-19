import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("Hello world!");
        executeMethods();
    }

    private static void executeMethods() throws NoSuchMethodException {
        System.out.println("*** Métodos ***");
        ProductReflection prod = new ProductReflection();
        Method[] methods = prod.getClass().getDeclaredMethods();

        for (Method method : methods){
            System.out.println("Nome completo: " + method);
            System.out.println("Nome simples: " + method.getName());
            System.out.println("Tipo de retorno: " + method.getReturnType());
            System.out.println(" ");
        }

        Method method = prod.getClass().getMethod("getNome");
        System.out.println("Pegando método pelo nome: " + method.getName());

        Method method1 = prod.getClass().getMethod("setNome", String.class);
        System.out.println("Pegando método pelo nome: " + method1.getName());




    }
}

