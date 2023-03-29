package com.example.maverikmovie.repository;

import com.example.maverikmovie.DTO.MovieDto;
import com.example.maverikmovie.Domain.Movie;
import com.example.maverikmovie.client.MovieApiClient;
import com.example.maverikmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)

public class MovieInitializer implements CommandLineRunner {

  private static final String MOVIE_API_URL = "https://gateway.maverik.com/movie/api/movie/title/%s?source=web";

  private final MovieApiClient movieApiClient;
  private final MovieService movieService;

  @Autowired
  public MovieInitializer(MovieApiClient movieApiClient, MovieService movieService) {
    this.movieApiClient = movieApiClient;
    this.movieService = movieService;
  }

  @Override
  public void run(String... args) {
    String title = "The Patriot";
    List<MovieDto> movies = movieApiClient.getMoviesByTitle(title);
    for(MovieDto movie : movies){
      MovieDto movieDetails = movieApiClient.getMovieByImdbId(movie.getImdbID());
      movieService.saveMovie(movieDetails);
    }
  }
}
