package io.github.budincsevity.utils;

public class Converter {
    public static double fromFahrenheitToCelsius(double temperature) {
        return ((temperature - 32) * 5) / 9;
    }

    public static double fromMilesToKm(double miles) {
        return miles * 1.61;
    }
}
