package com.keirnellyer.glencaldy.menu.option.loan;

import com.keirnellyer.glencaldy.Loan;
import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.ItemProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.UserProperty;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.Member;
import com.keirnellyer.glencaldy.util.Constants;
import com.keirnellyer.glencaldy.util.Util;

import java.util.Scanner;

public class LoanReturnOption extends Option {
    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    private PropertyManager propertyManager;
    private UserProperty<Member> userProperty;
    private ItemProperty itemProperty;

    public LoanReturnOption(UserRepository userRepository, StockRepository stockRepository) {
        super("Record Return");
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;

        initialiseProperties();
    }

    private void initialiseProperties() {
        propertyManager = new PropertyManager();

        userProperty = new UserProperty<>("Please enter the username of the returnee.",
                userRepository, Member.class);
        itemProperty = new ItemProperty("Please enter the id of the item being returned.", stockRepository);

        propertyManager.addProperty(userProperty);
        propertyManager.addProperty(itemProperty);
    }

    @Override
    public void start(Scanner scanner) {
        InputResult result = propertyManager.fetchResult(scanner, false);

        if (result != null) {
            Member member = result.getValue(userProperty);
            Item item = result.getValue(itemProperty);
            Loan loan = member.getLoan(item);

            if (loan != null) {
                long daysSince = Util.daysSince(loan.getReturnByDate());

                if (daysSince > 0) {
                    float totalFine = daysSince * Constants.LATE_FINE_PER_DAY;
                    System.out.printf("Fine due: %s (%d days late).%n", Util.formatCurrency(totalFine), daysSince);
                }

                member.removeLoan(loan);
                System.out.println("User loan cleared.");
            } else {
                System.out.println("That member is not borrowing that item.");
            }
        }
    }

}
