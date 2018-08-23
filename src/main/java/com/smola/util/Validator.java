package com.smola.util;

public interface Validator<T> {
    T validate(T t);
}
