package com.company.parsers;
import com.company.interfaces.IParse;
import com.company.stringClasses.Sentiment;

import java.util.ArrayList;
import java.util.List;

/**
 * Parsing sentiments file
 */
public class ParseSentiment implements IParse<List<Sentiment>> {
    /**
     *
     * @param str Line from sentiments file
     * @return sentiments list
     */
    @Override
    public List<Sentiment> parse(String str) {
        List<Sentiment> sentiments = new ArrayList<>();
        String[] array = str.split("\n");
        for (int i = 0; i < array.length; i++) {
            String[] array1 = array[i].split(",");
            Sentiment sentiment = new Sentiment();
            sentiment.setPhrase(array1[0]);
            double value = Double.parseDouble(array1[1]);
            sentiment.setMark(value);
            sentiments.add(sentiment);
        }
        return sentiments;
    }
}
