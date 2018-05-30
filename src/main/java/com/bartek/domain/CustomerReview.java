package com.bartek.domain;

import org.hibernate.search.annotations.Field;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerReview {

    @Field
    private String username;

    private int stars;

    @Field
    private String comments;

    public CustomerReview(){

    }

    public CustomerReview(String username, int stars, String comments) {
        this.username = username;
        this.stars = stars;
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
