package com.keirnellyer.glencaldy.menu.option.loan;

import com.keirnellyer.glencaldy.Loan;
import com.keirnellyer.glencaldy.manipulation.loan.LoanProperties;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.Member;

import java.util.Scanner;

public class CreateLoanOption extends Option {
    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    public CreateLoanOption(UserRepository userRepository, StockRepository stockRepository) {
        super("Record Loan");
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void start(Scanner scanner) {
        LoanProperties loanProperties = new LoanProperties(userRepository, stockRepository);
        InputResult result = loanProperties.fetchResult(scanner, false);

        if (result != null) {
            Loan loan = loanProperties.createLoan(result);
            Member member = result.getValue(loanProperties.getUserProperty());

            member.addLoan(loan);
            System.out.println("Loan recorded.");
        }
    }
}
