package com.example.movie_table.service;

import com.example.movie_table.Entity.Actor;
import com.example.movie_table.Entity.Director;
import com.example.movie_table.Entity.Movie;
import com.example.movie_table.Entity.MovieActor;
import com.example.movie_table.dto.request.movie.MovieCreateRequestDto;
import com.example.movie_table.dto.request.movie.MovieUpdateRequestDto;
import com.example.movie_table.dto.response.movie.MovieCreateResponseDto;
import com.example.movie_table.dto.response.movie.MovieReadResponseDto;
import com.example.movie_table.dto.response.movie.MovieUpdateResponseDto;
import com.example.movie_table.repository.ActorRepository;
import com.example.movie_table.repository.DirectorRepository;
import com.example.movie_table.repository.GenreRepository;
import com.example.movie_table.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {


    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;


//    @Autowired
//    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, DirectorRepository directorRepository, GenreRepository genreRepository) {
//        this.movieRepository = movieRepository;
//        this.actorRepository = actorRepository;
//        this.directorRepository = directorRepository;
//        this.genreRepository = genreRepository;
//    }

//    public MovieCreateResponseDto createMovie(MovieCreateRequestDto movie) {
public MovieCreateResponseDto createMovie(MovieCreateRequestDto movieDto) {
        Movie movie = Movie.createMovie(movieDto);


        movie.setDirector(directorRepository.findByName(movieDto.getDirectorName()).orElseThrow());
        movie.setGenre(genreRepository.findByName(movieDto.getGenreName()).orElseThrow());
        for (String actorName : movieDto.getActorNameList()) {
//            movie.getActors().add( actorRepository.findByName(actorName).orElseThrow());
            MovieActor movieActor = MovieActor.createMovieActor(movie, actorRepository.findByName(actorName).orElseThrow());
        }

//        for (String directorName : movieDto.getDirectorNameList()) {
//            movie.getDirectors().add( directorRepository.findByName(directorName).orElseThrow());
//        }

//        for (String genreName : movieDto.getGenreNameList()) {
//            movie.getGenres().add(genreRepository.findByName(genreName).orElseThrow());
//        }

        Movie savedMovie = movieRepository.save(movie);
        return new MovieCreateResponseDto(savedMovie.getId(), savedMovie.getTitle(), savedMovie.getReleaseDate(), savedMovie.getAverageRating());
//        Movie savedMovie = movieRepository.save(Movie.createMovie(movie));
//        return new MovieCreateResponseDto(savedMovie.getId(), savedMovie.getTitle(), savedMovie.getReleaseDate(), savedMovie.getAverageRating());
    }

    public List<MovieReadResponseDto> getAllMovies() {
        List<MovieReadResponseDto> dto = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        for (Movie m : movies) {
            dto.add(new MovieReadResponseDto(m.getId(), m.getTitle(), m.getDirector(), m.getGenre(), m.getActors(), m.getReleaseDate(), m.getAverageRating()));
        }
        return dto;
//        return movieRepository.findAll();
    }

    public MovieReadResponseDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return new MovieReadResponseDto(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getActors(), movie.getReleaseDate(), movie.getAverageRating());
//        return movieRepository.findById(id);
    }

    public MovieUpdateResponseDto updateMovieById(Long id, MovieUpdateRequestDto movieDto) {

        Optional<Movie> movieOptional = movieRepository.findById(movieDto.getId());
        Movie movie = Movie.createMovie(movieDto);
        if (movieOptional.isPresent()) {
            movie.setId(movieDto.getId());
            movieRepository.save(movie);
        }
        return movie.toDto();
    }

//    public MovieUpdateResponseDto updateMovieById(Long id, Movie movie) {
//        Optional<Movie> movieOptional = movieRepository.findById(id);
//        if (movieOptional.isPresent()) {
//            movie.setId(id);
//            movieRepository.save(movie);
//        }
//        return movie.toDto();
//    }

    public void deleteMovieById(Long id) {
    }


}
