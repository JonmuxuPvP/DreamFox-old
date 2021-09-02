package com.dreamfox.model;

import java.util.HashSet;

public class TagManager {
    private static final Tag[] IMMUTABLE_TAGS = new Tag[]{new Tag("Lucid"),
                                                          new Tag("Normal"),
                                                          new Tag("Undefined")};
    private HashSet<Tag> customTags;

    public TagManager() {
        customTags = new HashSet<>();
    }

    public void addCustomTag(Tag tag) {
        customTags.add(tag);
    }

    public void removeCustomTag(Tag tag) {
        customTags.remove(tag);
    }

    public HashSet<Tag> getCustomTags() {
        return customTags;
    }

    public static Tag lucid() {
        return IMMUTABLE_TAGS[0];
    }

    public static Tag normal() {
        return IMMUTABLE_TAGS[1];
    }

    public static Tag undefined() {
        return IMMUTABLE_TAGS[2];
    }

}
