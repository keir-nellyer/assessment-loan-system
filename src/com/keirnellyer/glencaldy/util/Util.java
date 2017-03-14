package com.keirnellyer.glencaldy.util;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Util {
    private Util() {}

    /**
     * Gets the total length of all the arrays combined.
     *
     * @param arrays the array to calculate the length of
     * @return the total length of the arrays
     */
    public static int getTotalLength(Object[]... arrays) {
        return Stream.of(arrays)
                .map(array -> array.length)
                .mapToInt(i -> i)
                .sum();
    }

    /**
     * Combines two arrays together.
     *
     * @param target the target array (must of correct size)
     * @param arrays the arrays to combine
     * @param <T> the type of the arrays
     * @return the combined arrays result
     */
    @SafeVarargs
    public static <T> T[] combineArrays(T[] target, T[]... arrays) {
        return Stream.of(arrays)
                .flatMap(Stream::of)
                .toArray(size -> target);
    }

    public static long daysSince(LocalDate date) {
        return ChronoUnit.DAYS.between(date, LocalDate.now());
    }

    public static String formatCurrency(float amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount);
    }
}
