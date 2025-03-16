package net.a4rcvv.springexample.domain.repository;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import net.a4rcvv.springexample.domain.model.Comment;
import net.a4rcvv.springexample.domain.vo.CommentId;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
  List<Comment> find(@NotNull @Min(value = 1) int limit, @NotNull @Min(value = 0) int offset);

  Optional<Comment> findByCommentId(@NotNull CommentId id);

  void save(@NotNull Comment comment);

}
