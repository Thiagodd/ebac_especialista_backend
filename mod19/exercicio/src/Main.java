package mod19.exercicio.src;

public class Main {
    public static void main(String[] args) {
        loadAnnotation();
    }

    private static void loadAnnotation(){
        Product product = new Product();

       if (product.getClass().isAnnotationPresent(AnnotationTable.class)){
           AnnotationTable annotationTable = product.getClass().getAnnotation(AnnotationTable.class);
           System.out.printf("Annotation Value: %s", annotationTable.value());
       }
    }
}
