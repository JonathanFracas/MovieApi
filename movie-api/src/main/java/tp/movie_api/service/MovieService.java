package tp.movie_api.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tp.movie_api.model.Movie;
import tp.movie_api.dto.MovieDTO;
import tp.movie_api.repos.MovieRepository;
import tp.movie_api.exception.NotFoundException;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findAll() {
        final List<Movie> movies = movieRepository.findAll(Sort.by("id"));
        return movies.stream()
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .toList();
    }

    public MovieDTO get(final Long id) {
        return movieRepository.findById(id)
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final MovieDTO movieDTO) {
        final Movie movie = new Movie();
        mapToEntity(movieDTO, movie);
        return movieRepository.save(movie).getId();
    }

    public void update(final Long id, final MovieDTO movieDTO) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(movieDTO, movie);
        movieRepository.save(movie);
    }

    public void delete(final Long id) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        movieRepository.delete(movie);
    }

    private MovieDTO mapToDTO(final Movie movie, final MovieDTO movieDTO) {
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setImdbId(movie.getImdbId());
        return movieDTO;
    }

    private Movie mapToEntity(final MovieDTO movieDTO, final Movie movie) {
        movie.setName(movieDTO.getName());
        movie.setDirector(movieDTO.getDirector());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setImdbId(movieDTO.getImdbId());
        return movie;
    }

}
