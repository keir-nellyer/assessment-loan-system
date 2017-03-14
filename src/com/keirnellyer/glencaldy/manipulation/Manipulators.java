package com.keirnellyer.glencaldy.manipulation;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.stock.BookProperties;
import com.keirnellyer.glencaldy.manipulation.stock.DiscProperties;
import com.keirnellyer.glencaldy.manipulation.stock.JournalProperties;
import com.keirnellyer.glencaldy.manipulation.stock.VideoProperties;
import com.keirnellyer.glencaldy.manipulation.user.CasualProperties;
import com.keirnellyer.glencaldy.manipulation.user.StaffProperties;
import com.keirnellyer.glencaldy.user.*;

public class Manipulators {
    public static final CasualProperties CASUAL_MANAGER = new CasualProperties();
    public static final StaffProperties STAFF_MANAGER = new StaffProperties();

    public static final Manipulator<Member> MEMBER_MANIPULATOR =
            new SimpleManipulator<>(CASUAL_MANAGER::createFullMember, CASUAL_MANAGER::updateCasual);
    public static final Manipulator<Casual> CASUAL_MANIPULATOR =
            new SimpleManipulator<>(CASUAL_MANAGER::createCasual, CASUAL_MANAGER::updateCasual);
    public static final Manipulator<Administrative> ADMINISTRATIVE_MANIPULATOR =
            new SimpleManipulator<>(STAFF_MANAGER::createAdministrative, STAFF_MANAGER::updateStaff);
    public static final Manipulator<Staff> STAFF_MANIPULATOR =
            new SimpleManipulator<>(STAFF_MANAGER::createStaff, STAFF_MANAGER::updateStaff);

    public static final BookProperties BOOK_MANAGER = new BookProperties();
    public static final JournalProperties JOURNAL_MANAGER = new JournalProperties();
    public static final DiscProperties DISC_MANAGER = new DiscProperties();
    public static final VideoProperties VIDEO_MANAGER = new VideoProperties();

    public static final Manipulator<Book> BOOK_MANIPULATOR =
            new SimpleManipulator<>(BOOK_MANAGER::createBook, BOOK_MANAGER::updateBook);
    public static final Manipulator<Journal> JOURNAL_MANIPULATOR =
            new SimpleManipulator<>(JOURNAL_MANAGER::createJournal, JOURNAL_MANAGER::updateJournal);
    public static final Manipulator<Disc> DISC_MANIPULATOR =
            new SimpleManipulator<>(DISC_MANAGER::createCompactDisc, DISC_MANAGER::updateCompactDisc);
    public static final Manipulator<Video> VIDEO_MANIPULATOR =
            new SimpleManipulator<>(VIDEO_MANAGER::createVideo, VIDEO_MANAGER::updateVideo);

    public static PropertyManager getUserPropertyManager(Class<? extends User> clazz) {
        PropertyManager propertyManager;

        if (Administrative.class.equals(clazz)) {
            propertyManager = STAFF_MANAGER;
        } else if (Staff.class.equals(clazz)) {
            propertyManager = STAFF_MANAGER;
        } else if (Member.class.equals(clazz)) {
            propertyManager = CASUAL_MANAGER;
        } else if (Casual.class.equals(clazz)) {
            propertyManager = CASUAL_MANAGER;
        } else {
            throw new IllegalStateException("No property manager for type: " + clazz.getName());
        }

        return propertyManager;
    }

    public static <T extends User> Manipulator<T> getUserManipulator(Class<? extends T> clazz) {
        Manipulator<? extends User> manipulator;

        if (Administrative.class.isAssignableFrom(clazz)) {
            manipulator = ADMINISTRATIVE_MANIPULATOR;
        } else if (Staff.class.isAssignableFrom(clazz)) {
            manipulator = STAFF_MANIPULATOR;
        } else if (Member.class.isAssignableFrom(clazz)) {
            manipulator = MEMBER_MANIPULATOR;
        } else if (Casual.class.isAssignableFrom(clazz)) {
            manipulator = CASUAL_MANIPULATOR;
        } else {
            throw new IllegalStateException("No manipulator for type: " + clazz.getName());
        }

        return (Manipulator<T>) manipulator;
    }

    private Manipulators() {}
}
