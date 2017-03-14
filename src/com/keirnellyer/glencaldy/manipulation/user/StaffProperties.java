package com.keirnellyer.glencaldy.manipulation.user;

import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;
import com.keirnellyer.glencaldy.user.Administrative;
import com.keirnellyer.glencaldy.user.Staff;

import java.time.LocalDate;

public class StaffProperties extends CasualProperties {

    private final IntegerProperty staffIdProperty = new IntegerProperty("Please enter the staff id.", false);
    private final StringProperty emailProperty = new StringProperty("Please enter the email address.");
    private final StringProperty extensionProperty = new StringProperty("Please enter the extension.");

    public StaffProperties() {
        super();
        addProperty(staffIdProperty);
        addProperty(emailProperty);
        addProperty(extensionProperty);
    }

    public IntegerProperty getStaffIdProperty() {
        return staffIdProperty;
    }

    public StringProperty getEmailProperty() {
        return emailProperty;
    }

    public StringProperty getExtensionProperty() {
        return extensionProperty;
    }

    public Administrative createAdministrative(InputResult result) {
        String username = result.getValue(getUsernameProperty());
        String password = result.getValue(getPasswordProperty());
        String address = result.getValue(getAddressProperty());
        String phone = result.getValue(getPhoneProperty());
        LocalDate birth = result.getValue(getBirthProperty());
        int staffId = result.getValue(getStaffIdProperty());
        String email = result.getValue(getEmailProperty());
        String extension = result.getValue(getExtensionProperty());
        return new Administrative(username, password, address, phone, birth, staffId, email, extension);
    }

    public Staff createStaff(InputResult result) {
        String username = result.getValue(getUsernameProperty());
        String password = result.getValue(getPasswordProperty());
        String address = result.getValue(getAddressProperty());
        String phone = result.getValue(getPhoneProperty());
        LocalDate birth = result.getValue(getBirthProperty());
        int staffId = result.getValue(getStaffIdProperty());
        String email = result.getValue(getEmailProperty());
        String extension = result.getValue(getExtensionProperty());
        return new Staff(username, password, address, phone, birth, staffId, email, extension);
    }

    public void updateStaff(Staff user, InputResult result) {
        super.updateCasual(user, result);

        String email = result.getValue(emailProperty);
        String extension = result.getValue(extensionProperty);

        if (email != null) user.setEmail(email);
        if (extension != null) user.setExtension(extension);
    }
}
