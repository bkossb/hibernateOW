package com.bartek.util;

import com.bartek.domain.CustomerReview;
import org.hibernate.search.engine.BoostStrategy;

//Klasa modyfikujaca wagę obiektu dla 5 gwiazdek obekty maja zwiekszona wage


public class FiveStarBoostStrategy implements BoostStrategy {

    public float defineBoost(Object value) {
        if (value == null || !(value instanceof CustomerReview)) {
            return 1;
        }
        CustomerReview customerReview = (CustomerReview) value;

        if (customerReview.getStars() == 5) {
            return 1.5f;
        } else {
            return 1;
        }
    }
}
