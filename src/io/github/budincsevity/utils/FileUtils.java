package io.github.budincsevity.utils;

import com.google.common.base.Joiner;
import io.github.budincsevity.entities.Data;
import io.github.budincsevity.entities.TimeMachineResponse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Month;

public class FileUtils {

    public static void writeResponseToJson(String response, Month month, int dayOfTheMonth) {
        Path path = Paths.get(Constants.RESPONSES, month.toString() + String.valueOf(dayOfTheMonth) + Constants.JSON);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            writer.write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeResponseToCsv(TimeMachineResponse timeMachineResponse) {
        Path outputPath = Paths.get(Constants.CSV_FILENAME);
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            String summary = timeMachineResponse.hourly.summary.replaceAll(",","");

            for (Data data : timeMachineResponse.hourly.data) {
                String line = Joiner.on(",").join(data.asCommaSeparatedString(), summary);

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTheHeader() {
        Path outputPath = Paths.get(Constants.CSV_FILENAME);
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            writer.write(Data.getFieldNamesCSVString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
