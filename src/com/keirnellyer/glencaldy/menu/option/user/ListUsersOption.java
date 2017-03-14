package com.keirnellyer.glencaldy.menu.option.user;

import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.Staff;
import com.keirnellyer.glencaldy.user.User;
import com.keirnellyer.glencaldy.util.Constants;

import java.util.Scanner;

public class ListUsersOption extends Option {
    private static final String FORMAT = "| %-20s | %-20s | %-20s | %-30s | %-12s | %-10s | %-8s | %-30s | %-5s |%n";

    private final UserRepository userRepository;

    public ListUsersOption(UserRepository userRepository) {
        super("List Users");
        this.userRepository = userRepository;
    }

    @Override
    public void start(Scanner scanner) {
        System.out.printf(FORMAT, "Type", "Username", "Password", "Address", "Phone Number", "Birth Date",
                "Staff ID", "Email", "Ext.");

        for (User user : userRepository.getAll()) {
            String type = user.getTitle();
            String username = user.getUsername();
            String password = user.getPassword();
            String address = "N/A";
            String phone = "N/A";
            String birth = "N/A";
            String staffId = "N/A";
            String email = "N/A";
            String extension = "N/A";

            if (user instanceof Casual) {
                Casual casual = (Casual) user;
                address = casual.getAddress();
                phone = casual.getPhoneNumber();
                birth = Constants.DATE_FORMATTER.format(casual.getBirthDate());
            }

            if (user instanceof Staff) {
                Staff staffUser = (Staff) user;
                staffId = String.valueOf(staffUser.getId());
                email = staffUser.getEmail();
                extension = staffUser.getExtension();
            }

            System.out.printf(FORMAT, type, username, password, address, phone, birth, staffId, email, extension);
        }
    }
}
