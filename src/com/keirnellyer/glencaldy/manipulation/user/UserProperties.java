package com.keirnellyer.glencaldy.manipulation.user;

import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;
import com.keirnellyer.glencaldy.user.User;

public class UserProperties extends PropertyManager {
    private final StringProperty usernameProperty = new StringProperty("Please enter the username.", false);
    private final StringProperty passwordProperty = new StringProperty("Please enter the password.");

    public UserProperties() {
        addProperty(usernameProperty);
        addProperty(passwordProperty);
    }

    public StringProperty getUsernameProperty() {
        return usernameProperty;
    }

    public StringProperty getPasswordProperty() {
        return passwordProperty;
    }

    public void updateUser(User user, InputResult result) {
        String password = result.getValue(passwordProperty);
        if (password != null) user.setPassword(password);
    }
}
