package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.Movie;

import java.util.List;

public interface CommentService {
    Comment addComment(String title,String content, int movieId);
    void deleteComment(int commentId);
    List<Comment> getComments(int movieId);
}
