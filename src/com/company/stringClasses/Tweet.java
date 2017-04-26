package com.company.stringClasses;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * stored tweet
 */
public class Tweet {
    private Coordinates coordinates;
    private Date date;
    private String tweet;
   private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;

        Tweet tweet1 = (Tweet) o;

        if (!coordinates.equals(tweet1.coordinates)) return false;
        if (!date.equals(tweet1.date)) return false;
        return tweet.equals(tweet1.tweet);
    }

    @Override
    public int hashCode() {
        int result = coordinates.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + tweet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Tweet{" + coordinates.toString() +
                ", date=" + format.format(date) +
                ", tweet=" + tweet + '\'' +
                '}');
    }

}




