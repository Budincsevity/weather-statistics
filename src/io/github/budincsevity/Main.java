package io.github.budincsevity;

import io.github.budincsevity.services.WeatherMapperToCsv;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //new TimeMachineExecutor().run();

        try {
            new WeatherMapperToCsv().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
