package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public class Video extends Media {
    private String format;
    private String genre;

    public Video(int id, String title, String publisher, float cost, int runningTime, String caseType, String format, String genre) {
        super(id, title, publisher, cost, runningTime, caseType);
        this.format = format;
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getStockType() {
        return "Video";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;
        if (!super.equals(o)) return false;
        Video video = (Video) o;
        return Objects.equals(format, video.format) &&
                Objects.equals(genre, video.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), format, genre);
    }

    @Override
    public String toString() {
        return "Video{" +
                "format='" + format + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }
}
