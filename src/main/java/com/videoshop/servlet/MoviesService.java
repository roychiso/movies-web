package com.videoshop.servlet;


import com.videoshop.movies.Movie;

import java.util.List;

public interface MoviesService {

    List<Movie> list();

    void add(Movie movie) throws MovieServiceException;

    void delete(Movie movie) throws MovieServiceException;

    void update(Movie movie) throws MovieServiceException;


    class MovieServiceException extends Exception{


    }

}