package com.example.annotation.processor;

import com.example.annotation.annotations.SerializerType;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class SerializerProcessor {
    public String serialazer(final Object object) throws IllegalAccessException {
        Objects.requireNonNull(object, "Enter with non null object");

       var clazz = object.getClass();
        var typeAnnotation = Stream.of(clazz.getAnnotations())
                .flatMap(a -> (a instanceof SerializerType s) ? Stream.of(s) : Stream.empty())
                /*.filter(SerializerType.class::isInstance)
                .map(SerializerType.class::cast)*/
                .findFirst()
                .orElseThrow(() ->  new NoSuchElementException("For serializer object annotated with @SerializerType"));
        var fieldNameFormatter = typeAnnotation.fieldFormat().getFormat();
        var prettify = typeAnnotation.pretify();

        Map<String, Object> elements = new HashMap<>();
        for(var field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            elements.put(field.getName(), field.get(object));
        }

        var annotationMethods = Stream.of(object.getClass().getMethods())
                .filter(m -> Stream.of(m.getAnnotations())
                        .anyMatch(a -> a.annotationType()
                                .equals(SerializerType.class)))
                .toList();

        for(var method : clazz.getDeclaredMethods()){}
        return null;
    }
}
