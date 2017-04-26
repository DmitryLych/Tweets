package com.company.stringClasses;

/**
 * Stores coordinates
 */
public class Coordinates {
    private String longitude;
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.format("Coordinates{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}');
    }
}
