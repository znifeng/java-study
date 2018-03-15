package annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
	public enum Color{BlUE, RED, GREEN};
	Color fruitColor() default Color.GREEN;

}
