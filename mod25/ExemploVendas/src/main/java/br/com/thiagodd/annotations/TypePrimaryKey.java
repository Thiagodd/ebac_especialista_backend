package main.java.br.com.thiagodd.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypePrimaryKey {

    String value();
}
