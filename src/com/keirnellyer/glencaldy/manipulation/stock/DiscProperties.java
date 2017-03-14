package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

public class DiscProperties extends MediaProperties {
    private final StringProperty typeProperty = new StringProperty("Please enter CD type.");
    private final IntegerProperty tracksProperty = new IntegerProperty("Please enter number of tracks.");
    private final StringProperty artistProperty = new StringProperty("Please enter the artist.");

    public DiscProperties() {
        super();

        addProperty(typeProperty);
        addProperty(tracksProperty);
        addProperty(artistProperty);
    }

    public StringProperty getTypeProperty() {
        return typeProperty;
    }

    public IntegerProperty getTracksProperty() {
        return tracksProperty;
    }

    public StringProperty getArtistProperty() {
        return artistProperty;
    }

    public Disc createCompactDisc(InputResult result) {
        Integer id = result.getValue(getIdProperty());
        String title = result.getValue(getTitleProperty());
        String publisher = result.getValue(getPublisherProperty());
        Float cost = result.getValue(getCostProperty());
        Integer runningTime = result.getValue(getRunningTimeProperty());
        String caseType = result.getValue(getCaseTypeProperty());
        String type = result.getValue(getTypeProperty());
        Integer tracks = result.getValue(getTracksProperty());
        String artist = result.getValue(getArtistProperty());
        return new Disc(id, title, publisher, cost, runningTime, caseType, type, tracks, artist);
    }

    public void updateCompactDisc(Disc item, InputResult result) {
        super.updateMedia(item, result);

        String type = result.getValue(typeProperty);
        Integer tracks = result.getValue(tracksProperty);
        String artist = result.getValue(artistProperty);

        if (type != null) item.setType(type);
        if (tracks != null) item.setTracks(tracks);
        if (artist != null) item.setArtist(artist);
    }
}
