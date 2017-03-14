package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.*;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.util.Constants;
import com.keirnellyer.glencaldy.util.Util;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListStockOption extends Option {

    private static final String BASE_FORMAT = "| %-8s | %-15s | %-30s | %-20s | %-8s ";
    private static final String[] BASE_HEADER = new String[]{"ID", "Stock Type", "Title", "Publisher", "Cost"};

    private static final String PAPER_FORMAT = "| %-20s | %-5s ";
    private static final String[] PAPER_HEADER = new String[]{"Subject", "Pages"};

    private static final String MEDIA_FORMAT = "| %-12s | %-9s ";
    private static final String[] MEDIA_HEADER = new String[]{"Running Time", "Case Type"};


    private static final String BOOK_FORMAT = "| %-20s | %-9s |";
    private static final String[] BOOK_HEADER = new String[]{"Author", "ISBN"};

    private static final String JOURNAL_FORMAT = "| %-9s | %-10s | %-9s |";
    private static final String[] JOURNAL_HEADER = new String[]{"Issue No.", "Issue Date", "ISSN"};

    private static final String DISC_FORMAT = "| %-11s | %-6s | %-15s |";
    private static final String[] DISC_HEADER = new String[]{"Type", "Tracks", "Artist"};

    private static final String VIDEO_FORMAT = "| %-6s | %-10s |";
    private static final String[] VIDEO_HEADER = new String[]{"Format", "Genre"};

    private final StockRepository repository;

    public ListStockOption(StockRepository repository) {
        super("List Stock");
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        printHeader("BOOKS");
        listBooks();

        printHeader("JOURNALS");
        listJournals();

        printHeader("DISCS");
        listDiscs();

        printHeader("VIDEOS");
        listVideos();
    }

    private void printHeader(String header){
        System.out.printf("\n****** %s ******\n", header);
    }

    private void listBooks() {
        List<Book> books = repository.getAll().stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .collect(Collectors.toList());

        // combine all formats
        String format = BASE_FORMAT + PAPER_FORMAT + BOOK_FORMAT + "%n";

        // combine all header titles
        String[][] headerTitles = new String[][]{BASE_HEADER, PAPER_HEADER, BOOK_HEADER};
        String[] header = Util.combineArrays(new String[Util.getTotalLength(headerTitles)], headerTitles);

        // print header
        System.out.printf(format, (Object[]) header);

        // print rows
        for (Book book : books) {
            String[] itemData = toItemDataArray(book);
            String[] paperData = toPaperDataArray(book);
            String[] bookData = toBookDataArray(book);

            String[][] dataArrays = new String[][]{itemData, paperData, bookData};
            String[] rowData = Util.combineArrays(new String[Util.getTotalLength(dataArrays)], dataArrays);
            System.out.printf(format, (Object[]) rowData);
        }
    }

    private void listJournals() {
        List<Journal> journals = repository.getAll().stream()
                .filter(item -> item instanceof Journal)
                .map(item -> (Journal) item)
                .collect(Collectors.toList());

        // combine all formats
        String format = BASE_FORMAT + PAPER_FORMAT + JOURNAL_FORMAT + "%n";

        // combine all header titles
        String[][] headerTitles = new String[][]{BASE_HEADER, PAPER_HEADER, JOURNAL_HEADER};
        String[] header = Util.combineArrays(new String[Util.getTotalLength(headerTitles)], headerTitles);

        // print header
        System.out.printf(format, (Object[]) header);

        // print rows
        for (Journal journal : journals) {
            String[] itemData = toItemDataArray(journal);
            String[] paperData = toPaperDataArray(journal);
            String[] journalData = toJournalDataArray(journal);

            String[][] dataArrays = new String[][]{itemData, paperData, journalData};
            String[] rowData = Util.combineArrays(new String[Util.getTotalLength(dataArrays)], dataArrays);
            System.out.printf(format, (Object[]) rowData);
        }
    }

    private void listDiscs() {
        List<Disc> discs = repository.getAll().stream()
                .filter(item -> item instanceof Disc)
                .map(item -> (Disc) item)
                .collect(Collectors.toList());

        // combine all formats
        String format = BASE_FORMAT + MEDIA_FORMAT + DISC_FORMAT + "%n";

        // combine all header titles
        String[][] headerTitles = new String[][]{BASE_HEADER, MEDIA_HEADER, DISC_HEADER};
        String[] header = Util.combineArrays(new String[Util.getTotalLength(headerTitles)], headerTitles);

        // print header
        System.out.printf(format, (Object[]) header);

        // print rows
        for (Disc disc : discs) {
            String[] itemData = toItemDataArray(disc);
            String[] mediaData = toMediaDataArray(disc);
            String[] discData = toDiscDataArray(disc);

            String[][] dataArrays = new String[][]{itemData, mediaData, discData};
            String[] rowData = Util.combineArrays(new String[Util.getTotalLength(dataArrays)], dataArrays);
            System.out.printf(format, (Object[]) rowData);
        }
    }

    private void listVideos() {
        List<Video> videos = repository.getAll().stream()
                .filter(item -> item instanceof Video)
                .map(item -> (Video) item)
                .collect(Collectors.toList());

        // combine all formats
        String format = BASE_FORMAT + MEDIA_FORMAT + VIDEO_FORMAT + "%n";

        // combine all header titles
        String[][] headerTitles = new String[][]{BASE_HEADER, MEDIA_HEADER, VIDEO_HEADER};
        String[] header = Util.combineArrays(new String[Util.getTotalLength(headerTitles)], headerTitles);

        // print header
        System.out.printf(format, (Object[]) header);

        // print rows
        for (Video video : videos) {
            String[] itemData = toItemDataArray(video);
            String[] mediaData = toMediaDataArray(video);
            String[] videoData = toVideoDataArray(video);

            String[][] dataArrays = new String[][]{itemData, mediaData, videoData};
            String[] rowData = Util.combineArrays(new String[Util.getTotalLength(dataArrays)], dataArrays);
            System.out.printf(format, (Object[]) rowData);
        }
    }

    private String[] toVideoDataArray(Video video) {
        String[] videoData = new String[2];
        videoData[0] = video.getFormat();
        videoData[1] = video.getGenre();
        return videoData;
    }

    private String[] toDiscDataArray(Disc disc) {
        String[] discData = new String[3];
        discData[0] = disc.getType();
        discData[1] = String.valueOf(disc.getTracks());
        discData[2] = disc.getArtist();
        return discData;
    }

    private String[] toMediaDataArray(Media media) {
        String[] mediaData = new String[2];
        mediaData[0] = String.valueOf(media.getRunningTime());
        mediaData[1] = media.getCaseType();
        return mediaData;
    }

    private String[] toJournalDataArray(Journal journal) {
        String[] journalData = new String[3];
        journalData[0] = String.valueOf(journal.getIssueNumber());
        journalData[1] = Constants.DATE_FORMATTER.format(journal.getIssueDate());
        journalData[2] = journal.getIssn();
        return journalData;
    }

    private String[] toBookDataArray(Book book) {
        String[] bookData = new String[2];
        bookData[0] = book.getAuthor();
        bookData[1] = book.getIsbn();
        return bookData;
    }

    private String[] toPaperDataArray(Paper paper) {
        String[] paperData = new String[2];
        paperData[0] = paper.getSubjectArea();
        paperData[1] = String.valueOf(paper.getPages());
        return paperData;
    }

    private String[] toItemDataArray(Item item) {
        String[] itemData = new String[5];
        itemData[0] = String.valueOf(item.getId());
        itemData[1] = item.getStockType();
        itemData[2] = item.getName();
        itemData[3] = item.getPublisher();
        itemData[4] = String.valueOf(item.getCost());
        return itemData;
    }
}
