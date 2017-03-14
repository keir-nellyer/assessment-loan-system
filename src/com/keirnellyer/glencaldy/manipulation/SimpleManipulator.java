package com.keirnellyer.glencaldy.manipulation;

import com.keirnellyer.glencaldy.manipulation.property.InputResult;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Used in cases whereby object manipulation must be handled externally.
 * @param <T> the type of object to manipulate
 */
public class SimpleManipulator<T> implements Manipulator<T> {
    private final Function<InputResult, T> create;
    private final BiConsumer<T, InputResult> update;

    public SimpleManipulator(Function<InputResult, T> create, BiConsumer<T, InputResult> update) {
        this.create = create;
        this.update = update;
    }

    @Override
    public T create(InputResult result) {
        return create.apply(result);
    }

    @Override
    public void update(T obj, InputResult result) {
        update.accept(obj, result);
    }
}
