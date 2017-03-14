package com.keirnellyer.glencaldy;

import com.keirnellyer.glencaldy.item.Item;

import java.time.LocalDate;

public class Loan {
    private final Item item;
    private final LocalDate loanDate;
    private final LocalDate returnByDate;

    public Loan(Item item, LocalDate loanDate, LocalDate returnByDate) {
        this.item = item;
        this.loanDate = loanDate;
        this.returnByDate = returnByDate;
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnByDate() {
        return returnByDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return item.equals(loan.item) && loanDate.equals(loan.loanDate) && returnByDate.equals(loan.returnByDate);
    }

    @Override
    public int hashCode() {
        int result = item.hashCode();
        result = 31 * result + loanDate.hashCode();
        result = 31 * result + returnByDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "item=" + item +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnByDate +
                '}';
    }
}
