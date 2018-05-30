package com.bartek.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.NumericField;

import javax.persistence.*;
import java.util.Set;

@Entity
@Indexed
public class App {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000)
    @Field
    private String name;

    @Column(length = 1000)
    @Field
    private String description;

    @Column(length = 1000)
    private String image;

    @Column
    @Field
    @NumericField(forField = "price")
    private float price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @IndexedEmbedded(depth = 1)
    private Set<Device> supportedDevices;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @IndexedEmbedded(depth = 1, includePaths = {"comments"})
    private Set<CustomerReview> customerReviews;

    @Column
    private boolean active;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Device> getSupportedDevices() {
        return supportedDevices;
    }

    public void setSupportedDevices(Set<Device> supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    public App() {

    }

    public App(String name, String image, String description) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<CustomerReview> getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(Set<CustomerReview> customerReviews) {
        this.customerReviews = customerReviews;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
