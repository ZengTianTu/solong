package com.solong.jasongj.design_mode.factory;

import java.lang.annotation.*;

/**
 * Created by king on 2020/2/23.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Vehicle {
    String type() default "五菱宏光";

    String value() default "";
}
