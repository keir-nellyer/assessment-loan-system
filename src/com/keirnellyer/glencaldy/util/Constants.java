package com.keirnellyer.glencaldy.util;

import java.time.format.DateTimeFormatter;

public class Constants {

    public static final float LATE_FINE_PER_DAY = 0.50f;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

    private Constants() {}
}
