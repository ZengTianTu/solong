package com.solong.jasongj.java.annotation;

import java.lang.annotation.*;

/**
 * Created by king on 2020/2/21.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.SOURCE)
@Documented
@Inherited
public @interface Component {
    String identifier() default "";
}
