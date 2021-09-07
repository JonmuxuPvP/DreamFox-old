package com.dreamfox.model;

public class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tag)) {
            return false;
        } else {
            Tag anotherTag = (Tag) obj;
            return this.name.equals(anotherTag.name);
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.isEmpty() ? this.name : name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
