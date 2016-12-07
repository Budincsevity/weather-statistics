package io.github.budincsevity.entities;

import com.google.gson.annotations.SerializedName;
import io.github.budincsevity.utils.Converter;
import io.github.budincsevity.utils.DateUtils;

public class Data {

    @SerializedName("time")
    public long time;

    @SerializedName("summary")
    public String summary;

    @SerializedName("precipType")
    public String precipType;

    @SerializedName("temperature")
    public double temperature;

    @SerializedName("apparentTemperature")
    public double apparentTemperature;

    @SerializedName("humidity")
    public double humidity;

    @SerializedName("windSpeed")
    public double windSpeed;

    @SerializedName("windBearing")
    public double windBearing;

    @SerializedName("visibility")
    public double visibility;

    @SerializedName("loudCover")
    public double loudCover;

    @SerializedName("pressure")
    public double pressure;

    @Override
    public String toString() {
        return "Data{" +
                "time=" + DateUtils.formatDate(time) +
                ", summary='" + summary + '\'' +
                ", precipType='" + precipType + '\'' +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windBearing=" + windBearing +
                ", visibility=" + visibility +
                ", loudCover=" + loudCover +
                ", pressure=" + pressure +
                '}';
    }

    public String asCommaSeparatedString() {
        String formattedDate = DateUtils.formatDate(time);

        return formattedDate +
                "," + summary +
                "," + precipType +
                "," + Converter.fromFahrenheitToCelsius(temperature) +
                "," + Converter.fromFahrenheitToCelsius(apparentTemperature) +
                "," + humidity +
                "," + Converter.fromMilesToKm(windSpeed) +
                "," + windBearing +
                "," + Converter.fromMilesToKm(visibility) +
                "," + loudCover +
                "," + pressure;
    }

    public static String getFieldNamesCSVString() {
        return "Formatted Date," +
                "Summary," +
                "Precip Type," +
                "Temperature (C)," +
                "Apparent Temperature (C)," +
                "Humidity," +
                "Wind Speed (km/h)," +
                "Wind Bearing (degrees)," +
                "Visibility (km)," +
                "Loud Cover," +
                "Pressure (millibars)," +
                "Daily Summary";
    }
}
