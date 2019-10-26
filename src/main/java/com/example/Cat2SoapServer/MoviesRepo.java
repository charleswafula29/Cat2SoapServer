package com.example.Cat2SoapServer;

import localhost._8080.movies.Category;
import localhost._8080.movies.Movie;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class MoviesRepo {

    private static final Map<String, Movie> moviesMAP = new HashMap<>();

    @PostConstruct
    public void initData() {

        Movie Rue = new Movie();
        Rue.setName("Rue's Movie");
        Rue.setActor("Ruth");
        Rue.setCapital("100,000,000 Dollars");
        Rue.setCategory(Category.SYFY);
        Rue.setYearReleased("May 2019");

        moviesMAP.put(Rue.getName(),Rue);


        Movie spiderman = new Movie();
        spiderman.setName("Spiderman: Far from home");
        spiderman.setActor("Tom Holland ft  Zendaya");
        spiderman.setCapital("1,000,000,000 Dollars");
        spiderman.setCategory(Category.THRILLER);
        spiderman.setYearReleased("May 2019");

        moviesMAP.put(spiderman.getName(),spiderman);

        Movie superman = new Movie();
        superman.setName("Superman v Batman");
        superman.setActor("Henry Cavill ft Bruce Wayne");
        superman.setCapital("12,000,000,000 Dollars");
        superman.setCategory(Category.HORROR);
        superman.setYearReleased("April 2018");

        moviesMAP.put(superman.getName(),superman);

    }

    public Movie findMovie(String name){
        Assert.notNull(name, "The movie's name must not be null");
        return moviesMAP.get(name);
    }

}
