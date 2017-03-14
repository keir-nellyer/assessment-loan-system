package com.keirnellyer.glencaldy.runtime;

import com.keirnellyer.glencaldy.Session;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.option.loan.CreateLoanOption;
import com.keirnellyer.glencaldy.menu.option.ExitApplicationOption;
import com.keirnellyer.glencaldy.menu.option.LogoutOption;
import com.keirnellyer.glencaldy.menu.option.loan.LoanReturnOption;
import com.keirnellyer.glencaldy.menu.option.loan.ViewLoansOption;
import com.keirnellyer.glencaldy.menu.option.stock.ListStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.CreateStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.EditStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.SearchStockOption;
import com.keirnellyer.glencaldy.menu.option.user.EditProfileOption;
import com.keirnellyer.glencaldy.menu.option.user.ListUsersOption;
import com.keirnellyer.glencaldy.menu.option.user.CreateUserOption;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.*;

import java.util.Scanner;

public class Controller implements Application {

    private static final Model model = new Model();

    public static void main(String[] args) {
        populateModel();

        Controller controller = new Controller();
        controller.start();
    }

    public static void populateModel() {
        model.populateItems();
        model.populateUsers();
    }

    // by default Scanner uses a space as a delimiter however we always want to
    // read the full line
    private Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    private Session currentSession;
    private boolean running;

    @Override
    public void start() {
        running = true;

        try {
            // creates a new session when the current session is either non-existent or killed
            while (running) {
                User user = processLogin();

                if (user != null) {
                    currentSession = new Session(-1);
                    user.setSession(currentSession);

                    while (running && currentSession.isActive()) {
                        Menu menu = buildMenu(user);
                        menu.startMenu(scanner);
                    }
                }
            }
        } finally {
            scanner.close();
            scanner = null;
        }

        System.exit(0);
    }

    @Override
    public void stop() {
        running = false;
    }

    public User processLogin() {
        User user;

        do {
            System.out.println("Please enter your username.");
            String username = scanner.next();

            System.out.println("Please enter your password.");
            String password = scanner.next();

            user = findUser(username, password);

            if (user == null) { // invalid credentials
                System.out.println("Invalid credentials, please try again.");
            }
        } while (user == null);

        return user;
    }

    private Menu buildMenu(User user) {
        Menu menu = new Menu(String.format("%s Options", user.getTitle()));

        UserRepository userRepository = model.getUserRepository();
        StockRepository stockRepository = model.getStockRepository();

        if (user instanceof Casual) {
            menu.addItem(new SearchStockOption(stockRepository));
        }

        if (user instanceof Member) {
            menu.addItem(new ViewLoansOption((Member) user));
        }

        if (user instanceof Staff) {
            // currently no special staff options
        }

        if (user instanceof Administrative) {
            menu.addItem(new CreateUserOption(userRepository));
            menu.addItem(new ListUsersOption(userRepository));
            menu.addItem(new CreateStockOption(stockRepository));
            menu.addItem(new EditStockOption(stockRepository));
            menu.addItem(new ListStockOption(stockRepository));
            menu.addItem(new CreateLoanOption(userRepository, stockRepository));
            menu.addItem(new LoanReturnOption(userRepository, stockRepository));
        }

        menu.addItem(new EditProfileOption(user));
        //menu.addItem(new ChangePasswordOption(user));
        menu.addItem(new LogoutOption(currentSession));
        menu.addItem(new ExitApplicationOption(this));

        return menu;
    }

    private User findUser(String username, String password) {
        for (User user : model.getUserRepository().getAll()) {
            if (checkCredentials(user, username, password)) {
                return user;
            }
        }

        return null;
    }

    private boolean checkCredentials(User user, String username, String password) {
        return user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password);
    }
}
