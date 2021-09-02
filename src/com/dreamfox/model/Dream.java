package com.dreamfox.model;

import java.time.LocalDateTime;

public class Dream implements Comparable<Dream> {
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private HashSet<Tag> tags;

    public Dream(String title, String content, HashSet<Tag> tags) {
        this.title = title;
        this.content = content;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = null;
        this.tags = tags;
    }

    public void addTag(Tag tag) {
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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    public void setTags(HashSet<Tag> tags) {
        this.tags = tags;
    }
}
