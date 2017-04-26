package com.company.stringClasses;

/**
 * Stores Sentiment
 */
public class Sentiment {
    private String phrase;
    private double mark;

    @Override
    public String toString() {
        return "Sentiment{" +
                "phrase='" + phrase + '\'' +
                " mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentiment)) return false;

        Sentiment sentiment = (Sentiment) o;

        if (Double.compare(sentiment.mark, mark) != 0) return false;
        return phrase.equals(sentiment.phrase);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = phrase.hashCode();
        temp = Double.doubleToLongBits(mark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
