package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

public class VideoProperties extends MediaProperties {
    private final StringProperty formatProperty = new StringProperty("Please enter the video format.");
    private final StringProperty genreProperty = new StringProperty("Please enter the genre.");

    public VideoProperties() {
        super();

        addProperty(formatProperty);
        addProperty(genreProperty);
    }

    public StringProperty getFormatProperty() {
        return formatProperty;
    }

    public StringProperty getGenreProperty() {
        return genreProperty;
    }

    public Video createVideo(InputResult result) {
        Integer id = result.getValue(getIdProperty());
        String title = result.getValue(getTitleProperty());
        String publisher = result.getValue(getPublisherProperty());
        Float cost = result.getValue(getCostProperty());
        Integer runningTime = result.getValue(getRunningTimeProperty());
        String caseType = result.getValue(getCaseTypeProperty());
        String format = result.getValue(getFormatProperty());
        String genre = result.getValue(getGenreProperty());
        return new Video(id, title, publisher, cost, runningTime, caseType, format, genre);
    }

    public void updateVideo(Video item, InputResult result) {
        super.updateMedia(item, result);

        String format = result.getValue(formatProperty);
        String genre = result.getValue(genreProperty);

        if (format != null) item.setFormat(format);
        if (genre != null) item.setGenre(genre);
    }
}
