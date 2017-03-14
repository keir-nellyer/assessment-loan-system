package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public class Disc extends Media {
    private String type;
    private int tracks;
    private String artist;

    public Disc(int id, String title, String publisher, float cost, int runningTime, String caseType, String type, int tracks, String artist) {
        super(id, title, publisher, cost, runningTime, caseType);
        this.type = type;
        this.tracks = tracks;
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStockType() {
        return "Disc";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disc)) return false;
        if (!super.equals(o)) return false;
        Disc disc = (Disc) o;
        return tracks == disc.tracks &&
                Objects.equals(type, disc.type) &&
                Objects.equals(artist, disc.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, tracks, artist);
    }

    @Override
    public String toString() {
        return "Disc{" +
                "type='" + type + '\'' +
                ", tracks=" + tracks +
                ", artist='" + artist + '\'' +
                "} " + super.toString();
    }
}
