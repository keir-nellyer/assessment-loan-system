package com.keirnellyer.glencaldy.runtime;

public interface Application {

    /**
     * Starts the startup sequence.
     */
    void start();

    /**
     * Starts the shutdown sequence.
     */
    void stop();
}
