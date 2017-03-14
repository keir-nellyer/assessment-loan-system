package com.keirnellyer.glencaldy.menu.option;

import com.keirnellyer.glencaldy.Session;
import com.keirnellyer.glencaldy.menu.Option;

import java.util.Scanner;

public class LogoutOption extends Option {
    private final Session session;

    public LogoutOption(Session session) {
        super("Logout");
        this.session = session;
    }

    @Override
    public void start(Scanner scanner) {
        session.setLogoutTime(System.currentTimeMillis());
    }
}
