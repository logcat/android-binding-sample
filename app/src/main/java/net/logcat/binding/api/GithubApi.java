package net.logcat.binding.api;

import net.logcat.binding.api.models.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GithubApi {

    @GET("/users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);

}
