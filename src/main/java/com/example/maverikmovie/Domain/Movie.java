package com.example.maverikmovie.Domain;

import com.example.maverikmovie.DTO.MovieDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String imdbID;
  private String title;
  private String yearReleased;
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

  public MovieDto toDto() {
    MovieDto movieDto = new MovieDto();
    movieDto.setId(id);
    movieDto.setImdbID(imdbID);
    movieDto.setTitle(title);
    movieDto.setYear(yearReleased);
    movieDto.setRated(rated);
    movieDto.setReleased(released);
    movieDto.setRuntime(runtime);
    movieDto.setGenre(genre);
    movieDto.setDirector(director);
    movieDto.setActors(actors);
    movieDto.setPlot(plot);
    movieDto.setLanguage(language);
    movieDto.setCountry(country);
    movieDto.setPoster(poster);
    movieDto.setImdbRating(imdbRating);
    movieDto.setOwner(owner);
    return movieDto;
  }
}
