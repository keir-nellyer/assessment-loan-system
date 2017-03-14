package com.keirnellyer.glencaldy.runtime;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.*;

import java.time.LocalDate;

public class Model {

    private final UserRepository userRepository = new UserRepository();
    private final StockRepository stockRepository = new StockRepository();

    private int userIdCounter = 0;
    private int itemIdCounter = 0;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public StockRepository getStockRepository() {
        return stockRepository;
    }

    public void populateUsers() {
        Administrative administrative = new Administrative("admin", "password", "200 Admin Crescent",
                "01383 757847", LocalDate.of(1977, 3, 28), userIdCounter++, "admin@glencaldy.com", "44");

        Staff staffUser1 = new Staff("rdonaldson", "asda", "154 Apple Road", "01383 748394",
                LocalDate.of(1983, 5, 12), userIdCounter++, "bearofthesea@gmail.com", "68");
        Staff staffUser2 = new Staff("mbell", "tesco", "20 Banana Road", "05869 485839",
                LocalDate.of(1933, 8, 18), userIdCounter++, "matthewbell@gmail.com", "22");
        Staff staffUser3 = new Staff("alester", "lidl", "23 Cooper Street", "04758 382075",
                LocalDate.of(1985, 3, 3), userIdCounter++, "alilester@gmail.com", "43");

        Member member1 = new Member("bcleland", "morrisons", "2 New Street", "04869 386720",
                LocalDate.of(1993, 11, 9));
        Member member2 = new Member("kday", "aldi", "134 Attenborough Lane", "04759 398224",
                LocalDate.of(1995, 5, 4));
        Member member3 = new Member("abarker", "iceland", "13 Mullen Close", "01848 840275",
                LocalDate.of(1998, 1, 16));

        Casual casual1 = new Casual("ged", "homebase", "12 Winstruther Crescent", "03847 839407",
                LocalDate.of(1987, 5, 7));
        Casual casual2 = new Casual("jsmith", "bandq", "13 Coconut Lane", "01847 857395",
                LocalDate.of(1922, 8, 4));
        Casual casual3 = new Casual("mkirkwood", "campus", "55 George Street", "01758 839578",
                LocalDate.of(1997, 7, 7));

        userRepository.add(administrative);

        userRepository.add(staffUser1);
        userRepository.add(staffUser2);
        userRepository.add(staffUser3);

        userRepository.add(member1);
        userRepository.add(member2);
        userRepository.add(member3);

        userRepository.add(casual1);
        userRepository.add(casual2);
        userRepository.add(casual3);
    }

    public void populateItems() {
        Book book1 = new Book(itemIdCounter++, "25 Tones of Red", "McPublishers", 20, "Fantasy", 750,
                "2360-8005", "Richard Donaldson");
        Book book2 = new Book(itemIdCounter++, "Diary of a Wimpy Kid", "Publisher & Sons", 10, "School", 420,
                "2360-7920", "Richard Donaldson");
        Book book3 = new Book(itemIdCounter++, "Marley & Me", "Dog Publushers", 25, "Animals", 240,
                "2384-5066", "Richard Donaldson");

        Disc disc1 = new Disc(itemIdCounter++, "The 1975", "SomePub", 5, 60, "Plastic",
                "Album", 20, "The 1975");
        Disc disc2 = new Disc(itemIdCounter++ , "Quality Car Bangers", "Spinnin", 5, 120,
                "Cardboard", "Compilation", 50, "Various");
        Disc disc3 = new Disc(itemIdCounter++, "Aperitif for Destruction", "CheeseMedia", 10,
                60, "Plastic", "Album", 10, "Richard Cheese");

        Journal journal1 = new Journal(itemIdCounter++, "National Geographic", "NatPub", 15, "Geography", 70,
                "2360-7947", 1, LocalDate.of(1977, 8, 3));
        Journal journal2 = new Journal(itemIdCounter++, "New Scientist", "ScienPub", 18, "Science", 60,
                "2360-7955", 5, LocalDate.of(1965, 3, 1));
        Journal journal3 = new Journal(itemIdCounter++, "Nature", "NatPub", 12, "Nature", 90,
                "2360-7963", 60, LocalDate.of(1970, 6, 22));

        Video video1 = new Video(itemIdCounter++, "James Bond", "Bond Productions", 30, 180, "Plastic", "DVD",
                "Action");
        Video video2 = new Video(itemIdCounter++, "Fast & Furious", "Fast Productions", 30, 180, "Plastic",
                "DVD", "Action");
        Video video3 = new Video(itemIdCounter++, "Transporter", "CarFilmz", 30, 180, "Plastic", "DVD",
                "Action");

        stockRepository.add(book1);
        stockRepository.add(book2);
        stockRepository.add(book3);

        stockRepository.add(disc1);
        stockRepository.add(disc2);
        stockRepository.add(disc3);

        stockRepository.add(journal1);
        stockRepository.add(journal2);
        stockRepository.add(journal3);

        stockRepository.add(video1);
        stockRepository.add(video2);
        stockRepository.add(video3);
    }

    @Override
    public String toString() {
        return "Model{" +
                "userRepository=" + userRepository +
                ", stockRepository=" + stockRepository +
                ", userIdCounter=" + userIdCounter +
                ", itemIdCounter=" + itemIdCounter +
                '}';
    }
}
