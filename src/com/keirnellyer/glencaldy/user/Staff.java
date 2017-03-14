package com.keirnellyer.glencaldy.user;

import java.time.LocalDate;
import java.util.Objects;

public class Staff extends Member {
    private final int id;
    private String email;
    private String extension;

    public Staff(String username, String password, String address, String phoneNumber, LocalDate birthDate, int staffId, String email, String extension) {
        super(username, password, address, phoneNumber, birthDate);
        this.id = staffId;
        this.email = email;
        this.extension = extension;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String getTitle() {
        return "Staff";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return id == staff.id &&
                Objects.equals(email, staff.email) &&
                Objects.equals(extension, staff.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, email, extension);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", extension='" + extension + '\'' +
                "} " + super.toString();
    }
}
