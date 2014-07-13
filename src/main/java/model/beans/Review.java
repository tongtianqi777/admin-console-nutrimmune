package model.beans;

import java.sql.Timestamp;

public class Review {

    private int id;

    //Rating: the rating is in a 5 point scale. For example: 4 / 5
    private int rating;

    //Comment: a comment is a piece of string
    private String comment;

    //Protocol: the protocol that this review belongs to
    private Protocol protocol;

    //Author: the author of the review
    private Researcher author;

    //Date: the date on which the review is created
    private Timestamp date;

    public Review() {}

    public Review(int id, int rating, String comment, Protocol protocol, Researcher author, Timestamp date) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.protocol = protocol;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Researcher getAuthor() {
        return author;
    }

    public void setAuthor(Researcher author) {
        this.author = author;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
