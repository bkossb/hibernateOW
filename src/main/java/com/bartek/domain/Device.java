package com.bartek.domain;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Field
    private String manufacturer;

    @Column
    @Field
    private String name;

    @ManyToMany(mappedBy = "supportedDevices", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @ContainedIn
    private Set<App> supportedApps;

    public Device() {
    }

    public Device(String manufacturer, String name, Set<App> supportedApps) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.supportedApps = supportedApps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<App> getSupportedApps() {
        return supportedApps;
    }

    public void setSupportedApps(Set<App> supportedApps) {
        this.supportedApps = supportedApps;
    }
}
