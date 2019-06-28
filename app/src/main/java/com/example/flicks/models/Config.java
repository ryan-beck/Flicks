package com.example.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {

    String imageBaseUrl;
    String posterSize;
    String backdropSize;


    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure_base_url");
        JSONArray sizes = images.getJSONArray("poster_sizes");
        posterSize = sizes.optString(3, "w342");
        JSONArray backdropSizes = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizes.optString(1, "w780");
    }

    public String getImageUrl(String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }


    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}
