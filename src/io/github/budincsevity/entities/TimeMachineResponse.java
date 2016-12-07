package io.github.budincsevity.entities;

import com.google.gson.annotations.SerializedName;

public class TimeMachineResponse {

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("timezone")
    public String timezone;

    @SerializedName("hourly")
    public Hourly hourly;

    @Override
    public String toString() {
        return "TimeMachineResponse{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", hourly='" + hourly + '\'' +
                '}';
    }
}
