package com.videoshop.servlet;


import com.videoshop.movies.Movie;
import com.videoshop.movies.MoviesList;

import java.util.List;

public class DefaultMoviesService implements MoviesService{

    private MoviesList movieList;

    public DefaultMoviesService(){
        this.movieList = new MoviesList();
        Movie starWars = new Movie("Star Wars");
        Movie batman = new Movie("Batman");
        movieList.addOrUpdate(starWars);
        movieList.addOrUpdate(batman);
    }

    @Override
    public List<Movie> list() {
        synchronized (this){
            return this.movieList.list();
        }
    }

    @Override
    public void add(Movie movie) throws MovieServiceException{
        validateMovie(movie);
        synchronized (this){
            this.movieList.addOrUpdate(movie);
        }
    }

    @Override
    public void delete(Movie movie) throws MovieServiceException{
        throw new UnsupportedOperationException("delete action is not supported yet.");
    }

    @Override
    public void update(Movie movie) throws MovieServiceException{
        throw new UnsupportedOperationException("update action is not supported yet.");
    }

    static void validateMovie(Movie movie){
        if(null == movie){
            throw new IllegalArgumentException("Movie can't be null");
        }
        if(movie.getTitle().isEmpty()){
            throw new IllegalArgumentException("Movie Title Can't be empty");
        }
    }
}