package com.keirnellyer.glencaldy.menu.option;

import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.runtime.Application;

import java.util.Scanner;

public class ExitApplicationOption extends Option {
    private final Application application;

    public ExitApplicationOption(Application application) {
        super("Exit Application");
        this.application = application;
    }

    @Override
    public void start(Scanner scanner) {
        application.stop();
    }
}
