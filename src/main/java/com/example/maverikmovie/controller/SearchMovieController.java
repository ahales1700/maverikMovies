package com.example.maverikmovie.controller;

import com.example.maverikmovie.DTO.MovieDto;
import com.example.maverikmovie.client.MovieApiClient;
import com.example.maverikmovie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/titleSearch")
public class SearchMovieController {

  private final MovieApiClient movieApiClient;
  private final MovieService movieService;

  @PostMapping
  public List<MovieDto> addMoviesByTitle(@RequestParam String title){
    List<MovieDto> movies = movieApiClient.getMoviesByTitle(title);
    List<MovieDto> addedMovies = new ArrayList<>();
    for(MovieDto movie : movies){
      MovieDto movieDetails = movieApiClient.getMovieByImdbId(movie.getImdbID());
      addedMovies.add(movieService.saveMovie(movieDetails));
    }
    return addedMovies;
  }
}
