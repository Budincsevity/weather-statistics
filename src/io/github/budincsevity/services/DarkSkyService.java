package io.github.budincsevity.services;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface DarkSkyService {
    @GET("{latitude}, {longitude}, {time}?exclude=currently, flags")
    Call<JsonObject> getWeather(@Path("latitude") double latitude,
                                @Path("longitude") double longitude,
                                @Path("time") long time);
}
