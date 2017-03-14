package com.keirnellyer.glencaldy.user;

import java.time.LocalDate;

public class Administrative extends Staff {
    public Administrative(String username, String password, String address, String phoneNumber, LocalDate birthDate, int id, String email, String extension) {
        super(username, password, address, phoneNumber, birthDate, id, email, extension);
    }

    @Override
    public String getTitle() {
        return "Administrative";
    }

    @Override
    public String toString() {
        return "Administrative{} " + super.toString();
    }
}
