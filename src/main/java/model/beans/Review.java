package model.beans;

import java.util.Calendar;

/**
 * Created by Tianqi Tong on 6/9/14.
 */
public class Review {

    //Rating: the rating is in a 5 point scale. For example: 4.5 / 5
    private int rating;

    //Comment: a comment is a piece of string
    private String comment;

    //ID: the id of the review, which is generated using the current system time in millisecond
    private String id;

    //Protocol ID: the protocol that this review belongs to
    private int protocolId;

    //Author: the author of the review
    private int author;

    //Date: the date on which the review is created
    private Calendar date;

    public Review() {
        date = Calendar.getInstance();
    }

    public Review(int protocolId, String comment, int rating, int author) {
        this();            //get the date and the id
        this.protocolId = protocolId;
        this.rating = rating;
        this.comment = comment;
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getAuthor() {
        return author;
    }

    public void setBy(int author) {
        this.author = author;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
