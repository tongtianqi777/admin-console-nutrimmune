package model.beans.csv;

import model.beans.Protocol;

public class ProtocolCSV {

    private int id;
    private int authorId;
    private String name;
    private String status;
    private String steps;
    private String lastModified;
    private String createTime;
    private String description;
    private int timePlayed;

    public ProtocolCSV() {
    }

    public ProtocolCSV (Protocol protocol) {
        this.id = protocol.getId();
        this.authorId = protocol.getAuthor().getId();
        this.name = protocol.getName();
        this.status = protocol.getStatus();
        this.steps = protocol.getSteps();
        this.lastModified = protocol.getLastModified().toString();
        this.createTime = protocol.getCreateTime().toString();
        this.description = protocol.getDescription();
        this.timePlayed = protocol.getTimePlayed();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
