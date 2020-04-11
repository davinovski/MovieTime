package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUserIdException;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import mk.ukim.finki.seminarska.repository.CommentRepository;
import mk.ukim.finki.seminarska.repository.MovieRepository;
import mk.ukim.finki.seminarska.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public CommentServiceImpl(CommentRepository commentRepository, MovieRepository movieRepository, ApplicationUserRepository applicationUserRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public Comment addComment(String title,String content, int movieId, double stars, String email) {
        Movie movie=movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
        ApplicationUser user= applicationUserRepository.findByUsername(email);
        Comment comment=new Comment(title,content,movie, stars, user);
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
