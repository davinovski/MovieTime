package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(int movieId,String content);
    List<Comment> getAll(int movieId);
    void deleteComment(int commentId);
}
