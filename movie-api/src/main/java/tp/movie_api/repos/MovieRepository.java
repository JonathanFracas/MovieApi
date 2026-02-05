package tp.movie_api.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.movie_api.domain.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
