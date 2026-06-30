package com.example.annotation.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.example.annotation.annotations.FieldFormatEnum.CAMEL_CASE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface SerializerType {
    FieldFormatEnum fieldFormat() default CAMEL_CASE;

    boolean pretify() default true;
}
