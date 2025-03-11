package net.a4rcvv.springexample.presentation.contoroller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.a4rcvv.springexample.domain.model.Comment;
import net.a4rcvv.springexample.domain.repository.CommentRepository;
import net.a4rcvv.springexample.domain.vo.CommentBody;
import net.a4rcvv.springexample.domain.vo.CommentId;
import net.a4rcvv.springexample.domain.vo.TimeStamp;
import net.a4rcvv.springexample.presentation.request.CommentRequest;
import net.a4rcvv.springexample.presentation.response.CommentResponse;
import net.a4rcvv.springexample.presentation.response.QueryResult;

@RestController
@RequestMapping("/comments")
public class CommentController {
  // 本当はCommentServiceを実装するべきです
  private final CommentRepository commentRepository;

  public CommentController(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @GetMapping
  public QueryResult<CommentResponse> getComments() {
    List<Comment> comments = commentRepository.find(10, 0);
    List<CommentResponse> commentResponses = comments.stream()
        .map(comment -> new CommentResponse(comment.getId().id(), comment.getBody().body(),
            comment.getTimeStamp().createdAt(), comment.getTimeStamp().updatedAt()))
        .toList();
    // 本当はコメントの総数を取得するべきです
    return new QueryResult<>(commentResponses, comments.size());
  }

  @PostMapping
  public void postComment(@RequestBody CommentRequest commentRequest) {
    // 本当はCommentServiceを実装するべきです
    CommentId id = new CommentId(UUID.randomUUID());
    TimeStamp timeStamp = TimeStamp.now();
    CommentBody body = new CommentBody(commentRequest.body());
    Comment comment = new Comment(id, timeStamp, body);
    commentRepository.save(comment);

  }
}
