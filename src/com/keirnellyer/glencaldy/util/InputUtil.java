package com.keirnellyer.glencaldy.util;

public class InputUtil {

    // prevent class from being instantiated
    private InputUtil() {}

    /**
     * Checks if the user input implies the user wishes to abort the operation.
     * This can be implied by a single backslash ('\').
     *
     * When the operation should be aborted (ie this method returns true), a message
     * will also be shown in the console, alerting the user of the abortion.
     *
     * @param input the input
     * @return true if the operation should be aborted, false otherwise
     */
    public static boolean checkAbort(String input) {
        boolean abort = input.equals("");

        if (abort) {
            System.out.println("Aborting operation.");
        }

        return abort;
    }

    public static boolean checkSkip(String input) {
        return input.equals("");
    }
}
