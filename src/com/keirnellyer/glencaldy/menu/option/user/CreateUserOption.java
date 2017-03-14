package com.keirnellyer.glencaldy.menu.option.user;

import com.keirnellyer.glencaldy.manipulation.Manipulators;
import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.*;

import java.util.Scanner;

public class CreateUserOption extends Option {
    private final UserRepository repository;

    public CreateUserOption(UserRepository repository) {
        super("Create User");
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        Menu menu = new Menu("User Type");
        menu.addItem(new UserTypeOption("Casual", Manipulators.CASUAL_MANAGER, Manipulators.CASUAL_MANIPULATOR));
        menu.addItem(new UserTypeOption("Full", Manipulators.CASUAL_MANAGER, Manipulators.MEMBER_MANIPULATOR));
        menu.addItem(new UserTypeOption("Staff", Manipulators.STAFF_MANAGER, Manipulators.STAFF_MANIPULATOR));
        menu.addItem(new UserTypeOption("Administrative", Manipulators.STAFF_MANAGER, Manipulators.ADMINISTRATIVE_MANIPULATOR));
        menu.startMenu(scanner);
    }

    public class UserTypeOption extends Option {
        private final PropertyManager propertyManager;
        private final Manipulator<? extends User> manipulator;

        public UserTypeOption(String userType, PropertyManager propertyManager,
                              Manipulator<? extends User> manipulator) {
            super(userType);
            this.propertyManager = propertyManager;
            this.manipulator = manipulator;
        }

        @Override
        public void start(Scanner scanner) {
            InputResult result = propertyManager.fetchResult(scanner, false);

            if (result != null) {
                User user = manipulator.create(result);

                if (user != null) {
                    repository.add(user);
                    System.out.println("New user created successfully.");
                } else {
                    System.out.println("Something went wrong whilst creating user.");
                }
            }
        }
    }
}
