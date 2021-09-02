package com.dreamfox.model;

import java.util.HashSet;
import java.util.TreeSet;

public class DreamManager {
    private TreeSet<Dream> dreams;

    public DreamManager() {
        dreams = new TreeSet<>();
    }

    public void addDream(Dream dream) {
        dreams.add(dream);
    }

    public void removeDream(Dream dream) {
        dreams.remove(dream);
    }

    public TreeSet<Dream> getDreams() {
        return this.dreams;
    }

    public TreeSet<Dream> getDreams(String sample) {
        TreeSet<Dream> dreamsContainingSample = new TreeSet<>();
        for (Dream dream : dreams) {
            if (dream.getTitle().contains(sample) || dream.getContent().contains(sample)) {
                dreamsContainingSample.add(dream);
            }
        }
        return dreamsContainingSample;
    }

    public TreeSet<Dream> getDreams(HashSet<Tag> tags) {
        TreeSet<Dream> dreamsContainingTags = new TreeSet<>();
        for (Dream dream : dreams) {
            for (Tag tag : dream.getTags()) {
                if (tags.contains(tag)) {
                    dreamsContainingTags.add(dream);
                }
            }
        }
        return dreamsContainingTags;
    }

    public TreeSet<Dream> getDreams(String sample, HashSet<Tag> tags) {
        TreeSet<Dream> dreamsContainingTagsAndSample = new TreeSet<>();
        for (Dream dream : dreams) {
            for (Tag tag : dream.getTags()) {
                if (tags.contains(tag)) {
                    if (dream.getTitle().contains(sample) || dream.getContent().contains(sample)) {
                        dreamsContainingTagsAndSample.add(dream);
                    }
                }
            }
        }
        return dreamsContainingTagsAndSample;
    }

    public Statistics getStatistics() {
        int words = 0, characters = 0, lucidDreams = 0, normalDreams = 0, totalDreams = 0;
        for (Dream dream : dreams) {
            words += dream.getWordCount();
            characters += dream.getCharacterCount();
            totalDreams++;
            if (dream.getTags().contains(TagManager.lucid())) {
                lucidDreams++;
            } else if (dream.getTags().contains(TagManager.normal())) {
                normalDreams++;
            }
        }
        return new Statistics(words, characters, lucidDreams, normalDreams, totalDreams);
    }

}
