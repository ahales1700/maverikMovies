package com.example.maverikmovie.DTO;

import com.example.maverikmovie.Domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
  private Long id;
  private String imdbID;
  private String title;
  private String year;
  private String rated;
  private String released;
  private String runtime;
  private String genre;
  private String director;
  private String actors;
  private String plot;
  private String language;
  private String country;
  private String poster;
  private String imdbRating;
  private String owner;

  public Movie toMovie() {
    Movie movie = new Movie();
    movie.setId(this.id);
    movie.setImdbID(this.imdbID);
    movie.setTitle(this.title);
    movie.setYearReleased(this.year);
    movie.setRated(this.rated);
    movie.setReleased(this.released);
    movie.setRuntime(this.runtime);
    movie.setGenre(this.genre);
    movie.setDirector(this.director);
    movie.setActors(this.actors);
    movie.setPlot(this.plot);
    movie.setLanguage(this.language);
    movie.setCountry(this.country);
    movie.setPoster(this.poster);
    movie.setImdbRating(this.imdbRating);
    movie.setOwner(this.owner);
    return movie;
  }
}
