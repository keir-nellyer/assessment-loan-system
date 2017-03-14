package com.keirnellyer.glencaldy.user;

import com.keirnellyer.glencaldy.Loan;
import com.keirnellyer.glencaldy.item.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member extends Casual {
    private int maxQuota = 5;

    private final List<Item> reservedItems = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public Member(String username, String password, String address, String phoneNumber, LocalDate birthDate) {
        super(username, password, address, phoneNumber, birthDate);
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public int getQuota() {
        return maxQuota - (reservedItems.size() + loans.size());
    }

    public List<Item> getReservedItems() {
        return reservedItems;
    }

    public void reserveItem(Item item) {
        reservedItems.add(item);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public Loan getLoan(Item item) {
        for (Loan loan : loans) {
            if (loan.getItem() == item) {
                return loan;
            }
        }

        return null;
    }

    @Override
    public String getTitle() {
        return "Full Member";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return maxQuota == member.maxQuota &&
                Objects.equals(reservedItems, member.reservedItems) &&
                Objects.equals(loans, member.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxQuota, reservedItems, loans);
    }

    @Override
    public String toString() {
        return "Member{" +
                "maxQuota=" + maxQuota +
                ", reservedItems=" + reservedItems +
                ", loans=" + loans +
                "} " + super.toString();
    }
}
