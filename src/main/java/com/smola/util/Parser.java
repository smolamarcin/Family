package com.smola.util;

public interface Parser<T> {
    T validate(T t);
}
