package com.jorgegalvan.testkairos.clients;

import com.jorgegalvan.testkairos.models.TvMazeResultado;
import com.jorgegalvan.testkairos.models.TvMazeShow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tvmazeClient", url = "https://api.tvmaze.com")
public interface TvMazeClient {

    @GetMapping("/search/shows")
    List<TvMazeResultado> searchShows(@RequestParam("q") String searchQuery);

    @GetMapping("/shows/{showId}")
    TvMazeShow buscarPorId(@PathVariable Long showId);

}
