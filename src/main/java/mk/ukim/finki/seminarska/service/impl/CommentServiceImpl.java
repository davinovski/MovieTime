package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.repository.CommentRepository;
import mk.ukim.finki.seminarska.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addComment(int movieId, String content) {
        Comment comment=new Comment(movieId,content);
        return this.commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll(int movieId) {
        return this.commentRepository.getAllCommentsByMovie(movieId);
    }

    @Override
    public void deleteComment(int commentId) {
        this.commentRepository.deleteById(commentId);
    }
}
