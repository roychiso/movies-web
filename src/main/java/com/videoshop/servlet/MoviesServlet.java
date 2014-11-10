package com.videoshop.servlet;

import com.videoshop.movies.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="MoviesServlet", urlPatterns = "/list")
public class MoviesServlet extends HttpServlet {

    private MoviesService moviesService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.moviesService = new DefaultMoviesService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String movieTitle = request.getParameter("movieTitle");
        try{
            this.moviesService.add(new Movie(movieTitle));
            List<Movie> theMovieList = this.moviesService.list();
            request.setAttribute("movies", theMovieList);
            request.setAttribute("listSize", theMovieList.size());
        } catch (MoviesService.MovieServiceException e){
            //TODO: error handling
        }

        RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> theMovieList = this.moviesService.list();
        request.setAttribute("movies", theMovieList);
        request.setAttribute("listSize", theMovieList.size());
        RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doDelete(req, resp);
        System.out.println("ENTRO DELETE");
        List<Movie> theMovieList = this.moviesService.list();
        request.setAttribute("movies", theMovieList);
        request.setAttribute("listSize", theMovieList.size());
        RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
        rd.forward(request, response);
    }
}

