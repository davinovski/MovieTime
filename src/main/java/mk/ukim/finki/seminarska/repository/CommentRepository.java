package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query("select c from Comment c WHERE c.movieId = ?1")
    List<Comment> getAllCommentsByMovie(int movieId);
}
