package com.bartek.domain;

import com.bartek.util.IndexWhenActiveInterceptor;
import org.apache.solr.analysis.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Indexed(interceptor = IndexWhenActiveInterceptor.class)

//@AnalyzerDef definiuje powiązanie analyzera z polem description oraz dodaje filtry usuwające literówki
@AnalyzerDef(
        name = "appAnalyzer",
        charFilters = {@CharFilterDef(factory = HTMLStripCharFilterFactory.class)},
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = StandardFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class),
                @TokenFilterDef(factory = PhoneticFilterFactory.class, params = {
                        @Parameter(name = "encoder", value = "DoubleMetaphone")
                }),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "English")
                })
        }
)

//@Boost podwaja wagę wyliczania wartości wyników wyszukiwania
@Boost(2.0f)
public class App {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;


    @Column(length = 1000)
    @Fields({
            @Field, //indeksowanie z rozbitymi wartościami
            @Field(name = "sorting_name", analyze = Analyze.NO) //indeksowanie z nierozbitymi wartosciami do sortowania wyników
    })
    @Boost(1.5f) //zwieksza wagę podczas wyliczania wartosci wyników wyszukiwania
    private String name;


    //dluzszy opis
    @Column(length = 1000)
    @Field
    @Analyzer(definition = "appAnalyzer")
    @Boost(1.2f)
    private String description;

    @Column(length = 1000)
    private String image;

    @Column
    @Field
    @NumericField(forField = "price")
    private float price;

    //data wydania aplikacji @DataBridge deklarowanie indeksowania od poziomu dnia
    @Column
    @Field
    @DateBridge(resolution = Resolution.DAY)
    private Date relaseData;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @IndexedEmbedded(depth = 1)
    private Set<Device> supportedDevices;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @IndexedEmbedded(depth = 1, includePaths = {"comments", "stars"})
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
        this.active = true;
        this.relaseData = new Date();
        this.price = 0.99f;
    }

    public Date getRelaseData() {
        return relaseData;
    }

    public void setRelaseData(Date relaseData) {
        this.relaseData = relaseData;
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
