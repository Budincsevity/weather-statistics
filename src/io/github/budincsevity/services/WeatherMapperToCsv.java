package io.github.budincsevity.services;

import com.google.gson.Gson;
import io.github.budincsevity.entities.TimeMachineResponse;
import io.github.budincsevity.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.github.budincsevity.utils.Constants.RESPONSES;

public class WeatherMapperToCsv {

    public void run() throws IOException {

        FileUtils.writeTheHeader();

        Files.find(Paths.get(RESPONSES),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(this::mapJsonToCsv);
    }

    private void mapJsonToCsv(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            TimeMachineResponse timeMachineResponse = new Gson().fromJson(reader, TimeMachineResponse.class);
            FileUtils.writeResponseToCsv(timeMachineResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
