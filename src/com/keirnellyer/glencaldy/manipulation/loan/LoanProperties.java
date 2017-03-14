package com.keirnellyer.glencaldy.manipulation.loan;

import com.keirnellyer.glencaldy.Loan;
import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.ItemProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.LocalDateProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.UserProperty;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.Member;

import java.time.LocalDate;

public class LoanProperties extends PropertyManager {

    private final UserProperty<Member> userProperty;
    private final ItemProperty itemProperty;
    private final LocalDateProperty returnDateProperty;

    public LoanProperties(UserRepository userRepository, StockRepository stockRepository) {
        super();

        userProperty = new UserProperty<>("Please enter the username of the user.", false,
                userRepository, Member.class);
        itemProperty = new ItemProperty("Please enter the id of the item to loan.", stockRepository);
        returnDateProperty = new LocalDateProperty("Please enter the date the item is due back.");

        addProperty(userProperty);
        addProperty(itemProperty);
        addProperty(returnDateProperty);
    }

    public UserProperty<Member> getUserProperty() {
        return userProperty;
    }

    public ItemProperty getItemProperty() {
        return itemProperty;
    }

    public LocalDateProperty getReturnDateProperty() {
        return returnDateProperty;
    }

    public Loan createLoan(InputResult result) {
        Item item = result.getValue(itemProperty);
        LocalDate returnDate = result.getValue(returnDateProperty);
        return new Loan(item, LocalDate.now(), returnDate);
    }
}
