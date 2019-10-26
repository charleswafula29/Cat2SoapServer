package com.example.Cat2SoapServer;

import localhost._8080.movies.GetMovieRequest;
import localhost._8080.movies.GetMovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MoviesEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/movies";

    private MoviesRepo moviesRepo;

    @Autowired
    public MoviesEndpoint(MoviesRepo moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieRequest")
    @ResponsePayload
    public GetMovieResponse getMovie(@RequestPayload GetMovieRequest request){
        GetMovieResponse response = new GetMovieResponse();
        response.setMovie(moviesRepo.findMovie(request.getName()));
        return response;
    }
}
