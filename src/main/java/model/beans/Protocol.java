package model.beans;

import java.util.Date;

/**
 * Author: shim.
 * Creation date: 5/30/14.
 */


public class Protocol {

    private int id;
    private ProtocolStatus status;
    private int userId;
    private String steps;
    private int timePlayed;
    private String description;
    private String name;
    private String location;
    private float averageRating;
    private Date lastModifiedDate;
    private Date createDate;
    private String authorName;



    public Protocol() {
    }

    public Protocol(int id, ProtocolStatus status, int userId, String steps, int timePlayed, String description,
                    String name, String location, int averageRating, Date lastModifiedDate, Date createDate,
                    String authorName) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.steps = steps;
        this.timePlayed = timePlayed;
        this.description = description;
        this.name = name;
        this.location = location;
        this.averageRating = averageRating;
        this.lastModifiedDate = lastModifiedDate;
        this.createDate = createDate;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProtocolStatus getStatus() {
        return status;
    }

    public void setStatus(ProtocolStatus status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
