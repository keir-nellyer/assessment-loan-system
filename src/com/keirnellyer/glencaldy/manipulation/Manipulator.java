package com.keirnellyer.glencaldy.manipulation;

import com.keirnellyer.glencaldy.manipulation.property.InputResult;

public interface Manipulator<T> {
    T create(InputResult result);
    void update(T obj, InputResult result);
}
