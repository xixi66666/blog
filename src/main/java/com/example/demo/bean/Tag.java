package com.example.demo.bean;

public class Tag {

    private long ID;
    private String name;
    private String description;

    public Tag(long ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
