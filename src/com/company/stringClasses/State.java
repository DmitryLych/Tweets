package com.company.stringClasses;

import org.json.simple.JSONArray;

import java.util.List;

/**
 * @author Dmitry Lych
 * Stores State
 */
public class State {
    private String word;
    private List<List<List<Coordinates>>> coordinates;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<List<List<Coordinates>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<Coordinates>>> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (word != null ? !word.equals(state.word) : state.word != null) return false;
        return coordinates != null ? coordinates.equals(state.coordinates) : state.coordinates == null;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "State{" +
                "word='" + word + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}