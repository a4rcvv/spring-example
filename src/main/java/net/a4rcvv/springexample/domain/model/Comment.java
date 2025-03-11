package net.a4rcvv.springexample.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import net.a4rcvv.springexample.domain.vo.CommentBody;
import net.a4rcvv.springexample.domain.vo.CommentId;
import net.a4rcvv.springexample.domain.vo.TimeStamp;

@Getter
public class Comment extends TimeStampedBaseModel<CommentId> {
  @NotNull
  private CommentBody body;

  public Comment(@NotNull CommentId id, @NotNull TimeStamp timeStamp, @NotNull CommentBody body) {
    super(id, timeStamp);
    this.body = body;
  }
}
