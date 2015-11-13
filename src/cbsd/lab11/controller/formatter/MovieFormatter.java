package cbsd.lab11.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import cbsd.lab11.entity.Movie;
import cbsd.lab11.service.MovieService;



@Component
public class MovieFormatter implements Formatter<Movie> {
    @Autowired
    MovieService movieService;
    @Override
    public Movie parse(String s, Locale locale) throws ParseException {

        return movieService.getMovieById(Integer.valueOf(s));
   
    }

    @Override
    public String print(Movie movie, Locale locale) {

        return movie.getName();
    }

	
}
