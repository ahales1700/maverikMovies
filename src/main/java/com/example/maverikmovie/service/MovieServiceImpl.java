package com.example.maverikmovie.service;

import com.example.maverikmovie.DTO.MovieDto;
import com.example.maverikmovie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

  @Override
  public MovieDto saveMovie(MovieDto movieDto) {
    return movieRepository.save(movieDto.toMovie()).toDto();
  }
}
