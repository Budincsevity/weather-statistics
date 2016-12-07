package io.github.budincsevity.services;

import com.google.gson.JsonObject;
import io.github.budincsevity.utils.DateUtils;
import io.github.budincsevity.utils.FileUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Month;
import java.util.List;
import java.util.stream.IntStream;

import static io.github.budincsevity.utils.Constants.*;

public class TimeMachineExecutor {

    private final List<Month> months = DateUtils.months();
    private DarkSkyService service;

    public TimeMachineExecutor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DARKSKY_API + SECRET_KEY + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(DarkSkyService.class);
    }

    public void run() {
        IntStream.rangeClosed(1, 31)
                .forEach(dayOfTheMonth ->
                        months.forEach(month -> callDarkSkyServiceOn(month, dayOfTheMonth)));
    }

    private void callDarkSkyServiceOn(Month month, int dayOfTheMonth) {
        long epoch = DateUtils.getEpochOf(2016, month, dayOfTheMonth);

        Call<JsonObject> timeMachineResponseCall = service.getWeather(LATITUDE, LONGITUDE, epoch);
        timeMachineResponseCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                FileUtils.writeResponseToJson(response.body().toString(), month, dayOfTheMonth);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                System.out.print(throwable.getCause().toString());
            }
        });
    }
}
