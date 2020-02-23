package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.repository.CommentRepository;
import mk.ukim.finki.seminarska.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/comments")
public class CommentApi {
    private final CommentService commentService;

    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comment addComment(@RequestParam("movieId") int movieId,
                          @RequestParam("content")  String content)
    {
        return this.commentService.addComment(movieId,content);
    }

    @GetMapping("/{movieId}/comments")
    public List<Comment> getComments(@PathVariable int movieId){
        return this.commentService.getAll(movieId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable int commentId){
        this.commentService.deleteComment(commentId);
    }



}
