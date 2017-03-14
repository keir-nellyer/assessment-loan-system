package com.keirnellyer.glencaldy.menu.option;

import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.user.User;

import java.util.Scanner;

import static com.keirnellyer.glencaldy.util.InputUtil.*;

/**
 * Old menu option before from {@link com.keirnellyer.glencaldy.menu.option.user.EditProfileOption} was implemented.
 * This class can be ignored.
 */
public class ChangePasswordOption extends Option {

    private final User user;

    public ChangePasswordOption(User user) {
        super("Change Password");
        this.user = user;
    }

    @Override
    public void start(Scanner scanner) {
        if (confirmIdentity(scanner)) {
            String newPassword = fetchNewPassword(scanner);

            if (!checkAbort(newPassword)) {
                boolean confirmed = confirmNewPassword(scanner, newPassword);

                if (confirmed) {
                    updatePassword(newPassword);
                }
            }
        }
    }

    private boolean confirmIdentity(Scanner scanner) {
        boolean aborted = false;
        boolean identityProven = false;

        do {
            String enteredPassword = fetchCurrentPassword(scanner);

            if (!checkAbort(enteredPassword)) {
                identityProven = checkPassword(enteredPassword);

                if (!identityProven) {
                    System.out.println("Incorrect password, please try again.");
                }
            } else {
                aborted = true;
            }
        } while (!aborted && !identityProven);

        return identityProven;
    }

    private boolean checkPassword(String enteredPassword) {
        return user.getPassword().equals(enteredPassword);
    }

    private String fetchCurrentPassword(Scanner scanner) {
        System.out.println("Please enter your current password.");
        return scanner.next();
    }

    private String fetchNewPassword(Scanner scanner) {
        System.out.println("Please enter your new password.");
        return scanner.next();
    }

    private boolean confirmNewPassword(Scanner scanner, String newPassword) {
        boolean aborted = false;
        boolean confirmed = false;

        do {
            System.out.println("Please re-enter your new password.");
            String enteredPassword = scanner.next();

            if (!checkAbort(enteredPassword)) {
                confirmed = newPassword.equals(enteredPassword);

                if (!confirmed) {
                    System.out.println("Those password do not match, please try again.");
                }
            } else {
                aborted = true;
            }
        } while (!aborted && !confirmed);

        return confirmed;
    }

    private void updatePassword(String newPassword) {
        user.setPassword(newPassword);
        System.out.println("Your password has been changed.");
    }
}
