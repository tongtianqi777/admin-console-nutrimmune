package model.beans;

import java.sql.Timestamp;

public class Protocol {

    private int id;
    private Researcher author;
    private String name;
    private String status;
    private String steps;
    private Timestamp lastModified;
    private Timestamp createTime;
    private String description;
    private int timePlayed;

    public Protocol() {}

    public Protocol(int id, Researcher author, String name, String status, String steps, Timestamp lastModified, Timestamp createTime, String description) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.status = status;
        this.steps = steps;
        this.lastModified = lastModified;
        this.createTime = createTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Researcher getAuthor() {
        return author;
    }

    public void setAuthor(Researcher author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }
}
