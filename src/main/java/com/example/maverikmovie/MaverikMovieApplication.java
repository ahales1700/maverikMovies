package com.example.maverikmovie;

import com.example.maverikmovie.Domain.Movie;
import com.example.maverikmovie.client.MovieApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class MaverikMovieApplication {

  public static void main(String[] args) {
    SpringApplication.run(MaverikMovieApplication.class, args);
  }

}
