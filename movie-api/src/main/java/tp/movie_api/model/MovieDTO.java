package tp.movie_api.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;


public class MovieDTO {

    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String director;

    private LocalDate releaseDate;

    private Long imdbId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getImdbId() {
        return imdbId;
    }

    public void setImdbId(final Long imdbId) {
        this.imdbId = imdbId;
    }

}
