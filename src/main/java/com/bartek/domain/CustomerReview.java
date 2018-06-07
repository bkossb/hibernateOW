package com.bartek.domain;

import com.bartek.util.FiveStarBoostStrategy;
import org.apache.solr.analysis.HTMLStripCharFilterFactory;
import org.apache.solr.analysis.StandardFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.apache.solr.analysis.StopFilterFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.Embeddable;

@Embeddable
@AnalyzerDef(
        name = "customerReviewAnalyzer",
        charFilters = {@CharFilterDef(factory = HTMLStripCharFilterFactory.class)},
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = StandardFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class)
        }
)
@DynamicBoost(impl = FiveStarBoostStrategy.class)
public class CustomerReview {

    @Field
    private String username;

    @Field
    @NumericField
    private int stars;

    @Field
    @Analyzer(definition = "customerReviewAnalyzer")
    private String comments;

    public CustomerReview() {

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
