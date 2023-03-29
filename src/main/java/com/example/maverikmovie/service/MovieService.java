package com.example.maverikmovie.service;

import com.example.maverikmovie.DTO.MovieDto;
import org.springframework.stereotype.Service;


public interface MovieService {

  MovieDto saveMovie(MovieDto movieDto);
}
