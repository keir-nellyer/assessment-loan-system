package com.keirnellyer.glencaldy.user;

import java.time.LocalDate;
import java.util.Objects;

public class Casual extends User {
    private String address = null;
    private String phoneNumber = null;
    private LocalDate birthDate = null;

    public Casual(String username, String password, String address, String phoneNumber, LocalDate birthDate) {
        super(username, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getTitle() {
        return "Casual User";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casual)) return false;
        if (!super.equals(o)) return false;
        Casual casual = (Casual) o;
        return Objects.equals(address, casual.address) &&
                Objects.equals(phoneNumber, casual.phoneNumber) &&
                Objects.equals(birthDate, casual.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, phoneNumber, birthDate);
    }

    @Override
    public String toString() {
        return "Casual{" +
                "address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                "} " + super.toString();
    }
}
