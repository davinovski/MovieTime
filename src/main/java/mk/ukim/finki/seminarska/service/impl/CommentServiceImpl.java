package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.repository.CommentRepository;
import mk.ukim.finki.seminarska.repository.MovieRepository;
import mk.ukim.finki.seminarska.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;

    public CommentServiceImpl(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Comment addComment(String title,String content, int movieId, float stars) {
        Movie movie=movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
        Comment comment=new Comment(title,content,movie, stars);
        return this.commentRepository.save(comment);
    }


    @Override
    public void deleteComment(int commentId) {
        this.commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> getComments(int movieId) {
        Movie movie=this.movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
        return this.commentRepository.getAllCommentsByMovie(movie);
}
}
