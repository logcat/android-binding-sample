package net.logcat.binding;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import net.logcat.binding.api.GithubApi;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class BindingApp extends Application {

    private static GithubApi githubApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        final String endpoint = "https://api.github.com";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(gson))
                .build();
        githubApi = restAdapter.create(GithubApi.class);
    }

    public static GithubApi githubApi() {
        return githubApi;
    }

}
