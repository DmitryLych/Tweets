package com.company.parsers;

import com.company.interfaces.IParse;
import com.company.stringClasses.Coordinates;
import com.company.stringClasses.Tweet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * parsing tweets file
 */
public class ParseTweet implements IParse<List<Tweet>> {
    /**
     *
     * @param str Line from tweets file
     * @return tweets list
     */
    @Override
    public List<Tweet> parse(String str) {
        List<Tweet> tweets = new ArrayList<>();
        String[] array = str.split("\n");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i = 0; i < array.length; i++) {
            Tweet tweet = new Tweet();
            String[] array1 = array[i].split("\t");
            String[] array2 = array1[0].split(",");
            if (array2.length == 2 && array1.length == 4) {
                array2[1] = array2[1].replace("]","");
                //array2[1]=array2[1].replace(" ","");
                array2[0]=array2[0].replace("[","");

                Coordinates coordinates = new Coordinates();
                coordinates.setLongitude(array2[1]);
                coordinates.setLatitude(array2[0]);

                tweet.setCoordinates(coordinates);

                try {
                    tweet.setDate(format.parse(array1[2]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tweet.setTweet(array1[3]);
                tweets.add(tweet);
            }
        }


        return tweets;
    }
}
