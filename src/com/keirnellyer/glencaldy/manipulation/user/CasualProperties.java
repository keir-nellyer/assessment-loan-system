package com.keirnellyer.glencaldy.manipulation.user;

import com.keirnellyer.glencaldy.manipulation.property.type.LocalDateProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.Member;

import java.time.LocalDate;

public class CasualProperties extends UserProperties {

    private final StringProperty addressProperty = new StringProperty("Please enter the address.");
    private final StringProperty phoneProperty = new StringProperty("Please enter the phone number.");
    private final LocalDateProperty birthProperty = new LocalDateProperty("Please enter the birth date.");

    public CasualProperties() {
        super();

        addProperty(addressProperty);
        addProperty(phoneProperty);
        addProperty(birthProperty);
    }

    public StringProperty getAddressProperty() {
        return addressProperty;
    }

    public StringProperty getPhoneProperty() {
        return phoneProperty;
    }

    public LocalDateProperty getBirthProperty() {
        return birthProperty;
    }

    public Member createFullMember(InputResult result) {
        String username = result.getValue(getUsernameProperty());
        String password = result.getValue(getPasswordProperty());
        String address = result.getValue(getAddressProperty());
        String phone = result.getValue(getPhoneProperty());
        LocalDate birth = result.getValue(getBirthProperty());
        return new Member(username, password, address, phone, birth);
    }

    public Casual createCasual(InputResult result) {
        String username = result.getValue(getUsernameProperty());
        String password = result.getValue(getPasswordProperty());
        String address = result.getValue(getAddressProperty());
        String phone = result.getValue(getPhoneProperty());
        LocalDate birth = result.getValue(getBirthProperty());
        return new Casual(username, password, address, phone, birth);
    }

    public void updateCasual(Casual user, InputResult result) {
        super.updateUser(user, result);

        String address = result.getValue(addressProperty);
        String phone = result.getValue(phoneProperty);
        LocalDate birth = result.getValue(birthProperty);

        if (address != null) user.setAddress(address);
        if (phone != null)  user.setPhoneNumber(phone);
        if (birth != null) user.setBirthDate(birth);
    }
}
