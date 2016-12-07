package io.github.budincsevity.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hourly {

    @SerializedName("summary")
    public String summary;
    @SerializedName("data")
    public List<Data> data;

    @Override
    public String toString() {
        return "Hourly{" +
                "summary='" + summary + '\'' +
                ", data=" + data +
                '}';
    }
}
