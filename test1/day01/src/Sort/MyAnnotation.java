package Sort;

import java.lang.annotation.*;

/**
 * @Author Administrator
 * @Date 2021/9/2 4:17
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String value() default "lala";

}
