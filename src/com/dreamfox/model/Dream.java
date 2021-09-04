package com.dreamfox.model;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Dream implements Comparable<Dream> {
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private HashSet<Tag> tags;

    public Dream(String title, String content, HashSet<Tag> tags) {
        this.title = title.isBlank() || title.isEmpty() ? "No Title" : title;
        this.content = content.isBlank() || content.isEmpty() ? "empty" : content;
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
            this.title = title;
            this.modificationDate = LocalDateTime.now();
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (!this.content.equals(content)) {
            this.content = content;
            this.modificationDate = LocalDateTime.now();
        }
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return title + " | " + tags;
    }
}
