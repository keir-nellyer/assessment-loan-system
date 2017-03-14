package com.keirnellyer.glencaldy.menu.option.loan;

import com.keirnellyer.glencaldy.Loan;
import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.user.Member;
import com.keirnellyer.glencaldy.util.Constants;
import com.keirnellyer.glencaldy.util.Util;

import java.util.List;
import java.util.Scanner;

public class ViewLoansOption extends Option {
    private static final String FORMAT = "| %-4s | %-30s | %-11s | %-11s | %-11s | %-11s |%n";
    private static final String[] HEADER = new String[]{"ID", "Name", "Loan Date", "Return Date", "Overdue", "Fine"};

    private final Member member;

    public ViewLoansOption(Member member) {
        super("View Loans");
        this.member = member;
    }

    @Override
    public void start(Scanner scanner) {
        List<Loan> loans = member.getLoans();

        if (loans.size() > 0) {
            System.out.printf(FORMAT, (Object[]) HEADER);

            for (Loan loan : loans) {
                Item item = loan.getItem();
                int id = item.getId();
                String name = item.getName();

                String loanDate = Constants.DATE_FORMATTER.format(loan.getLoanDate());
                String returnDate = Constants.DATE_FORMATTER.format(loan.getReturnByDate());

                String overdue = "N/A";
                String fine = "N/A";
                long daysSince = Util.daysSince(loan.getReturnByDate());

                if (daysSince > 0) {
                    overdue = daysSince + " days";
                    fine = Util.formatCurrency(daysSince * Constants.LATE_FINE_PER_DAY);
                }

                System.out.printf(FORMAT, id, name, loanDate, returnDate, overdue, fine);
            }
        } else {
            System.out.println("No outstanding loans.");
        }
    }
}
