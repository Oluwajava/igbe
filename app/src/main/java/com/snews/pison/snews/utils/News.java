package com.snews.pison.snews.utils;

/**
 * Created by Olusegun Olaosebikan on 10/31/2016.
 */

public class News {
    private final String thumbnailId;
    private final String sourceId;
    private final String title;
    private final String content;
    private final String source;
    private final String time;

    public String getThumbnailId() {
        return thumbnailId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSource() {
        return source;
    }

    public String getTime() {
        return time;
    }

    public static class Builder {
//        Require parameters
        private final String thumbnailId;
        private final String title;

//        Optional parameters
        private String sourceId = null;
        private String content = null;
        private String source = null;
        private String time = null;

        public Builder(String thumbnailId, String title) {
            this.thumbnailId = thumbnailId;
            this.title = title;
        }

        public Builder sourceId(String val) {
            sourceId = val;         return this;
        }

        public Builder content(String val) {
            content = val;         return this;
        }

        public Builder source(String val) {
            source = val;         return this;
        }

        public Builder time(String val) {
            time = val;         return this;
        }

        public News build() {
            return new News(this);
        }
    }

    private News(Builder builder) {
        thumbnailId = builder.thumbnailId;
        title = builder.title;
        sourceId = builder.sourceId;
        content = builder.content;
        source = builder.source;
        time = builder.time;
    }


}
