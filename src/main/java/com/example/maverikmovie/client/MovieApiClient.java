package com.example.maverikmovie.client;

import com.example.maverikmovie.DTO.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class MovieApiClient {
  private final RestTemplate restTemplate;
  private final String baseUrl = "https://gateway.maverik.com/movie/api/movie/";

  @Autowired
  public MovieApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  public List<MovieDto> getMoviesByTitle(String title) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    ResponseEntity<List<MovieDto>> response = restTemplate.exchange(
        baseUrl + "title/" + title + "?source=web",
        HttpMethod.GET,
        entity,
        new ParameterizedTypeReference<>() {
        }
    );

    return response.getBody();
  }

  public MovieDto getMovieByImdbId(String imdbId) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    ResponseEntity<MovieDto> response = restTemplate.exchange(
        baseUrl + imdbId + "?source=web",
        HttpMethod.GET,
        entity,
        MovieDto.class
    );

    return response.getBody();
  }
}
