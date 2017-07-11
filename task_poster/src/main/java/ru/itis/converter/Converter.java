package ru.itis.converter;

import java.util.function.Function;

/**
 * 26.06.2017
 * Converter
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class Converter {
    public static <T,V> V convert(T input, Function<T,V> function){
        return function.apply(input);
    }
}
