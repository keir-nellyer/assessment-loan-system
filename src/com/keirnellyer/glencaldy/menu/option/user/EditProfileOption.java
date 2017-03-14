package com.keirnellyer.glencaldy.menu.option.user;

import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.Manipulators;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.user.User;

import java.util.Scanner;

public class EditProfileOption extends Option {
    private final User user;

    public EditProfileOption(User user) {
        super("Edit Profile");
        this.user = user;
    }

    @Override
    public void start(Scanner scanner) {
        PropertyManager propertyManager = Manipulators.getUserPropertyManager(user.getClass());
        Manipulator<User> manipulator = Manipulators.getUserManipulator(user.getClass());
        edit(scanner, propertyManager, manipulator);
    }

    public void edit(Scanner scanner, PropertyManager propertyManager, Manipulator<? super User> manipulator) {
        InputResult result = propertyManager.fetchResult(scanner, true);

        if (result != null) {
            manipulator.update(user, result);
            System.out.println("Profile updated.");
        }
    }
}
