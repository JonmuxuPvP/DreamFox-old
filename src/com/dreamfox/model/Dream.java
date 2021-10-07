package com.dreamfox.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Dream implements Comparable<Dream> {
    private final String NO_TITLE = "No Title";
    private final String EMPTY = "Empty";
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private HashSet<Tag> tags;

    public Dream(String title, String content, HashSet<Tag> tags) {
        this.title = title.split("\\s+")[0].isEmpty() ? NO_TITLE : title;
        this.content = content.split("\\s+")[0].isEmpty() ? EMPTY : content;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = null;
        this.tags = tags == null ? new HashSet<>() : tags;
        checkTags();
    }

    private void checkTags() {
        if (tags.isEmpty()) {
            tags.add(TagManager.undefined());
        }
    }

    public void addTag(Tag tag) {
        tags.remove(TagManager.undefined());
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    public int getCharacterCount() {
        return content.length();
    }

    public int getWordCount() {
        return content.split("\\s+").length;
    }

    @Override
    public int compareTo(Dream anotherDream) {
        return creationDate.compareTo(anotherDream.creationDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!this.title.equals(title)) {
            this.title = title.isEmpty() ? NO_TITLE : title;
            this.modificationDate = LocalDateTime.now();
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (!this.content.equals(content)) {
            this.content = content.isEmpty() ? EMPTY : content;
            this.modificationDate = LocalDateTime.now();
        }
    }

    public String getCreationDate() {
        return this.creationDate.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }

    public String getModificationDate() {
        return this.modificationDate.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return title + " | " + tags;
    }
}
